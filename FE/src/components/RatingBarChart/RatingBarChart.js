// RatingBarChart.js
import React, { useState, useEffect } from 'react';
import { BarChart } from '@mui/x-charts/BarChart';
import { fetchRatingData } from '../RatingDataCall';


const RatingBarChart = ({ token }) => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const colors = ['#2A5E78']
  useEffect(() => {
    const fetchData = async () => {
      const jsonData = await fetchRatingData(token);
      setData(jsonData);
      setLoading(false);
    };

    fetchData();
  }, [token]);
console.log(data);
  return (
    <div style={{ margin: '50px', width: '500px', border: '2px solid #ccc', borderRadius: '10px', padding: '10px' }}>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <BarChart
        series={[
          {
            data: data.map(item => item.count_of_ratings),
          },
        ]}
        height={490}
        xAxis={[
          {
            data: data.map(item => item.rating),
            scaleType: 'band',
          },
        ]}
        margin={{ top: 10, bottom: 30, left: 40, right: 10 }}
        colors={colors}
      />      
      )}
    </div>
  );
};
export default RatingBarChart;

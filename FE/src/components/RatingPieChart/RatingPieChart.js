// RatingPieChart.js
import React, { useState, useEffect } from 'react';
import { PieChart, pieArcLabelClasses } from '@mui/x-charts';
import { fetchRatingData } from '../RatingDataCall';
import StarOutlinedIcon from '@mui/icons-material/StarOutlined';
const RatingPieChart = ({ token }) => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const colors = ['#C6EA58', '#F6AA55', '#9FDEF1', '#2A5E78'];

  useEffect(() => {
    const fetchData = async () => {
      const jsonData = await fetchRatingData(token);
      setData(jsonData);
      setLoading(false);
    };

    fetchData();
  }, [token]);

  return data.length && (
    <div style={{ margin: '50px', width: '700px', border: '2px solid #ccc', borderRadius: '10px', padding: '10px' }}>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <PieChart 
          height={500} width={700}
          colors={colors}
          series={[
            {
              arcLabel: (item) => `${item.label} (${item.value})`,
              data: data.map((item) => ({
                value: item.count_of_ratings,
                color: colors[item.rating - 1],
                label: item.rating.toString(),
              })),
            },
          ]}
          
          sx={{
            [`& .${pieArcLabelClasses.root}`]: {
              fill: 'white',
              fontWeight: 'bold',
            },
          }}
        />
      )}
    </div>
  );
};

export default RatingPieChart;

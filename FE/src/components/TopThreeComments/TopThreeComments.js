// TopThreeComments.js
import React, { useState, useEffect } from 'react';
import { API } from '../constant';

const TopThreeComments = ({ token }) => {
  const [topComments, setTopComments] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchTopComments = async () => {
      try {
        const response = await fetch(`${API}/authenticate/feedbacks`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });

        if (!response.ok) {
          console.log('Error fetching comments:', response.status);
          return;
        }

        const jsonData = await response.json();
        console.log(jsonData);
        setTopComments(jsonData.slice(0, 3)); // Assuming your comments are at the root level
      } catch (error) {
        console.error('Error fetching comments:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchTopComments();
  }, [token]);

  return (
    <div style={{ margin: '50px', padding: '20px', border: '2px solid #ccc', borderRadius: '10px' }}>
      <h2>Top 3 Comments</h2>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <ul>
          {topComments.map((comment, index) => (
            <li style= {{marginTop:'20px'}} key={index}>{comment.comment}</li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default TopThreeComments;

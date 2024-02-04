// RatingApi.js
import { API } from './constant';

export const fetchRatingData = async (token) => {
  try {
    const response = await fetch(`${API}/authenticate/rating_count`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    if (!response.ok) {
      console.log('Error fetching data:', response.status);
      return [];
    }

    const jsonData = await response.json();
    return jsonData;
  } catch (error) {
    console.error('Error fetching data:', error);
    return [];
  }
};

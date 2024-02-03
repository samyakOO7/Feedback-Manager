import React, { useState }  from "react";
import RadioGroupRating from "./RadioGroupRating";
import { TextField, Typography, Button} from "@mui/material";
import "./Feedback.css";
import { useParams } from 'react-router-dom';
import { API } from '../constant';
import Loading from "../Loading/Loading"

import SentimentVerySatisfiedIcon from '@mui/icons-material/SentimentVerySatisfied';
 
const Feedback = () => {
    const [rating, setRating] = useState(null);
    const [experience, setExperience] = useState("");
    const [success, setSuccess] = useState(null); 
    const [loading, setLoading] = useState(false);

    const { id } = useParams();
    console.log(id, API)

    const handleChange = (value) => {
        setRating(value);
    }

    const handlePostRequest = async () => {
        setLoading(true);
        try {
          const response = await fetch(`${API}/feedback`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({rating: rating, comment: experience, userId: id}),
          });
    
          if (!response.ok) {
            console.log('error occured while calling api');
            throw new Error('Network response was not ok');
          }
          // const data = await response.json();
          setSuccess(true);
          // Reset the form after submission
          setRating(null);
          setExperience("");
        } catch (error) {
          console.error('Error during POST request:', error);
          setSuccess(false);
        }
        setLoading(false);
    };

    const handleSubmit = (e) => {
      e.preventDefault();
      console.log("Rating:", rating, "Experience:", experience);
      handlePostRequest();
    };

    return (
        <>
            {loading && <Loading />}
            {!success ? 
                <div className="feedback_container">
                    <Typography variant="h4" gutterBottom>
                    Feedback Form
                    </Typography>
            
                    <RadioGroupRating value={rating} setValue={handleChange} />
            
                    <TextField
                    id="outlined-basic"
                    label="Your Experience"
                    variant="outlined"
                    multiline
                    rows={4}
                    value={experience}
                    onChange={(e) => setExperience(e.target.value)}
                    color="success"
                    />
            
                    <Button variant="outlined" color="success" onClick={handleSubmit}>
                    Submit
                    </Button>
                </div>
                    : 
                <ThankYou />
            }
        </>
    );
}

const ThankYou = () => {
    return <div className="feedback__thank__you__cont">Thank You For Your Feedback. <SentimentVerySatisfiedIcon color="success" /></div>
}
 
export default Feedback;
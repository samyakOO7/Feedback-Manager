import React, { useState }  from "react";
import RadioGroupRating from "./RadioGroupRating";
import { TextField, Typography, Button} from "@mui/material";
import "./Feedback.css";

import SentimentVerySatisfiedIcon from '@mui/icons-material/SentimentVerySatisfied';
 
const Feedback = () => {
    const [rating, setRating] = useState(null);
    const [experience, setExperience] = useState("");
    const [success, setSuccess] = useState(null); 

    const handleChange = (value) => {
        setRating(value);
    }

    const handleSubmit = (e) => {
      e.preventDefault();
      console.log("Rating:", rating, "Experience:", experience);
      // Reset the form after submission
      setRating(null);
      setExperience("");
      setSuccess(true);
    };

    return (
        <>
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
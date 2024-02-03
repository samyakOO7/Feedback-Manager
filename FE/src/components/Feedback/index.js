import React, { useState }  from "react";
import RadioGroupRating from "./RadioGroupRating";

const Feedback = () => {
    const [rating, setRating] = useState(null);
    return(
        <div><RadioGroupRating value={rating} setValue={setRating} /></div>
    )
}

export default Feedback;
import React from 'react';
import { TailSpin } from 'react-loader-spinner';
import "./Loading.css";

const Loading = () => (
  <div className='loading__cont'>
    <div className='loading'>
      <TailSpin color="#00BFFF" height={80} width={80} />
    </div>
  </div>
);

export default Loading;
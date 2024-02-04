import React from 'react';
import QRCodeGenerator from './QRCodeGenerator';
import "./Dashboard.css";
import { useNavigate } from 'react-router-dom';
import RatingPieChart from '../RatingPieChart/RatingPieChart';
import RatingBarChart from '../RatingBarChart/RatingBarChart';
const Dashboard = () => {
  const navigate = useNavigate();
  // token will be used when fetching dashboard data.
  const token = sessionStorage.getItem('token');
  
  React.useEffect(() => {
    if(!token) {
      navigate("../login");
    }
  }, [navigate, token])

  const id = sessionStorage.getItem('id');
  const organisationName = sessionStorage.getItem('organisationName');
  const qrCodeData = window.location.origin + '/feedback/' + id;
  return (
    <>
    <div className='dasboard__cont'>
      <QRCodeGenerator data={qrCodeData} retailer={organisationName} />
      </div>
    <div className='row'>
    <RatingPieChart token={token}/>
    <RatingBarChart token={token}/>
    </div>
    </>
  );

};

export default Dashboard;
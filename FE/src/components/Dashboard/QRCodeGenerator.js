import React from 'react';
import QRCode from 'react-qr-code';
import html2canvas from 'html2canvas';
import download from 'downloadjs';
import { Button, Typography } from '@mui/material';
import FileDownloadOutlinedIcon from '@mui/icons-material/FileDownloadOutlined';

const QRCodeGenerator = ({ data, retailer }) => {
  const downloadQRCode = () => {
    // Get the container element
    const container = document.getElementById('qr-code');

    // Use html2canvas to capture the container as an image
    html2canvas(container).then((canvas) => {
      // Convert the canvas to a data URL
      const imageUrl = canvas.toDataURL();

      // Use downloadjs to trigger the download
      download(imageUrl, 'qr-code.png', 'image/png');
    });
  };

  return (
    <>
      <Typography variant='h4'>{retailer} 
    </Typography>
      <div id="qr-code-container">
        <div id="qr-code"><QRCode  value={data} />
        </div >
       <div className='download'>
        <Button onClick={downloadQRCode}><FileDownloadOutlinedIcon style={{marginTop:'10px', fontSize:'30px'}}/></Button>
        </div>
      </div>
      
    </>
  );
};

export default QRCodeGenerator;
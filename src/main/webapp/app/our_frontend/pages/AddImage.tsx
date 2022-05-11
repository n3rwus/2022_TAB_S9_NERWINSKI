import { Box, Grid } from '@mui/material';
import React, { useState } from 'react';
import BasicDatePicker from '../components/DatePicker';
import Navbar from '../components/Navbar';
import SaveButton from '../components/SaveButton';
import SelectBasic from '../components/SelectBasic';
import SelectTags from '../components/SelectTags';
import MyTextField from '../components/TextField';
import UploadImageButton from '../components/UploadImageButton';

const AddImage = () => {
  return (
    <React.Fragment>
      <Navbar centerText={'Upload images'} />
      <Box sx={{ flexGrow: 1, width: '90%', mx: 'auto', mt: '100px' }}>
        <Grid container spacing={3} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          <Grid item xs={12} sm={6} md={6}>
            <MyTextField id={'title'} label={'Title'} fullwidth={true} />
          </Grid>
          <Grid item xs={12} sm={6} md={6}>
            <SelectBasic />
          </Grid>
          <Grid item xs={12} sm={6} md={6}>
            <MyTextField id={'description'} label={'Description'} fullwidth={true} multiline={true} maxRows={3} />
          </Grid>
          <Grid item xs={12} sm={6} md={6}>
            <SelectTags />
          </Grid>
          <Grid item xs={12} sm={12} md={4} textAlign="center">
            <BasicDatePicker />
          </Grid>
          <Grid item xs={12} sm={12} md={4} textAlign="center">
            <UploadImageButton multiple={true} />
          </Grid>
          <Grid item xs={12} sm={12} md={4} textAlign="center">
            <SaveButton disabled={true} />
          </Grid>
        </Grid>
      </Box>
      <hr style={{ margin: '30px' }} />
    </React.Fragment>
  );
};

export default AddImage;

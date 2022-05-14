import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Grid } from '@mui/material';

interface iUploadImageButton {
  image: File;
  index: number;
}

const UploadImageCard = (props: iUploadImageButton) => {
  const { image, index } = props;

  return (
    <Grid item xs={12} sm={6} md={4}>
      <Card sx={{ maxWidth: 345, mx: 'auto', mb: '50px' }}>
        <CardMedia component="img" height="240" image={URL.createObjectURL(image)} alt="green iguana" />
        <CardContent>
          <Typography variant="h5" component="div" textAlign={'center'}>
            {'Image ' + (index + 1)}
          </Typography>
        </CardContent>
      </Card>
    </Grid>
  );
};

export default UploadImageCard;

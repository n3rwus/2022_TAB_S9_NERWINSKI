import { Button } from '@mui/material';
import React, { useState } from 'react';
import { styled } from '@mui/material/styles';

interface iUploadImageButton {
  multiple: boolean;
}

const Input = styled('input')({
  display: 'none',
});

const UploadImageButton = (props: iUploadImageButton) => {
  const [selectedImage, setSelectedImage] = useState(null);

  const { multiple } = props;

  return (
    <React.Fragment>
      <label htmlFor="contained-button-file" style={{ width: '250px', height: '56px' }}>
        <Input
          accept="image/*"
          id="contained-button-file"
          multiple={multiple}
          type="file"
          onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
            setSelectedImage(event.target.files[0]);
          }}
        />
        <Button variant="contained" component="span" fullWidth sx={{ height: '56px' }}>
          {'Upload'}
        </Button>
      </label>
      {selectedImage && <img src={URL.createObjectURL(selectedImage)} alt={'Dupa'} loading="lazy" />}
    </React.Fragment>
  );
};

export default UploadImageButton;

import { Button } from '@mui/material';
import React, { useState } from 'react';
import { styled } from '@mui/material/styles';

interface iSaveButton {
  disabled?: boolean;
}
const Input = styled('input')({
  display: 'none',
});

const SaveButton = (props: iSaveButton) => {
  const { disabled } = props;

  return (
    <React.Fragment>
      <Button variant="contained" component="span" disabled={disabled} sx={{ width: '250px', height: '56px' }}>
        {'Save'}
      </Button>
    </React.Fragment>
  );
};

export default SaveButton;

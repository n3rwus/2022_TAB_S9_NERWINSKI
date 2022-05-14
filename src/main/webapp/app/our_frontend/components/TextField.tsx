import * as React from 'react';
import TextField from '@mui/material/TextField';

interface iTextField {
  id?: string;
  label?: string;
  fullwidth?: boolean;
  multiline?: boolean;
  maxRows?: number;
  rows?: number;
}

const MyTextField = (props: iTextField) => {
  const { id, label, fullwidth, multiline, maxRows, rows } = props;

  return (
    <React.Fragment>
      <TextField id={id} label={label} multiline={multiline} maxRows={maxRows} fullWidth={fullwidth} rows={rows} />
    </React.Fragment>
  );
};

export default MyTextField;

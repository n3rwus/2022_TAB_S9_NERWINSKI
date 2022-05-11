import * as React from 'react';
import TextField from '@mui/material/TextField';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';

const BasicDatePicker = () => {
  const [value, setValue] = React.useState<Date | null>(null);

  return (
    <LocalizationProvider dateAdapter={AdapterDateFns}>
      <DatePicker
        label="Date"
        InputProps={{ sx: { minWidth: '250px' } }}
        value={value}
        onChange={newValue => {
          setValue(newValue);
        }}
        renderInput={params => <TextField {...params} />}
      />
    </LocalizationProvider>
  );
};

export default BasicDatePicker;

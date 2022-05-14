import * as React from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';

const SelectBasic = () => {
  const [folder, setFolder] = React.useState('');

  const handleChange = (event: SelectChangeEvent) => {
    setFolder(event.target.value);
  };

  return (
    <Box sx={{ minWidth: 100 }}>
      <FormControl fullWidth>
        <InputLabel id="select-basic-label">{'Folder'}</InputLabel>
        <Select labelId="select-basic-label" id="select-basic" value={folder} label="Folder" onChange={handleChange}>
          <MenuItem value={'Spain'}>{'Spain'}</MenuItem>
          <MenuItem value={'Trips'}>{'Trips'}</MenuItem>
        </Select>
      </FormControl>
    </Box>
  );
};

export default SelectBasic;

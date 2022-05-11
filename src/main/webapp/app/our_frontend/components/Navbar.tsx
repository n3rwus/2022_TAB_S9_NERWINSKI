import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import AccountCircle from '@mui/icons-material/AccountCircle';
import MenuItem from '@mui/material/MenuItem';
import Menu from '@mui/material/Menu';
import { Link } from '@mui/material';
import { Redirect } from 'react-router-dom';

interface iNavbar {
  centerText?: string;
}

export default function Navbar(props: iNavbar) {
  const [auth, setAuth] = React.useState(true);
  const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);
  const [redirect, setRedirect] = React.useState(false);
  const [linkTo, setLinkTo] = React.useState('');

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setAuth(event.target.checked);
  };

  const handleMenu = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleClick = event => {
    handleClose();
    const { myValue } = event.currentTarget.dataset;
    // eslint-disable-next-line no-console
    console.log(myValue);
    if (myValue) {
      setLinkTo(myValue);
      setRedirect(true);
    }
  };

  const { centerText } = props;

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" sx={{ backgroundColor: '#1976d2' }}>
        <Toolbar>
          <Link href={'/mainPage'} underline={'none'}>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1, color: '#FFF' }}>
              {'Picture Drive App'}
            </Typography>
          </Link>
          <Typography variant="h6" component="div" textAlign={'center'} sx={{ flexGrow: 1 }}>
            {centerText}
          </Typography>
          {auth && (
            <div>
              <IconButton
                size="large"
                aria-label="account of current user"
                aria-controls="menu-appbar"
                aria-haspopup="true"
                onClick={handleMenu}
                sx={{
                  color: '#FFF',
                }}
              >
                <AccountCircle />
              </IconButton>
              <Menu
                id="menu-appbar"
                anchorEl={anchorEl}
                anchorOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                keepMounted
                transformOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                open={Boolean(anchorEl)}
                onClose={handleClose}
              >
                <MenuItem onClick={handleClick} data-my-value={'/addPicture'}>
                  {'Add Picture'}
                </MenuItem>
                <MenuItem onClick={handleClose}>{'Profile'}</MenuItem>
                <MenuItem onClick={handleClose}>{'Gallery'}</MenuItem>
                <MenuItem onClick={handleClose}>{'Logout'}</MenuItem>
              </Menu>
            </div>
          )}
        </Toolbar>
      </AppBar>
      {redirect ? <Redirect push to={linkTo} /> : null}
    </Box>
  );
}

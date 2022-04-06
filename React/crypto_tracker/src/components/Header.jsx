import { AppBar, Container, createTheme, MenuItem, Select, Toolbar, Typography, ThemeProvider } from '@material-ui/core';
import { makeStyles } from '@material-ui/styles';

import React from 'react'
import { useNavigate } from 'react-router-dom';
import { CryptoState } from '../CryptoContext';

const useStyles = makeStyles((theme) => ({
  title: {
    flex: 1,
    color: "gold",
    fontFamily: 'Montserrat',
    fontWeight: 'bold',
    cursor: 'pointer',
  }
}));

export const Header = () => {

  const classes = useStyles();
  const navigate = useNavigate();

  const { currency, setCurrency } = CryptoState();
  console.log(currency);

  const darkTheme = createTheme({
    palette: {
      primary: {
        main: '#fff',
      },
      type: 'dark',
    }
  })

  return (
    <ThemeProvider theme={darkTheme}>
      <AppBar color='transparent' position='static'>
        <Container>
          <Toolbar>

            <Typography onClick={() => navigate('/')} className={classes.title} variant='h6'>
              Crypto Tracker
            </Typography>

            <Select
              variant='outlined'
              style={{
                width: '100',
                height: '40',
                marginRight: '15',

              }}
              value={currency}
              onChange={(e) => setCurrency(e.target.value)}
            >

              <MenuItem value={'USD'}>USD</MenuItem>
              <MenuItem value={'INR'}>INR</MenuItem>

            </Select>

          </Toolbar>
        </Container>
      </AppBar>
    </ThemeProvider>
  );
}

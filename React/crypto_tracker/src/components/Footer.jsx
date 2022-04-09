import { AppBar, Container, makeStyles, Toolbar } from '@material-ui/core';
import React from 'react'

export const Footer = () => {

    const useStyles = makeStyles((theme) => ({
        footer: {
            backgroundColor: '#14161A',
            color: '#fff',
            minHeight: '50px',
            padding: '20px',
            textAlign: 'center',

        }
    }));
    const classes = useStyles();

    return (
        <div className={classes.footer}>
            <div>Made with ❤️ by <a href='https://github.com/kriptonian1'>Kriptonian</a> </div>

        </div>
    )
}

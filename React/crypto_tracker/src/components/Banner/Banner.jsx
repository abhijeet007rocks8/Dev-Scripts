import React from 'react'
import { makeStyles } from '@material-ui/core/styles'
import { Container, Typography } from '@material-ui/core';
import { Carousel } from './Carousel';

const useStyles = makeStyles((theme) => ({
    banner: {
        backgroundImage: 'url(./banner2.jpg)',
    },
    bannerContent: {
        height: '400',
        display: 'flex',
        flexDirection: 'column',
        paddingTop: 25,
        paddingBottom: 25,
        justifyContent: 'space-around',
    },
    tagline: {
        display: 'flex',
        flexDirection: 'column',
        height: '40%',
        justifyContent: 'center',
        textAlign: 'center',
        paddingBottom: 100, // may need to change this
    }
}));

const Banner = () => {

    const classes = useStyles();

    return (
        <div className={classes.banner}>
            <Container className={classes.bannerContent}>
                <div className={classes.tagline}>
                    <Typography
                        variant='h2'
                        style={{
                            fontWeight: 'bold',
                            marginBottom: 15,
                            fontFamily: "Montserrat",
                        }}
                    >
                        Crypto Tracker
                    </Typography>
                    <Typography
                        variant='subtitle2'
                        style={{
                            color: 'darkgrey',
                            textTransform: 'capitalize',
                            fontFamily: "Montserrat",
                        }}
                    >
                        Track the Crypto Currency prices and information easily.
                    </Typography>
                </div>
                <Carousel />
            </Container>
        </div>
    )
}

export default Banner
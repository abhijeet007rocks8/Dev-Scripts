import React from 'react';
import {Card,CardActions,CardActionArea,CardContent,CardMedia,Button,Typography} from "@material-ui/core";
import classNames from 'classnames';

import useStyles from "./styles.js"


function NewsCard({article:{description,publishedAt,source,title,url,urlToImage},i,activeArticle}) {

    const classes=useStyles();

  return (
    <Card className={classNames(classes.card,activeArticle===i ? classes.activeCard:null)}>
        <CardActionArea href={url} target="_blank">
            <CardMedia className={classes.media} image={urlToImage ||"https://www.pikpng.com/pngl/m/182-1827833_news-logo-png-logo-news-clipart.png"}/>
                <div className={classes.details}>
                    <Typography variant="body2" color ="textSecondary" component ="h2">{(new Date(publishedAt)).toDateString()}</Typography>
                    <Typography variant="body2" color ="textSecondary" component ="h2">{source.name}</Typography>
                </div>
                <Typography className={classes.title}  gutterBottom variant ="h5">{title}</Typography>
            <CardContent>
                <Typography  variant="body2" color ="textSeconadary" component="p">{description}</Typography>
            </CardContent>
        </CardActionArea>

        <CardActions>
            <Button href={url} size = "small" color = "primary">Learn More</Button>
            <Typography variant ="h5" color ="textSecondary">{i+1}</Typography>
        </CardActions>

    </Card>
  )
}

export default NewsCard
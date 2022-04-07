import { makeStyles } from '@material-ui/core';
import React from 'react'

export const SelectButton = ({ children, selected, onClick }) => {

    const useStyle = makeStyles((theme) => ({
        selectButton: {
            border: "1px solid gold",
            borderRadius: 5,
            padding: 10,
            paddingLeft: 20,
            paddingRight: 20,
            fontFamily: "Montserrat",
            cursor: "pointer",
            backgroundColor: selected ? "gold" : "",
            color: selected ? "black" : "",
            fontWeight: selected ? 700 : 500,
            "&:hover": {
                backgroundColor: "gold",
                color: "black",
            },
            width: "22%",
            //   margin: 5,
        },
    }));

const classes = useStyle();

return (
    <span
        onClick={onClick}
        className={classes.selectButton}
    >
        {children}
    </span>
)
}

import React from 'react'

const Delete = (props) => {
    const {n} = props ;
    var x = document.getElementById("show").rows.length;
    if(x>1)
    document.getElementById("show").deleteRow(x-1) ;
    else
    window.alert("Sorry Can't delete") ;
}

export default Delete
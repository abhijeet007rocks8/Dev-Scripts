import React, { useState } from 'react';
import "./style.css" ;

const Counter = () => {

    const [count, setCount ] = useState(0) ;
    const [colorval, setColorval] = useState({
        color:"black",
        backgroundColor:"white"
    });

    const Increment = () => {
        setCount(count+1) ;
    }

    const Decrement=() => {
        if(count>0)
        {
            setCount(count-1) ;
        }
    }

    const Reset = () => {
        setCount(0) ;
    }

    const Darkmode = () => {
        setColorval({
            color:"white",
            backgroundColor:"black"
        }) ;
    }
    const Lightmode = () => {
        setColorval({
            color:"black",
            backgroundColor:"white"
        }) ;
    }

    return (
        <div className="body-page" style={colorval}> 
            <nav className="navbar navbar-light bg-light">
                    <div className="container-fluid">
                        <button className='dark-mode' onClick={Darkmode} >Dark Mode</button>
                        <button className='light-mode' onClick={Lightmode}>Light Mode</button>
                    </div>
            </nav>
            <div className="container" >
                <h1 className='counter'> COUNTER</h1>
                <h2 className='val-count'>{count}</h2>
                <button className='button-decrement' onClick={Decrement}>- Decrement</button>    
                <button className='button-reset' onClick={Reset}>Reset</button>    
                <button className='button-increment' onClick={Increment}>Increment +</button>    
            </div>
        </div>
    ) ;
}

export default Counter ;
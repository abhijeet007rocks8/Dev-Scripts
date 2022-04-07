import React, { createContext, useContext, useEffect } from 'react'
import { useState } from 'react'

const Crypto = createContext()

export const CryptoContext = ({ children }) => {
    const [currency, setCurrency] = useState("INR");
    const [symbol, setSymbol] = useState("₹");

    useEffect(() => {
        if(currency === "INR") {
            setSymbol("₹");
        }
        else if (currency === "USD") {
            setSymbol("$");
        }
    }, [currency]);
    

    return (
        <Crypto.Provider value={{currency,symbol, setCurrency}}>
            {children}
        </Crypto.Provider>
    );
}

export const CryptoState = () => {
    return useContext(Crypto)
}

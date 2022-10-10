import React from 'react'
import { useEffect,useState } from 'react'
import axios from "axios";


function LocationTracker() {
    const [location,setLocation]=useState({
        loaded:false,
        coordinates:{
            lat:"",
            long:""
        }
    })
    const [add,setAdd]=useState({
        address_line1:"",
        address_line2:"",
        city:"",
        country:""
    })
    function setAddress(){
       const {data}= axios.get(`https://api.geoapify.com/v1/geocode/reverse?lat=${location.coordinates.lat}&lon=${location.coordinates.long}&apiKey=5568cf47022b4308a3e705987a8b12e3`).then(res=>{
        setAdd({
            address_line1:res.data.features[0].properties.address_line1,
            address_line2:res.data.features[0].properties.address_line2,
            city:res.data.features[0].properties.city,
            country:res.data.features[0].properties.country
        })
        //console.log(res.data.features[0].properties.address_line1)
       })
       
    }
    const onSuccess=location=>{
        setLocation({
            loaded:true,
            coordinates:{
                lat: location.coords.latitude,
                long:location.coords.longitude,
            }
        })
        
    }
    const onError=error=>{
        setLocation({
            loaded:true,
            error
        })
    }
    useEffect(()=>{
        if(!("geolocation" in navigator)){
            onError({
                code:0,
                message:"GeoLocation not supported in this area"
            })
        }
        navigator.geolocation.getCurrentPosition(onSuccess,onError);
    },[])
  return (
    <div>
        
        <h1 style={{"color":"#1c6cad"}}>
            React Location Tracker App
        </h1>
        <div style={{"width":"100vw","height":"100vh","display":"flex","flexDirection":"column","justifyContent":"center","alignItems":"center"}}>

            <div>{add.address_line1}</div>
            <div>{add.address_line2}</div>
            <div>{add.city}</div>
            <div>{add.country}</div>
            <button style={{"height":"50px","width":"120px","background":"red","border":"2px solid orange","borderRadius":"10px","color":"white"}} onClick={setAddress}>
                See Location
            </button>
        </div>
        
    </div>
    
  )
}

export default LocationTracker
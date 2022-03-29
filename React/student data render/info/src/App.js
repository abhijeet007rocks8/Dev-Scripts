import React, {useState} from "react" ;
import logo from './logo.svg';
import './App.css';
import Show from "./Show.js";

function App() {
  // const initialValues = {
  //   name: "",
  //   gender: "",
  //   age: "",
  //   skills: "",
  //   email: "",
  // };

  // const [values, setValues] = useState(initialValues);

  // const handleOnChange = (e) => {
  //   const { name, value } = e.target;
  //   setValues({
  //     ...values,
  //     [name]: value,
  //   });
  // };

  // const Show = () =>{
  //      return (
  //       <table className="show-class">
  //       <thead>
  //       <tr>
  //         <th>Name:</th>
  //         <td>{values.name}</td>
  //       </tr>
  //       </thead>
  //       <tbody>
  //       <tr>
  //         <th>Gender:</th>
  //         <td> {values.gender} </td>
  //       </tr>
  //       <tr>
  //         <th>Age:</th>
  //         <td> {values.age} </td>
  //       </tr>
  //       <tr>
  //         <th>Skills:</th>
  //         <td> {values.skills}</td>
  //       </tr> 
  //       <tr>
  //         <th>Email:</th>
  //         <td> {values.email}</td>
  //       </tr> 
  //       </tbody>      
  //     </table>
  //     ); 
  // }

  return (
    <>
    <div className="App">
      <table className="table-class">
        <thead>
        <tr>
          <th>Name:</th>
          <td><input type="text" name="name" id="lname" /></td>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th>Gender:</th>
          <td><input type="text" name="gender" id="gender" /></td>
          {/* <select name="gender" id="gender" className="genders" onChange={handleOnChange}>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
          </select > */}
        </tr>
        <tr>
          <th>Age:</th>
          <td><input type="text" name="age" id="age" /></td>
        </tr>
        <tr>
          <th>Skills:</th>
          <td><input type="text" name="skills" id="skills" /></td>
        </tr>
        <tr>
          <th>Email:</th>
          <td><input type="text" name="email" id="email" /></td>
        </tr>        
        </tbody>
        <button className="Add-btn" onClick={Show}>Add</button>
        {/* <input type="button" name="button" className="Add-btn" value="Add" onClick={Show}></input> */}
      </table>
      <h1>DETAILS:-</h1>
      <table id="show">
			<thead>
				<tr>
					<th>Name</th>
					<th>Gender</th>
					<th>Age</th>
					<th>Skills</th>
          <th>Email</th>
				</tr>
			</thead>
		</table>
      {/* <h1>
      Student Info:
      </h1>  */}
      {/* <table className="show-class">
        <thead>
        <tr>
          <th>Name:</th>
          <td>{values.name}</td>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th>Gender:</th>
          <td> {values.gender} </td>
        </tr>
        <tr>
          <th>Age:</th>
          <td> {values.age} </td>
        </tr>
        <tr>
          <th>Skills:</th>
          <td> {values.skills}</td>
        </tr> 
        <tr>
          <th>Email:</th>
          <td> {values.email}</td>
        </tr> 
        </tbody>      
      </table> */}
    </div>
    </>
    
  );
}

export default App;

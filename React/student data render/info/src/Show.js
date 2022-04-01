import React from 'react'

const Show = (props) => {
    const {n} = props ;
    const list1 = [];
    const list2 = [];
    const list3 = [];
    const list4 = [];
    const list5 = []; 

    //const n = 1;
    const x = 0;

    const addRown = document.getElementById('show');
    const NewRow = addRown.insertRow(n);

    list1[x] = document.getElementById("lname").value;
    list2[x] = document.getElementById("gender").value;
    list3[x] = document.getElementById("age").value;
    list4[x] = document.getElementById("skills").value;
    list5[x] = document.getElementById("email").value;

    const cell1 = NewRow.insertCell(0);
    const cell2 = NewRow.insertCell(1);
    const cell3 = NewRow.insertCell(2);
    const cell4 = NewRow.insertCell(3);
    const cell5 = NewRow.insertCell(4) ;

    cell1.innerHTML = list1[x];
    cell2.innerHTML = list2[x];
    cell3.innerHTML = list3[x];
    cell4.innerHTML = list4[x];
    cell5.innerHTML = list5[x] ;

//   return (
//     <table className="table-class">
//         <tr>
//           <th>Name:</th>
//           <td>  sdf </td>
//         </tr>
//         <tr>
//           <th>Gender:</th>
//           <td>   asdf</td>
//         </tr>
//         <tr>
//           <th>Age:</th>
//           <td>  d</td>
//         </tr>
//         <tr>
//           <th>Skills:</th>
//           <td>  sc </td>
//         </tr>
//         <tr>
//           <th>Email:</th>
//           <td> sc   </td>
//         </tr>        
//     </table>
//   ) ;
}

export default Show ;

const sqlite3 = require('sqlite3').verbose();
const sqlite = require('sqlite') // Async/Await wrapper for sqlite3
const readline = require('readline-sync'); // For synchronous I/O

async function OpenDB() {
  return sqlite.open({
    filename: './database.db',
    driver: sqlite3.Database
  })
}
let db = OpenDB();


async function Create(){
  let name = readline.question("Table name > ");
  let query = `CREATE TABLE ${name}(data);`;
  try{
    await db.run(query);
    console.log("\n===============");
    console.log("Table created Sucessfully!")
    console.log("===============\n");
  }catch (err){
    console.error("\n===============");
    console.error(err.message);
    console.error("===============\n");
  }
}


async function Display(){
  let choice = parseInt(readline.question("Display: (1)Existing_Tables, (2)One_Table > "));
  
  if (choice == 1){
    let res = await db.all(`select name from sqlite_master where type='table' or type='view'`);
    console.log("\n===============");
    res.forEach((table) => {
      console.log(table.name);
    })
    console.log("===============\n");
  }else if (choice == 2){
    let table = readline.question("Table name > ");
    try{
      let res = await db.all(`SELECT * FROM ${table};`);
      console.log("\n===============");
      console.table(res);
      console.log("===============\n");
    }catch(err){
      console.error("\n===============");
      console.error(err.message);
      console.error("===============\n");
    }
  }else{
    console.error("\n===============");
    console.error("Invalid choice");
    console.error("===============\n");
  }
}


async function Add(){
  let table = readline.question("Table name > ");
  let data = readline.question("Data to insert > ");
  try{
    await db.run(`INSERT INTO ${table} (data) VALUES ("${data}")`);
    console.log("\n===============");
    console.log(`Data: ${data} has been inserted sucessfully`);
    console.log("===============\n");
  }catch(err){
    console.error("\n===============");
    console.error(err.message);
    console.error("===============\n");
  }
}


async function Update(){
  let table = readline.question("Table name > ");
  let old_data = readline.question("Old data > ");
  let new_data = readline.question("New data > ");
  try{
    await db.run(`UPDATE ${table} SET data = '${new_data}' WHERE data = '${old_data}';`);
    console.log("\n===============");
    console.log(`Data updated from ${old_data} to ${new_data} sucessfully`);
    console.log("===============\n");
  }catch(err){
    console.error("\n===============");
    console.error(err.message);
    console.error("===============\n");
  }
}


async function Delete(){
  let choice = parseInt(readline.question("Delete: (1)Table, (2)Row > "));
  let table = readline.question("Table name > ");
  if(choice == 1){
    try{
      await db.run(`DROP TABLE ${table}`);
      console.log("\n===============");
      console.log(`Table: ${table} deleted sucessfully`);
      console.log("===============\n");
    }catch(err){
      console.error("\n===============");
      console.error(err.message);
      console.error("===============\n");
    }
  }else if(choice ==2){
    try{
      let data = readline.question("Data to delete > ");
      await db.run(`DELETE FROM ${table} WHERE data='${data}'`);
      console.log("\n===============");
      console.log(`Record: ${data} deleted sucessfully`);
      console.log("===============\n");
    }catch(err){
      console.error("\n===============");
      console.error(err.message);
      console.error("===============\n");
    }
  }
}


async function main(){
  db = await db;
  console.log("*** SQLit3 Admin Panel ***");
  console.log("(1)Create Table, (2)Display Tables, (3)Add Record, (4)Update Record, (5)Delete, (6)Exit");
  let operation = readline.question('Choose Operation > ');
  switch(parseInt(operation)){
      case 1:
        await Create(); break;
      case 2:
        await Display(); break;
      case 3:
        await Add(); break;
      case 4:
        await Update(); break;
      case 5:
        await Delete(); break;
      default:
        await db.close();
        process.exit(0);
    }
    main();
}
main();
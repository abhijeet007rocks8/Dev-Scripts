import React, {useEffect, useState} from 'react';
import './App.css';
import { web3, lottery } from './logic'

function App() {


  const [accounts, setAccounts] = useState({
    manager : '', 
    players   : [], 
    balance   : '',
    value     : '',
    message   : '',
  });

  useEffect(() => {
    async function setWeb3() {
      const manager = await lottery.methods.manager().call();
      const player  = await lottery.methods.playersData().call();
      const balance = await web3.eth.getBalance(lottery.options.address);

      setAccounts({
        manager : manager,
        players : player,
        balance : balance,
      });
    }
    setWeb3();

  });

  const onClick = async (_event) => {
    const accounts = await web3.eth.getAccounts();
    setAccounts({message : 'Picking a RANDOM winner........just hold on few secs.....'})
    await lottery.methods.pickWinner().send({
      from : accounts[0],
    });
    setAccounts({message : 'A winner has been picked! And he has recieved the money'})
  };

  const onSubmit = async (event) => {
    event.preventDefault();
    const accounts = await web3.eth.getAccounts();

    setAccounts({ message : 'Waiting on transaction success .....' });

    await lottery.methods.enter().send({
      from : accounts[0],
      value: web3.utils.toWei(this.accounts.value, 'ether'),
    });

    setAccounts( {message: 'Congratulations!!! You have successfully entered the lottery!' })

  }

  return (
    <div>
      <h2>Lottery contract</h2>
      <p>This contract is managed by {accounts.manager}</p>
      <p>There are currently {accounts.players.length} people entered, competing to win {web3.utils.fromWei(accounts.balance, 'ether')} ether!!!</p>
      <hr/>
      <form onSubmit={onSubmit}>
        <h4>Want to try your luck?</h4>
        <div>
          <label>Amount of ether to enter : </label>
          <input
            value={accounts.value}
            onChange={event => setAccounts({ value : event.target.value })}
          />
        </div>
        <button>Enter</button>
      </form>
      <hr/>
      <h4>Ready to Pick a Winner? </h4>
      <button onClick={onClick} >Pick a Winner!</button>
      <hr/>
      <h3>{accounts.message}</h3>
    </div>
  );
}

export default App
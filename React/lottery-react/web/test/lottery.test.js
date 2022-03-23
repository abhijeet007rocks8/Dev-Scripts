const assert = require('assert');
const ganache = require('ganache-cli');
const Web3 = require('web3');
const { abi, evm } = require('../compile');

const web3 = new Web3(ganache.provider());
let accounts;
let lottery;

beforeEach( async () => {
    // Get a list all accounts
    accounts = await web3.eth.getAccounts()

    // Use one of those contracts to
    // deploy the contract
    lottery = await new web3.eth.Contract(abi)
        .deploy({ data : evm.bytecode.object })
        .send({ from : accounts[0], gas : '1000000' });

});

describe('Lottery Contract Test', () => {

    // test if the contract is deployed successfully
    it('deployment check', () => {
        assert.ok(lottery.options.address);
    });

    // testing if a user is abble to enter the lottery
    it('allows one account to enter', async () => {
        await lottery.methods.enter().send({
            from : accounts[0],
            value : web3.utils.toWei('0.02', 'ether'),
        });

        const players = await lottery.methods.playersData().call({
            from : accounts[0],
        });

        assert.equal(accounts[0], players[0]);
        assert.equal(1, players.length);
    });

    // testing multiple users are able to enter
    it('allows multiple account to enter', async () => {
        await lottery.methods.enter().send({
            from : accounts[0],
            value : web3.utils.toWei('0.02', 'ether'),
        });
        await lottery.methods.enter().send({
            from : accounts[1],
            value : web3.utils.toWei('0.03', 'ether'),
        });
        await lottery.methods.enter().send({
            from : accounts[2],
            value : web3.utils.toWei('0.04', 'ether'),
        });

        const players = await lottery.methods.playersData().call({
            from : accounts[0],
        });

        assert.equal(accounts[0], players[0]);
        assert.equal(accounts[1], players[1]);
        assert.equal(accounts[2], players[2]);
        assert.equal(3, players.length);
    });

    // testing the minimum entry fee requirement
    it('requires a minimum amount of ether to enter', async () => {
        try{
            await lottery.methods.enter().send({
                from : accounts[0],
                value : 10,
            });
            assert(false);
        } catch (err) {
            assert(err);
        }
    });

    // testing the restricted access for manager only
    it('manager only access check', async () => {
        try{
            await lottery.methods.enter().send({
                from : accounts[3],
                value : web3.utils.toWei('0.02', 'ether'),
            });

            await lottery.methods.pickWinner().send({
                from : accounts[1],
            });
            assert(false);
        } catch (err) {
            await lottery.methods.pickWinner().send({
                from : accounts[0],
            });
            assert(err);
        }
    });

    // end-to-end process & transfer success check, and reset check
    it('end-to-end process, and reset check', async () => {
        await lottery.methods.enter().send({
            from : accounts[3],
            value : web3.utils.toWei('2', 'ether'),
        });

        const initialBalance = await web3.eth.getBalance(accounts[3]);

        await lottery.methods.pickWinner().send({
            from : accounts[0],
        });

        const finalBalance = await web3.eth.getBalance(accounts[3]);
        const difference = finalBalance - initialBalance;
        assert(`${difference}` === web3.utils.toWei('2', 'ether'));
    });
});
#!/usr/bin/env node
const program = require('commander')
const chalk = require('chalk')
const clipboardy = require('clipboardy')
const createPassword = require('./utils/createPassword')
const savePassword = require('./utils/savePassword')

const log = console.log

program.version('1.0.0').description('Simple CLI Password Generator')

program
.option('-l, --length <number>', 'length of password', '8')
.option('-s, --save [string]', 'default: save password to passwords.txt')
.option('-nn, --no-numbers', 'remove numbers')
.option('-ns, --no-symbols', 'remove symbols')
.parse()

const {length, save, numbers, symbols} = program.opts()

//Get generated pass
const generatedPassword = createPassword(length, numbers, symbols)

//save to file 
if(save) {
    savePassword(generatedPassword, save) 
}

//save to clipboard
clipboardy.writeSync(generatedPassword)

log(chalk.blue('Generated Password: ') + chalk.bold(generatedPassword))
log(chalk.yellow('Password copied to clipboard!'))
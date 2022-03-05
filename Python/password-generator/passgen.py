from ast import For
from random import choices
import string
import argparse
from colorama import Fore, Style

ascii_uppercase_enabled = False
ascii_lowercase_enabled = False
numbers_enabled = False
special_chars_enabled = False
length = 0

def print_banner():
    
    print (Fore.CYAN + Style.BRIGHT + ' ____                ____                          ')
    print ('|  _ \ __ _ ___ ___ / ___| ___ _ __    _ __  _   _ ')
    print ("| |_) / _` / __/ __| |  _ / _ \ '_ \  | '_ \| | | |")
    print ("|  __/ (_| \__ \__ \ |_| |  __/ | | |_| |_) | |_| |")
    print ("|_|   \__,_|___/___/\____|\___|_| |_(_) .__/ \__, |")
    print ("                                      |_|    |___/ " + Fore.RESET + Style.RESET_ALL)

def parse_args():

    global ascii_lowercase_enabled, ascii_uppercase_enabled, numbers_enabled, special_chars_enabled, length

    parser = argparse.ArgumentParser(prog="passgen.py", description="Command line utility for generating passwords.", usage="Generate random passwords")
    parser.add_argument("--length", '-l', help='Length of the generated password', type=int, metavar='N', nargs=1, dest='length')
    parser.add_argument('--ascii-lower', '-aL', help='Allow lower case alphabets in password', default=False, action='store_true', dest='is_lower_enabled')
    parser.add_argument('--ascii-upper', '-aU', help='Allow upper case alphabets in password', default=False, action='store_true', dest='is_upper_enabled')
    parser.add_argument('--numbers', '-n', help='Allow numbers in password', action='store_true', default=False, dest='is_numbers_enabled')
    parser.add_argument('--special-chars', '-s', help='Allow special characters in password', default=False, action='store_true', dest = 'is_special_chars_enabled')
    args = parser.parse_args()

    try:
        length = args.length[0]
    except:
        print (Fore.RED + Style.BRIGHT + "The length must be specified (--length OR -l)" + Fore.RESET + Style.RESET_ALL)
        exit(1)
    ascii_lowercase_enabled = args.is_lower_enabled
    ascii_uppercase_enabled = args.is_upper_enabled
    numbers_enabled = args.is_numbers_enabled
    special_chars_enabled = args.is_special_chars_enabled

def generate_password():
    charset = '';
    if ascii_uppercase_enabled:
        charset += string.ascii_uppercase
    if ascii_lowercase_enabled:
        charset += string.ascii_lowercase
    if numbers_enabled:
        charset += string.digits
    if special_chars_enabled:
        charset += '!@#$'
    if charset == '':
        print (Fore.RED + Style.BRIGHT + "Can't generate password out of nothing!\nEnable atleast one switch.(--ascii-lower OR --ascii-upper OR --numbers OR --special-chars)" + Fore.RESET + Style.RESET_ALL)
        return
    print (Fore.GREEN + Style.BRIGHT + "Your password: "+ Style.RESET_ALL + Fore.RESET + ''.join(choices(charset, k=length)))


if __name__ == '__main__':
    print_banner()
    parse_args()
    generate_password()
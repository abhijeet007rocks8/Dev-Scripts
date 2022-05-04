# -*- coding: utf-8 -*-
"""
Created on Wed Mar  2 15:15:45 2022

@author: Rishi
"""

import sys


# Function to check if date entered is valid
def valid_dd (mm, dd):
    
    # DD is not valid if it is more than 30 for the month of June, November, April, September
    if   (    ((mm == 4) or (mm==6) or (mm==9) or (mm==11))  and  dd > 30):
        return 0
    
    # DD is not valid if it is greater than 31 or less than 1 (for all months)
    if (dd<1 or dd >31):
        return -1
    
    # If above checks passed then DD is valid without any doubt
    return 1


# Function to check if given year is leap year
def is_leap (yyyy):

    if ((yyyy%4 == 0)  or  (yyyy%400 == 0)):
        return 1;
    
    return 0


# Century code calculator
def cal_century_code(yyyy):

    remainder = yyyy % 400;
    
    if ( remainder>= 0 and remainder <100):
        return 6
    if (remainder>= 100 and remainder <200):
        return 4
    if ( remainder>= 200 and remainder <300):
        return 2
    if (remainder>= 300 and remainder <400):
        return 0
        
    

# Month code calculator
def cal_month_code(mm):
 
    
    if mm == 1:  return 0
    if mm == 2:  return 3
    if mm == 3:  return 3
    if mm == 4:  return 6
    if mm == 5:  return 1
    if mm == 6:  return 4
    if mm == 7:  return 6
    if mm == 8:  return 2
    if mm == 9:  return 5
    if mm == 10: return 0
    if mm == 11: return 3
    if mm == 12: return 5
    
    
    
    


# Cakculate day code
def extract_day(dd,mm,yyyy):


    #Check if MM is valid
    if (mm>12 or mm<1):  
        print("Wrong date entered. Please enter correct date. \n")
        return -2

    #check if DD is valid
    if (valid_dd(mm,dd) == 0):  
        print("\n Please check DD in DD-MM-YYY. \n Error: For this MM value of DD must not be more than 30 \n")
        return -2
    
    if (valid_dd(mm,dd) == -1):
        print("\n Please enter correct DD \n")
        return -2

    # Check if YYYY is a leap year. i.e 366 days
    leap = 0;
    if(is_leap(yyyy)):
        leap = 1
        #print(" \n YYYY is a leap year. \n")

    #Checking date validity for February month
    if(leap == 1 and dd>29 and mm == 2):
            print("Invalid DD for month of February in a leap year. \n")
            return -2
    if (leap == 0 and dd>28 and mm == 2):
        print("Invalid DD for month of February in a non-leap year. \n")
        return -2




    #Calculating month code and century code.
    century_code = cal_century_code(yyyy);
    month_code = cal_month_code(mm);

    #Calculating day code

    z = yyyy % 100; # i.e. last 2 digits of YYYY

    day_code = ( ((5*z)/4) + dd + month_code + century_code) % 7 ;
    #print(day_code)

    if (leap == 1  and mm<3): 
        day_code -= 1

    return int(day_code)




   
##################################################################
# Driver program 

if __name__ == "__main__":
    
    try:
        
        str = sys.argv[1]
        str = str.split("/")
        
        # Converting DD, MM, YYYY to int
        for i in range(len(str)):
            str[i] = int(str[i])
            
        
        dd = str[0]
        mm = str[1]
        yyyy = str[2]
        
        day = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday']
        
        day_code = extract_day(dd,mm,yyyy)
        
        if (day_code>-2):
            print(day[day_code])
        else:
            print("Error! Please try again.")
            
    except IndexError:
        
        print ("Error: Invalid arguments. \n\nPlease use below formats:-\npython3 DateExtractor.py DD/MM/YYYY \nor\npython DateExtractor.py DD/MM/YYYY")
        
    except  ValueError:
        print ("Error: Invalid argument format. \n\nPlease use below formats:-\npython3 DateExtractor.py DD/MM/YYYY \nor\npython DateExtractor.py DD/MM/YYYY")
        

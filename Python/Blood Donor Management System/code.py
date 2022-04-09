import mysql.connector
import os
import platform

print("\t\t\t\t===========================================")
print("\t\t\t\t||   Blood Donor Management System.      ||")
print("\t\t\t\t===========================================")
print("\t\t\t\t\t\t\t\t\t\t--Donate Blood Save Lives")
print("\n")
print("1.Admin")
print("2.Donor")
print("\n")
role = int(input("\nEnter Your Role: "))
if role == 1:
    print("Enter the Username and Password to login.\n")
    print("@***Both UserName and PassWord should be same to get access into system**@\n\n")
    Uname = str(input("Enter the username: "))
    for i in range(1,len(Uname)+1):
        Password = str(input("Enter your Password: "))
        if Uname == Password:
            host=input("Enter Host of MySQL : ")
            user=input("Enter UserName of MySQL    : ")
            passwd=input("Enter Password of User Name : ")
            database=input("Enter Database Name         : ")
            mydb=mysql.connector.connect(host=host,user=user,passwd=passwd,database=database);
            if (mydb.is_connected()):
                print("\nConnection is successful\n")
            else:
                print("Connection is not unsuccessful")
            mycursor=mydb.cursor()
            mycursor.execute("create table donordetails11(DonorName varchar(30),AssignedNumber int primary key,Gender varchar(6),BloodGroup varchar(5),NoOfUnitsDnated int,PhoneNumber bigint(10),Email varchar(50),Address varchar(100));")

            def donordetails():
                print("------------------------------------")
                print("||Blood Donation Management system||")
                print("||1. Enter Donor Details          ||")
                print("||2. Display Donor Details        ||")
                print("||3. Search The Donor             ||")
                print("||4. Update Donor Details         ||")
                print("||5. Quit                         ||")
                print("------------------------------------")
                print("\n\n\n\n\n")
                n = int(input("Select yout option: "))
                if(n==1):
                    EnterDonorDetails()
                elif(n==2):
                    displayDonorDetails()
                elif(n==3):
                    searchingfordonor()
                elif(n==4):
                    udd()
                elif(n==5):
                    exit(0)
                else:
                    print("Input is invalid. So,please try again with correct input")
            print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

            def EnterDonorDetails():
                    global entries
                    entries = int(input("Enter the total no.of Donor entries: "))
                    for i in range(entries):
                        print(f"Enter the details of donor {i+1}")
                        d = []
                        Donor_name = input("Enter Donor Name: ")
                        d.append(Donor_name)
                        Assigned_Identity = int(input("Enter Assigned Identity: "))
                        d.append(Assigned_Identity)
                        Gender = str(input("Enter Gender of Donor: "))
                        d.append(Gender)
                        Blood_Group = input("Enter Blod Group of Donor: ") 
                        d.append(Blood_Group)
                        NoofUnitsDonated = int(input("Enter units of blood donated: "))
                        d.append(NoofUnitsDonated)
                        Phone_Number = int(input("Enter Phone Number of Donor"))
                        d.append(Phone_Number)
                        E_mail = str(input("Enter Email of Donor: "))
                        d.append(E_mail)
                        Address = input("Enter Address of Donor: ")
                        d.append(Address)
                        bld = (d)
                        sql="insert into donordetails11(DonorName,AssignedNumber,Gender,BloodGroup,NoOfUnitsDnated,PhoneNumber,Email,Address)values(%s,%s,%s,%s,%s,%s,%s,%s)"
                        mycursor.execute(sql,bld)
                        mydb.commit()
                        print("Data Inserted in the  Database")
                    donordetails()
            print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
            
            def displayDonorDetails():
                print("They Donor Details are: ")
                sql="select * from donordetails11"
                mycursor.execute(sql)
                res=mycursor.fetchall() 
                for x in res:
                    print(f"The Details Of Donor {x[1]} is: ")
                    print(" --------------------------------------------------- ")
                    print(f"||Name of Donor: {x[0]}                           ||")
                    print(f"||Assigned identity of Donor: {x[1]}              ||")
                    print(f"||Gender of Donor: {x[2]}                         ||")
                    print(f"||Blood Group of Donor: {x[3]}                    ||")
                    print(f"||Units of blood Donated: {x[4]}                  ||")
                    print(f"||Phone Number of Donor: {x[5]}                   ||")
                    print(f"||E-mail of Donor: {x[6]}                         ||")
                    print(f"||Address of Donor: {x[7]}                        ||")
                    print(" --------------------------------------------------- ")
                donordetails()
            print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
            
            def searchingfordonor():
                req = str(input("Enter The blood group that is required for patient: "))
                sql="select * from donordetails11"
                mycursor.execute(sql)
                res=mycursor.fetchall() 
                count  = 0
                for x in res:
                    if x[3] == req:
                        count = count + 1
                        print("Blood with the required group is avilable")
                        print(f"Details of donor {count} are: ")
                        print(" ---------------------------------------------- ")
                        print(f"||Name of Donor: {x[0]}                      ||")
                        print(f"||Assignd identity of donor is: {x[1]}       ||")
                        print(f"||Gender of Donor is: {x[2]}                 ||")
                        print(f"||{x[3]} group blood                         ||")
                        print(f"||{x[4]} of blood is avilable                ||")
                        print(f"||Phone Number of Donor: {x[5]}              ||")
                        print(f"||Email of Donor: {x[6]}                     ||")
                        print(f"||Address of Donor: {x[7]}                   ||")
                        print(" ---------------------------------------------- ")
                donordetails()
            print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
            
            def udd():
                print("Enter The assigned identity for updating the details")
                assnum = int(input("Enter your assigned number: "))
                print("What do you want to update: ")
                print("1.DonorName,2.Assigned Number,3.Gender,4.Blood Group,5.Units of blood,6.Phone number of Donor,7.Email of Donor, 8. Address of Donor")
                udate =  int(input("Enter your choice: "))
                newentry  = input("Enter New entry to update: ")
                if udate == 1:
                    sql_query = "UPDATE donordetails11 SET DonorName = %s WHERE AssignedNumber = %s "% (newentry, assnum)
                    mycursor.execute(sql_query)
                    mydb.commit()
                elif udate == 2:
                    sql_query = "UPDATE donordetails11 SET AssignedNumber = %s WHERE AssignedNumber = %s "% (newentry, assnum)
                    mycursor.execute(sql_query)
                    mydb.commit()
                elif udate == 3:
                    sql_query = "UPDATE donordetails11 SET Gender = %s WHERE AssignedNumber = %s "% (newentry, assnum)
                    mycursor.execute(sql_query)
                    mydb.commit()
                elif udate == 4:
                    sql_query = "UPDATE donordetails11 SET BloodGroup = %s WHERE AssignedNumber = %s "% (newentry, assnum)
                    mycursor.execute(sql_query)
                    mydb.commit()
                elif udate == 5:
                    sql_query = "UPDATE donordetails11 SET NoOfUnitsDnated = %s WHERE AssignedNumber = %s "% (newentry, assnum)
                    mycursor.execute(sql_query)
                    mydb.commit()
                elif udate == 6:
                    sql_query = "UPDATE donordetails11 SET PhoneNumber = %s WHERE AssignedNumber = %s "% (newentry, assnum)
                    mycursor.execute(sql_query)
                    mydb.commit()
                elif udate == 7:
                    sql_query = "UPDATE donordetails11 SET Email = %s WHERE AssignedNumber = %s "% (newentry, assnum)
                    mycursor.execute(sql_query)
                    mydb.commit()
                elif udate == 8:
                    sql_query = "UPDATE donordetails11 SET Address = %s WHERE AssignedNumber = %s "% (newentry, assnum)
                    mycursor.execute(sql_query)
                    mydb.commit()
                donordetails()    
            donordetails()
            print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")     
            
            
            
            break
        elif Uname != Password and i != len(Uname):
            print("Wrong Password..! Please Tr y again.")
        elif Uname != Password and i == len(Uname):
            print("Sorry, You have reached login limit, Try after some Time")
            break
elif role == 2:
    print("You don't have access to the system.\n")
else:
    print("Enter a valid number.\n")

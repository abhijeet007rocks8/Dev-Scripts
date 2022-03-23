import pickle
def enter():
    n=int(input('Enter total number of enteries: '))
    f=open('Telephone directory.bin','wb')
    for i in range(0,n):
        a=input('Enter user name: ')
        b=int(input('Enter phone number: '))
        c=input('Enter address: ')
        email_valid()
        w=input("Enter Workspace/School/Institute: ")
        t=input("Enter the tag to be added: ")
        rec={'User':a,'Phone number':b,'Address':c,"Email":email,"Workspace":w,"Tag":t}
        pickle.dump(rec,f)
    f.close()
### Entering a valid E-mail ###
def email_valid():
    global email
    email=input("Enter email: ")
    email = email.strip().lower()
    if not "@" in email:
        print("Invalid email")
        email_valid()
        print()
    elif not email[-4:] in ".com.org.edu.gov.net":
        if not email[-3:] in ".in.us.uk.co":
            print("Invalid email")
            email_valid()
        else:
            print("Valid email")
    else:
        print("Valid email")    
def show():
    f=open('Telephone directory.bin','rb')
    while True:
        try:
            rec=pickle.load(f)
            print(rec)
        except EOFError:break
    f.close()
def search_phone():
    f=open('Telephone directory.bin','rb')
    tmp=int(input('Enter phone number to be searched: '))
    while True:
        try:
            rec=pickle.load(f)
            if (rec['Phone number']==tmp):
                print('User:',rec['User'])
                print('Phone number:',rec['Phone number'])
                print('Address: ',rec['Address'])
                print('Email:',rec['Email'])
                print('Workspace:',rec['Workspace'])
                print('Tag:',rec['Tag'])
        except EOFError:break
    f.close()
def search_user():
    f=open('Telephone directory.bin','rb')
    tmp3=input('Enter the name: ')
    while True:
        try:
            rec=pickle.load(f)
            if (rec['User']==tmp3):
                print('User:',rec['User'])
                print('Phone number:',rec['Phone number'])
                print('Address: ',rec['Address'])
                print('Email:',rec['Email'])
                print('Workspace:',rec['Workspace'])
                print('Tag:',rec['Tag'])
        except EOFError:break
    f.close() 
def search_email():
    f=open('Telephone directory.bin','rb')
    tmp=input('Enter email to be searched: ')
    while True:
        try:
            rec=pickle.load(f)
            if (rec['Email']==tmp):
                print('User:',rec['User'])
                print('Phone number:',rec['Phone number'])
                print('Address: ',rec['Address'])
                print('Email:',rec['Email'])
                print('Workspace:',rec['Workspace'])
                print('Tag:',rec['Tag'])
        except EOFError:break
    f.close()
def search_work():
    f=open('Telephone directory.bin','rb')
    tmp3=input('Enter the workspace/institute/school: ')
    while True:
        try:
            rec=pickle.load(f)
            if (rec['Workspace']==tmp3):
                print('User:',rec['User'])
                print('Phone number:',rec['Phone number'])
                print('Address: ',rec['Address'])
                print('Email:',rec['Email'])
                print('Workspace:',rec['Workspace'])
                print('Tag:',rec['Tag'])
        except EOFError:break
    f.close() 
def search_tag():
    f=open('Telephone directory.bin','rb')
    tmp3=input('Enter the tag: ')
    while True:
        try:
            rec=pickle.load(f)
            if (rec['Tag']==tmp3):
                print('User:',rec['User'])
                print('Phone number:',rec['Phone number'])
                print('Address: ',rec['Address'])
                print('Email:',rec['Email'])
                print('Workspace:',rec['Workspace'])
                print('Tag:',rec['Tag'])
        except EOFError:break
    f.close() 
def delete():
    f=open('Telephone directory.bin','rb')
    l=[]
    while True:
        try:
            rec=pickle.load(f)
            l.append(rec)
        except EOFError:break
    f.close()
    f=open('Telephone directory.bin','wb')
    tmp2=input('Whose record is to be deleted? Please enter the registered Username: ')
    for t in l:
        if (t['User']==tmp2):
            continue
        pickle.dump(t,f)
    f.close()
#Menu
def menu():
    print("CHOICE CODES")
    print("0: To add new record")
    print('1: To display record according to the Phone number entered')
    print('2: To display record according to the User name entered')
    print('3: To display record according to the Email entered')
    print('4: To display record according to the Workspace entered')
    print('5: To display record according to the Tag entered')
    print("6: To delete a record")
    print("7: To display ALL the records")
    q=int(input('Enter number of operations you want to perform: '))
    for y in range(0,q):
        r=int(input('Enter choice-code: '))
        if r==0:
            enter()
        if r==1:
            search_phone()
        if r==2:
            search_user()
        if r==3:
            search_email()
        if r==4:
            search_work()
        if r==5:
            search_tag()
        if r==6:
            delete() 
        if r==7:
            show()
#Login
def login():
    print('Welcome to the Telemanager!')
    print("Let us get you started!")
    #Login user
    import pickle
    import getpass
    def newuser():
        f=open(r'userslib.bin','ab')
        uname=input('Enter your Username: ')
        print('Good',uname,"! Thats what we'll call you now!")
        pword=getpass.getpass('Enter a password')
        rec={'Username':uname,'Password':pword}
        pickle.dump(rec,f)
        f.close()
        print("Yay! We got you on-board!")
    def exuser():
        flag=0
        f=open(r'userslib.bin','rb')
        tmp=input('Enter the username: ')
        a=getpass.getpass('Enter your password: ')
        while True:
            try:
                rec=pickle.load(f)
                if (rec['Username']==tmp):
                    if (rec['Password']==a):
                        flag=1
            except EOFError:break
        f.close()
        if flag==0:
            print('Looks like you have signed in using incorrect credentials')
            print('Terminated the login. Try signing in again')    
        else:
            print('Good to see you, Old friend!')
            menu()
    print('READ THE INSTRUCTIONS CAREFULLY')
    print('Enter 1: If you are a new user and want to sign in')
    print('Enter 2: If you are an old user and want to sign in')
    en=int(input('Enter your choice: '))
    if en==1:
        newuser()
        print('Sign in using your new credentials')
        exuser()
    elif en==2:
        exuser()
    else:
        print('Read instructions carefully') 
#Running the login
login()

                 
               
    
        
        

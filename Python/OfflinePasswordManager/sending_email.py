## will handle sending otp mail in case u forget the password

import smtplib                            

def sendEmail(email_n,msg):

    email = "put your temporaru emial address from where the emial will be sent"                                           # create a email id from where the mail will be sent
    password = "enter your password fro the temoprary emial that you created"                                # password for the above email id

    server = smtplib.SMTP('smtp.gmail.com',587)                                 # connecting to server
    server.ehlo()
    server.starttls()
    server.ehlo()

    server.login(email,password)                                                 # logs in with email id and password

    subject = "OTP for loggin in to password vault"
    body = msg
    compose = f'Subject: {subject}\n\n{body}'

    server.sendmail(email,email_n,compose)                                        # sends mail containing the otp to the set while running setup.py file
    server.quit()
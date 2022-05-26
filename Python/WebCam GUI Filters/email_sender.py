import smtplib
from email import encoders
from email.mime.base import MIMEBase
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.image import MIMEImage
import os.path
from PIL import ImageGrab

def enviar_email():
    email = input("Enter E-mail to send from : ")
    email_send = input("Enter E-mail to send to : ")
    password = input("Enter Password : ")
    subject = 'Screenshot from Python Filter GUI'
    message = 'Your Screenshot of Python Filter GUI is attached with this mail. Have a Good Day !'
    file_location = 'ss1.jpg'

    msg = MIMEMultipart()
    msg['From'] = email
    msg['To'] = email_send
    msg['Subject'] = subject

    msg.attach(MIMEText(message, 'plain'))

    # Setup the attachment
    filename = os.path.basename(file_location)
    attachment = open(file_location, "rb").read()
    image = MIMEImage(attachment, name=filename)
    msg.attach(image)

    server = smtplib.SMTP('smtp.gmail.com', 587)
    server.starttls()
    server.login(email, password)
    text = msg.as_string()
    server.sendmail(email, email_send, text)
    server.quit()
    print("Mail Sent!")

imagem = ImageGrab.grab()
imagem.save('ss1.jpg', 'jpeg')
enviar_email()

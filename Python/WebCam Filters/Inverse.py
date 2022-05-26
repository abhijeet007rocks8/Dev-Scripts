import cv2
import numpy as np
import mediapipe as mp

cap = cv2.VideoCapture(0)
ret, frame = cap. read ()
while (True):
    ret, frame = cap. read ()
    frame = cv2.flip(frame,1)
    inversion = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    cv2.imshow('Inverse Filter', inversion)    
    if cv2.waitKey(10) & 0xFF==ord('q'):
        break
    if cv2.waitKey(10) & 0xFF==ord('s'):
        import email_sender
cap. release ()
cv2.destroyAllWindows()
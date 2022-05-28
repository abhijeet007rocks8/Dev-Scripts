import cv2
import numpy as np
import mediapipe as mp

cap = cv2.VideoCapture(0)
ret, frame = cap. read ()
while (True):
    ret, frame = cap. read ()
    frame = cv2.flip(frame,1)
    canny = cv2.Canny(frame,100,200)
    cv2.imshow('Canny Filter', canny)
    if cv2.waitKey(10) & 0xFF==ord('q'):
        break
    if cv2.waitKey(10) & 0xFF==ord('s'):
        import email_sender
cap. release ()
cv2.destroyAllWindows()
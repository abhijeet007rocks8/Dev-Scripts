import cv2
import numpy as np
import mediapipe as mp

cap = cv2.VideoCapture(0)
ret, frame = cap. read ()
while (True):
    ret, frame = cap. read ()
    frame = cv2.flip(frame,1)
    X_ray_image = cv2.bitwise_not(frame)
    cv2.imshow('X-ray Filter', X_ray_image)
    if cv2.waitKey(10) & 0xFF==ord('q'):
        break
    if cv2.waitKey(10) & 0xFF==ord('s'):
        import email_sender
cap. release ()
cv2.destroyAllWindows()
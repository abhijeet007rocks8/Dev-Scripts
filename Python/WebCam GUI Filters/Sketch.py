import cv2
import numpy as np
import mediapipe as mp

cap = cv2.VideoCapture(0)
ret, frame = cap. read ()
while (True):
    ret, frame = cap. read ()
    frame = cv2.flip(frame,1)
    sketch = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    sketch = cv2.medianBlur(sketch,3)
    sketch_update = cv2.adaptiveThreshold(sketch,255,cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY,5,5)
    cv2.imshow('Sketch Filter', sketch_update)
    if cv2.waitKey(10) & 0xFF==ord('q'):
        break
    if cv2.waitKey(10) & 0xFF==ord('s'):
        import email_sender
cap. release ()
cv2.destroyAllWindows()
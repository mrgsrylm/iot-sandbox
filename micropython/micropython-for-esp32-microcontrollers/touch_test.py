# touch_test.py

from machine import TouchPad, Pin
from time import sleep

from machine import TouchPad, Pin

t1 = TouchPad(Pin(2))
t2 = TouchPad(Pin(4))

while True:
  cap1 = t1.read()
  print(cap1, end=" ")
  
  
  cap2 = t2.read()
  print(cap2)
  
  sleep(1)
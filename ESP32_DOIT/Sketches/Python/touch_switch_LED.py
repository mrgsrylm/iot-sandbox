# touch_test.py

from machine import TouchPad, Pin
from time import sleep

t1 = TouchPad(Pin(2))
t2 = TouchPad(Pin(4))

led1 = Pin(25, Pin.OUT)
led2 = Pin(26, Pin.OUT)

while True:
  if t1.read() < 500:
    led1.value(1)
  else:
    led1.value(0)
    
  if t2.read() < 500:
    led2.value(1)
  else:
    led2.value(0)



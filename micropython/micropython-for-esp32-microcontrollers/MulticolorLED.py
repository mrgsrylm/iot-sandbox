# MulticolorLED.py

from machine import Pin
from time import sleep

LED = [25,26,32]

del_time = 0.5

for n in range(3):
  LED[n] = Pin(LED[n],Pin.OUT)
  
    
while True:
  for n in range(3):
    LED[n].value(1)
    sleep(del_time)
    LED[n].value(0)
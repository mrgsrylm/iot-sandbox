# SOS_compact.py
from machine import Pin
from time import sleep
led=Pin(2,Pin.OUT)
while True:
  for n in range(3):
    led.value(1)
    sleep(.1)               
    led.value(0)
    sleep(.5)              
  sleep(1)              
  for n in range(3):
    led.value(1)
    sleep(.4)               
    led.value(0)
    sleep(.5)              
  sleep(1)              
  for n in range(3):
    led.value(1)
    sleep(.1)               
    led.value(0)
    sleep(.5)              
  sleep(2)
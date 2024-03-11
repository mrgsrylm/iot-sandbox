# LED_timer_and_mainprogram.py

from machine import Pin, Timer
from time import sleep

led1 = Pin(25, Pin.OUT)
led2 = Pin(26,Pin.OUT)
timer = Timer(0)

def handleInterrupt(timer):
  led1.value(not led1.value())
  
timer.init(period=125, mode=Timer.PERIODIC, callback=handleInterrupt)

while True:
  led2.value(1)
  sleep(.1)
  led2.value(0)
  sleep(1)
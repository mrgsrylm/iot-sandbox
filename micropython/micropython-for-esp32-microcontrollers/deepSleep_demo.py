# deepSleep_demo.py

import machine
from machine import Pin
from time import sleep

led = Pin (22, Pin.OUT)

#blink LED
for n in range(3):
  led.value(1)
  sleep(.1)
  led.value(0)
  sleep(.1)

sleep(5) # awake time

print('going to sleep...')

machine.deepsleep(10000)  # in milliseconds!

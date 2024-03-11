# SOS.py
from machine import Pin
from time import sleep
led = Pin(2, Pin.OUT)
while True:
  # "S"
  led.value(1)
  sleep(.1)
  led.value(0)
  sleep(.5)
  led.value(1)
  sleep(.1)
  led.value(0)
  sleep(.5)
  led.value(1)
  sleep(.1)
  led.value(0)
  sleep(1)

  # "O"
  led.value(1)
  sleep(.4)
  led.value(0)
  sleep(.5)
  led.value(1)
  sleep(.4)
  led.value(0)
  sleep(.5)
  led.value(1)
  sleep(.4)
  led.value(0)
  sleep(1)

  # "S"
  led.value(1)
  sleep(.1)
  led.value(0)
  sleep(.5)
  led.value(1)
  sleep(.1)
  led.value(0)
  sleep(.5)
  led.value(1)
  sleep(.1)
  led.value(0)
  sleep(1)
  sleep(2)
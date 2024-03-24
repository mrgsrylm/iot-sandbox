# HCSR04_anti_colission.py

from machine import Pin, PWM
from hcsr04 import HCSR04
from time import sleep

sensor = HCSR04(trigger_pin=2, echo_pin=4)
beeper = PWM(Pin(14), freq=1000, duty=512)
beeper.deinit()

minDist=10

while True:
  distance = sensor.distance_cm()
  output="Distance: {:6.1f} cm"
  print(output.format(distance))
  if (distance<minDist):
    beeper = PWM(Pin(14),freq=1000,duty=512)
    sleep(.5)
    beeper.deinit()
  sleep(.1)
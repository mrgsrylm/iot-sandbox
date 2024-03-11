# HCSR04_US_distance_demo.py
# distance measurement using ultrasound

from hcsr04 import HCSR04
from time import sleep

sensor = HCSR04(trigger_pin=2, echo_pin=4)

while True:
  distance = sensor.distance_cm()
  output="Distance: {:6.1f} cm"
  print(output.format(distance))
  sleep(.1)
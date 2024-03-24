# Hall_sensor_alarm.py

import esp32
from time import sleep
from machine import Pin

ledRed = Pin(2, Pin.OUT)
ledGreen = Pin(4, Pin.OUT)

esp32.hall_sensor()     # read the internal hall sensor
threshold=100

while True:
  Hfield=int(esp32.hall_sensor())
  print(Hfield)
  if (Hfield>threshold):
    ledRed.value(0)  
    ledGreen.value(1)
  else:
    ledRed.value(1)  
    ledGreen.value(0)
  sleep(.1)
  

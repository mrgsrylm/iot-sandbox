# DHT11_HumiTemp_sensor_demo.py

from machine import Pin
from time import sleep
import dht 

#sensor = dht.DHT11(Pin(26))
sensor = dht.DHT22(Pin(26))

while True:
  try:
    sleep(2)
    sensor.measure()
    temp = sensor.temperature()
    hum = sensor.humidity()
    print('Temperature: %3.1f C' %temp)
    print('Humidity: %3.1f %%' %hum)
    print()

  except OSError as e:
    print('Failed to read sensor.')

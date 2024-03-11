# DHT11_22_double HumiTemp_sensor.py

from machine import Pin
from time import sleep
import dht 

sensor1 = dht.DHT11(Pin(26))
sensor2 = dht.DHT22(Pin(14))

while True:
  try:
    sleep(2)
    sensor1.measure()
    temp1 = sensor1.temperature()
    hum1 = sensor1.humidity()
    print("DHT11:")
    print('Temperature: %3.1f C' %temp1)
    print('Humidity: %3.1f %%' %hum1)
    print()
    
    sensor2.measure()
    temp2 = sensor2.temperature()
    hum2 = sensor2.humidity()
    print("DHT22:")
    print('Temperature: %3.1f C' %temp2)
    print('Humidity: %3.1f %%' %hum2)
    print()
    
  except OSError as e:
    print('Failed to read sensor.')

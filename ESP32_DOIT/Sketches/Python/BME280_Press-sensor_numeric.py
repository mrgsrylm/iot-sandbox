# BME280 Press-sensor_numeric.py

from machine import Pin, I2C
from time import sleep
import BME280

i2c = I2C(scl=Pin(22), sda=Pin(21), freq=10000)
averages=30

def pressure():
    p=bme.read_pressure() // 256
    pi=p// 100
    pd=p-pi*100
    return "{}.{:02d}".format(pi, pd)

while True:
  bme=BME280.BME280(i2c=i2c)
  press=0
  for i in range(averages):
    press += float(pressure())
    sleep(.1)
  print(press/averages)
  
  

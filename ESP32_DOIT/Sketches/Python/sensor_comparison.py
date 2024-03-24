# sensor comparison.py

from machine import Pin, I2C
from time import sleep
import BME280
import dht

# ESP32 I2C - Pin assignment
i2c = I2C(scl=Pin(22), sda=Pin(21), freq=10000)

# DHT assignment
sensor1 = dht.DHT11(Pin(26))
sensor2 = dht.DHT22(Pin(14))

print(" --BME280--  --DHT11---   --DHT22---")
print(" C     % RH  C     % RH   C     % RH")

while True:
  bme = BME280.BME280(i2c=i2c)
  temp = bme.read_temperature()/100.0
  hum = bme.read_humidity()/1024.0
  pres = bme.read_pressure()/25600.0
  
  print('%5.1f' %temp, end=" ")
  print('%5.1f' %hum, end=" ")
  
  try:
    sleep(2)  
    sensor1.measure()
    temp1 = sensor1.temperature()
    hum1 = sensor1.humidity()
    print('%5.1f' %temp1, end=" ")
    print('%5.1f ' %hum1, end=" ")
    
    sensor2.measure()
    temp2 = sensor2.temperature()
    hum2 = sensor2.humidity()-7.0
    print('%5.1f' %temp2, end=" ")
    print('%5.1f' %hum2)
     
  except OSError as e:
    print('Failed to read sensor.')

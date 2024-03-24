# BME280 Temp_Humit_Press-sensor_to_SSD1306.py

from machine import Pin, I2C
from time import sleep
import ssd1306
import BME280

# ESP32 - Pin assignment
i2c = I2C(scl=Pin(22), sda=Pin(21), freq=10000)

# OLED setup
oled_width = 128
oled_height = 64
oled = ssd1306.SSD1306_I2C(oled_width, oled_height, i2c)

while True:
  oled.fill(0)
  oled.text('BME280 climate', 0, 0)
  bme = BME280.BME280(i2c=i2c)
  temp = bme.read_temperature()/100
  hum = bme.read_humidity()/1024
  pres = bme.read_pressure()/25600
  
  print('Temp: %7.2f' %temp)
  print('Humi: %7.2f' %hum)
  print('Pres: %7.2f' %pres)
  print()
  
  temp_string=str('Temp:%7.1f' %temp)
  hum_string =str('Humi:%7.1f' %hum)
  pres_string=str('Pres:%7.1f' %pres)
    
  oled.text(temp_string, 0, 10)
  oled.text(' C', 90 ,10)
  oled.text(hum_string, 0, 20)
  oled.text(' %', 90 ,20)
  oled.text(pres_string, 0, 30)
  oled.text(' hPa', 90 ,30)
  oled.show()

  sleep(1)






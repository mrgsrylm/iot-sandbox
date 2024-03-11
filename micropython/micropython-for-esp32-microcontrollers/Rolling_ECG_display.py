# Rolling_ECG_display.py

from machine import Pin, ADC, I2C
from time import sleep
import ssd1306

i2c = I2C(-1, scl=Pin(22), sda=Pin(21))

oled_width = 128
oled_height = 64
oled = ssd1306.SSD1306_I2C(oled_width, oled_height, i2c)

pot = ADC(Pin(34))
pot.atten(ADC.ATTN_11DB)       #Full range: 3.3v
vMax = 3.4
dotPos_old = int(oled_height/2)

while True:
  pot_value = pot.read()
  voltage = 0.000816*pot_value + 0.037822
  # print(voltage)
  
  dotPos_new = oled_height-int(voltage/vMax*oled_height)-1
  
  oled.line(0, dotPos_new, 0, dotPos_old, 1)
  oled.scroll(1, 0)
  oled.line(0, dotPos_new, 0, dotPos_old, 0)
  
  dotPos_old = dotPos_new
  # oled.pixel(0, int(oled_height/2), 1) # zero line
  oled.show()



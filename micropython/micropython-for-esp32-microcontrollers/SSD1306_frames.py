# SSD1306_frames.py

from machine import Pin, I2C
import ssd1306

i2c = I2C(-1,scl=Pin(22),sda=Pin(21))
oled_width = 128
oled_height = 64
oled = ssd1306.SSD1306_I2C(oled_width, oled_height, i2c)

for n in [0,5,10,15,20,25]:
  oled.hline(n, n, oled_width-1-2*n, 1-2*n)
  oled.hline(n, oled_height-1-n, oled_width-1-2*n, 1-2*n)
  oled.vline(n, n, oled_height-1-2*n, 1-2*n)
  oled.vline(oled_width-1-n, n, oled_height-2*n, 1-2*n)
  oled.show()
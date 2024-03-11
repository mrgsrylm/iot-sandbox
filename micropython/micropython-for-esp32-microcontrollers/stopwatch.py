# stopwatch.py

from machine import Pin, I2C
import time
from ssd1306 import SSD1306_I2C

i2c = I2C(-1, scl=Pin(22), sda=Pin(21))
oled_width = 128
oled_height = 64
oled = SSD1306_I2C(oled_width,oled_height,i2c)

start_button = Pin(2,Pin.IN,Pin.PULL_UP)
stop_button = Pin(4,Pin.IN,Pin.PULL_UP)
start_time = 0
total_time = 0
active = False

lin_hight = 5
col_width = 8

led = Pin(25, Pin.OUT)

def text_write(text, lin, col=0):
  oled.text(text, col*col_width, lin*lin_hight)
  
def time_text(time):
  mills = time%1000
  secs = (time//1000)%60
  mins = (time//60000)%60
  hours = (time//3600000)%24
  return "{:02d}:{:02d}:{:02d}.{:03d}".format(hours,mins,secs,mills)

def show():
  oled.fill(0)
  total_text=time_text(total_time)
  text_write(total_text,6,2)
  oled.show()
  
while True:
  if not active:
    led.value(0)  
    if not start_button.value():
      start_time = time.ticks_ms()
      active = True
  if active:
    led.value(1)  
    total_time = time.ticks_ms() - start_time
    if not stop_button.value():
      active = False
      time.sleep(3)
      total_time=0
  show()              
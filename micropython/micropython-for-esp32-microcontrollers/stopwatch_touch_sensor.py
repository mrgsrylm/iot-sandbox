# stopwatch_touch_sensor.py

from machine import Pin, I2C, TouchPad
import time
from ssd1306 import SSD1306_I2C

i2c = I2C(-1, scl=Pin(22), sda=Pin(21))
oled_width = 128
oled_height = 64
oled = SSD1306_I2C(oled_width,oled_height,i2c)

t1 = TouchPad(Pin(2)) # start sensor pad
t2 = TouchPad(Pin(4)) # stop sensor pad

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
  
def start_touch():
  if t1.read() < 500:
    return True
  else:
    return False

def stop_touch():
  if t2.read() < 500:
    return True
  else:
    return False
  
while True:
  if not active:
    led.value(0)  
    if start_touch():
      start_time = time.ticks_ms()
      active = True
  if active:
    led.value(1)  
    total_time = time.ticks_ms() - start_time
    if stop_touch():
      active = False
      time.sleep(3)
      total_time=0
  show()              

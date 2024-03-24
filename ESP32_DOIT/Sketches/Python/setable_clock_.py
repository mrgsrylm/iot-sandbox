# setable_clock.py

from machine import Pin,I2C
import time
from ssd1306 import SSD1306_I2C

i2c = I2C(-1,scl=Pin(22),sda=Pin(21))
oled_width=128
oled_height=64
oled = SSD1306_I2C(oled_width,oled_height,i2c)

time_offset=20*3600+00*60+0  # hh+mm+ss
lin_hight=5
col_width=8

def handle_interrupt_min(pin):
  global time_offset
  time_offset+=60
  time.sleep(.2)
  
def handle_interrupt_hr(pin):
  global time_offset
  time_offset+=3600
  time.sleep(.2)

button_min = Pin(4, Pin.IN)
button_min.irq(trigger=Pin.IRQ_RISING, handler=handle_interrupt_min)

button_hr = Pin(2, Pin.IN)
button_hr.irq(trigger=Pin.IRQ_RISING, handler=handle_interrupt_hr)

def text_write(text, lin, col=0):
  oled.text(text, col*col_width, lin*lin_hight)

def time_text(time):
  secs=time%60
  mins=(time//60)%60
  hours=(time//3600)%24
  return "{:02d}:{:02d}:{:02d}".format(hours,mins,secs)

def show():
  oled.fill(0) 
  text_write("Current time:",1,2)
  current_text = time_text(current_time)
  text_write(current_text,6,4)
  oled.rect(10,25,108,16,1)
  oled.show()

while True:
    current_time=time_offset+time.time()
    show()
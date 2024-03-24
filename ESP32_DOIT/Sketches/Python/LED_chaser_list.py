# LED_chaser_list.py

from machine import Pin
from time import sleep

LED = [25,26,32,27,14]


del_time = 0.1

for n in range(len(LED)):
  LED[n] = Pin(LED[n],Pin.OUT)
  
    
while True:
  for n in range(len(LED)):
    LED[n].value(1)
    sleep(del_time)
    LED[n].value(0)
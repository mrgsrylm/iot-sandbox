# bike light.py

# bike_light.py

from machine import Pin
from time import sleep

LED = [25,26,32,27,14]
del_time = 0.1
mode=1

def handle_interrupt(button1):
  global mode
  mode+=1
  if(mode>4):
    mode=1
  print(mode)

button1 = Pin(4, Pin.IN)
button1.irq(trigger=Pin.IRQ_RISING, handler=handle_interrupt)

for n in range(len(LED)):
  LED[n] = Pin(LED[n],Pin.OUT)

while True:
  if (mode==1):     # LEDs all on
    for n in range(len(LED)):
      LED[n].value(1)
  if (mode==2):    # LEDs blink
    for n in range(len(LED)):
      LED[n].value(1)
    sleep(del_time)
    for n in range(len(LED)):  
      LED[n].value(0)
    sleep(del_time)
  if (mode==3):    # LEDs flash
    for n in range(len(LED)):
      LED[n].value(1)
    sleep(del_time)
    for n in range(len(LED)):  
      LED[n].value(0)
    sleep(del_time*5)
  if (mode==4):    # LEDs chaser
    for n in range(len(LED)):
      LED[n].value(1)
      sleep(del_time)
      LED[n].value(0)
      sleep(del_time)

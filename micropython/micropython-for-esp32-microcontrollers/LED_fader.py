# LED_fader.py

import machine
from time import sleep

LED = machine.Pin(25)

# create the PWM object
pwmLED = machine.PWM(LED)

timedelay = 0.001
pwmLED.freq(5000)

while True:
  for dc in range (0, 1023):
    pwmLED.duty(dc)
    pwmLED
    sleep(timedelay)
  for dc in range (1023, 0, -1):
    pwmLED.duty(dc)
    pwmLED
    sleep(timedelay)
  
   
    

    
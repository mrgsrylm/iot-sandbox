# MulticolorLED.py

import machine
from time import sleep

# create the PWM objects
LEDred = machine.Pin(25)
LEDgreen = machine.Pin(26)
LEDblue = machine.Pin(32)

# create the PWM objects
pwmLEDred = machine.PWM(LEDred)
pwmLEDgreen = machine.PWM(LEDgreen)
pwmLEDblue = machine.PWM(LEDblue)

timedelay = 0.001
pwmLEDred.freq(100)
pwmLEDgreen.freq(100)
pwmLEDblue.freq(100)

while True:
  for dc in range (0, 1023):
    pwmLEDblue.duty(dc)
    pwmLEDblue
    sleep(timedelay)
 
  for dc in range (0, 1023):
    pwmLEDgreen.duty(dc)
    pwmLEDgreen
    sleep(timedelay)
    
  for dc in range (0, 1023):
    pwmLEDred.duty(dc)
    pwmLEDred
    sleep(timedelay)
 
  for dc in range (1023, 0, -1):
    pwmLEDgreen.duty(dc)
    pwmLEDgreen
    sleep(timedelay)
    
  for dc in range (1023, 0, -1):
    pwmLEDblue.duty(dc)
    pwmLEDblue
    sleep(timedelay)
    
  for dc in range (1023, 0, -1):
    pwmLEDred.duty(dc)
    pwmLEDred
    sleep(timedelay)
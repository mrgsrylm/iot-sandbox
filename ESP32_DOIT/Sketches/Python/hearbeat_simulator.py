# heartbeat_simulator.py

import machine
from time import sleep_us

LED = machine.Pin(25)

# create the PWM object
pwmLED = machine.PWM(LED)

timedelay1 = 300
timedelay2 = 1000
pwmLED.freq(5000)

while True:
  # main beat
  for dc in range (0,1023):
      pwmLED.duty(dc)
      pwmLED
      sleep_us(timedelay1)
  for dc in range (1023, 0, -1):
      pwmLED.duty(dc)
      pwmLED
      sleep_us(timedelay1)
  
  # low beat
  for dc in range (0,255):
      pwmLED.duty(dc)
      pwmLED
      sleep_us(timedelay2)
  for dc in range (255, 0, -1):
      pwmLED.duty(dc)
      pwmLED
      sleep_us(timedelay2)
  
  pwmLED.duty(0)
  sleep_us(500000)
    

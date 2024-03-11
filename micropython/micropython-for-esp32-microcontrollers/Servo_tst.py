# Servo_tst.py

import machine
from machine import Pin
from time import sleep

p4 = machine.Pin(18)
servo = machine.PWM(p4,freq=50)

# duty for servo is between 52...102
duty_min=52 # 52*20/1023 ms=1.02 ms
duty_mid=77 # 77*20/1023 ms=1.51 ms
duty_max=102 # 102*20/1023 ms=1.99 ms
  
while True:
    for pos in (duty_min,duty_mid,duty_max):
        print(pos)
        servo.duty(pos)
        sleep(1)
    

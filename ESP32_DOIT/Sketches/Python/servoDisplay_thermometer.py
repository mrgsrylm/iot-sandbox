# servoDisplay_thermometer.py

import machine
from machine import Pin
import onewire
import ds18x20
from time import sleep

p4 = machine.Pin(18)
servo = machine.PWM(p4,freq=50)

# duty for servo is between 40 - 115
duty_min=52  # 52*20/1023  ms=1.02 ms
duty_mid=77  # 77*20/1023  ms=1.51 ms
duty_max=102 # 102*20/1023 ms=1.99 ms

ow=onewire.OneWire(Pin(25))   #Init wire
ow.scan()
ds=ds18x20.DS18X20(ow)        #create ds18x20 object
  
while True:
    roms=ds.scan()                #scan ds18x20
    ds.convert_temp()             #convert temperature
    for rom in roms:
        T=ds.read_temp(rom) 
    print(T)                      # test output temperature
    pos = int(duty_max-(duty_max-duty_min)*T/50)
    print(pos)                    # test output servo position
    servo.duty(pos)
    sleep(1)



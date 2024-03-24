# sawtoot.py
# 8-bit DAC range:0-255，output voltage:0-3.3V

from machine import Pin, DAC
from time import sleep_us

#define AnalogOut 25
dac0=DAC(Pin(25))       

while (True):
  for DACValue_0 in range(255):
    print(DACValue_0)
    dac0.write(DACValue_0) 
    sleep_us(1)



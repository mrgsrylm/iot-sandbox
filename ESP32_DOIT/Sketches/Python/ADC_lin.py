# ADC_lin.py

from machine import Pin, ADC
from time import sleep
pot = ADC(Pin(34))
pot.atten(ADC.ATTN_11DB) #Full range: 3.3v

while True:
  pot_value = pot.read() 
  voltage = 0.000816*pot_value + 0.037822
  print(voltage)
  sleep(0.1)
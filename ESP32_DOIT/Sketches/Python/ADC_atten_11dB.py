# ADC_atten_11db.py

from machine import ADC, Pin
from time import sleep

adc = ADC(Pin(34))  # create ADC object on ADC pin
adc.atten(ADC.ATTN_11DB)

while True:
  print(adc.read())   # read value, 0-1024
  sleep(1)
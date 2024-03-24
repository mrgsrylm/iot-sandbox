# BPW40_luxmeter.py

from machine import Pin, ADC
from time import sleep

fotoPin = ADC(Pin(34))
fotoPin.atten(ADC.ATTN_11DB)  # input range 0 ... 3,3 V

averages=10

while True:
  luxValue=0
  for average in range(averages):
    luxData=fotoPin.read()
    luxValue+=luxData/40.96    # DAC 4096 -> 100 %
  luxValue/=averages
  output="Light level: {:6.1f} %"
  print(output.format(luxValue))
  sleep(1)
  
    
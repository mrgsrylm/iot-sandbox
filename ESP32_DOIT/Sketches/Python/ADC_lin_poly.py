# ADC_lin_poly.py

from machine import ADC, Pin
from time import sleep

adc = ADC(Pin(34))  # create ADC object on ADC pin
adc.atten(ADC.ATTN_11DB)


def ReadVoltage():
  ADC=adc.read()
  return -0.000000000009824*pow(ADC,3)+0.000000016557283*pow(ADC,2)+0.000854596860691*ADC+0.065440348345433;

while True:
  print(adc.read(), " ", end="")
  print(ReadVoltage())
  sleep(0.1)
  
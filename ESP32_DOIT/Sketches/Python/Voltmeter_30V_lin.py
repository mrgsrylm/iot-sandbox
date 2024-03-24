# Voltmeter_30V_lin.py

from machine import ADC, Pin
from time import sleep

adc = ADC(Pin(34))  # create ADC object on ADC pin
adc.atten(ADC.ATTN_11DB)

Vref=3.30           # internal reference voltage
R1=100              # for voltage divider
R2=10               # for voltage divide
cal=1*(R1+R2)/R2    # calibration factor

def ReadVoltage():
  ADC=adc.read()
  return -0.000000000009824*pow(ADC,3)+0.000000016557283*pow(ADC,2)+0.000854596860691*ADC+0.065440348345433;

while True:
  output="V = {:5.1f} V"
  print(output.format(ReadVoltage()*cal))  
  sleep(1)
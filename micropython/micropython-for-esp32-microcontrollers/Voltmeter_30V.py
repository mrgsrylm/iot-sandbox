# Voltmeter_30V.py

from machine import ADC, Pin
from time import sleep

adc = ADC(Pin(34))  # create ADC object on ADC pin
adc.atten(ADC.ATTN_11DB)

Vref=3.30           # internal reference voltage
R1=100              # for voltage divider
R2=10               # for voltage divide
cal=1*(R1+R2)/R2    # calibration factor

while True:
  output="V = {:5.1f} V"
  print(output.format(adc.read()*Vref/4095*cal))  
  sleep(1)


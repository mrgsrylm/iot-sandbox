# TMP36_TempSens_test.py

from machine import Pin, ADC
from time import sleep

TMP36pin = ADC(Pin(34))
TMP36pin.atten(ADC.ATTN_0DB)  # input range 0 ... 1 V

averages=10

while True:
  T=0
  for average in range(averages):
    TMP36data=TMP36pin.read()
    TMP36_mV=TMP36data/4.096    # sensor voltage in Millivolt
    T+=(TMP36_mV-500.0)/10.0;
  # print(int(10*T/averages)/10.0)
  output = "T =  {:4.1f} °C"
  print(output.format(T/10))
  sleep(1)
# DAC_test.py
# 8bit DAC range:0-255 - output voltage:0-3.3V

from machine import Pin, DAC

DACValue_0=125

dac0=DAC(Pin(25))       
dac0.write(DACValue_0) # output 1.62V
# distorted_sinus.py

from math import sin, pi
from machine import DAC
from machine import Pin

dac0 = DAC(Pin(25))

offset = 128
amplitude = 127
buffferlength = 100

# create a buffer containing a sine-wave
buf = bytearray(buffferlength)
for n in range(len(buf)):
  buf[n] = offset + int(amplitude * sin(2*pi*n/len(buf)))
  
# insert special values
  buf[25] = offset
  buf[75] = offset

while 1:
  for i in range(len(buf)):
    dac0.write(buf[i])
    
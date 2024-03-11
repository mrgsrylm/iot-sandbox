# sinus_square_generator.py

from math import sin, pi
from machine import DAC
from machine import Pin

dac0 = DAC(Pin(25))
dac1 = DAC(Pin(26))

offset = 128
amplitude = 127
bufferlength = 100

# create a buffer containing a sine-wave
buf = bytearray(100)
for n in range(len(buf)):
  buf[n] = offset + int(amplitude * sin(2*pi*n/len(buf)))

while 1:
  for i in range(len(buf)):
    dac0.write(buf[i])
    if buf[i] > amplitude:
      dac1.write(255)
    else:
      dac1.write(0)
    
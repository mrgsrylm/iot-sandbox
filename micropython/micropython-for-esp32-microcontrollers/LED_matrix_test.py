# LED_matrix_test.py

import max7219
from machine import Pin, SPI

spi = SPI(1, baudrate=10000000, polarity=1, phase=0, sck=Pin(4), mosi=Pin(2))
ss = Pin(5, Pin.OUT)

display = max7219.Matrix8x8(spi, ss, 6)
display.text('Python',0,0,1)
display.show()
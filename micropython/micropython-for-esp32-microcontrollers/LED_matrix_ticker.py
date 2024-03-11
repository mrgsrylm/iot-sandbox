# LED_matrix_ticker.py

import max7219
from machine import Pin, SPI
from time import sleep

spi = SPI(1,baudrate=10000000, polarity=1, phase=0, sck=Pin(4), mosi=Pin(2))
ss = Pin(5,Pin.OUT)
speedFactor=0.05
pixelDistance=7
display = max7219.Matrix8x8(spi, ss, 6)

def moveLeft(Pixel):
    for i in range(Pixel):
         display.scroll(-1,0)
         sleep(speedFactor)
         display.show()

while True:
    display.text('P',40,0,1)
    moveLeft(pixelDistance)
    display.text('y',40,0,1)
    moveLeft(pixelDistance)
    display.text('t',40,0,1)
    moveLeft(pixelDistance)
    display.text('h',40,0,1)
    moveLeft(pixelDistance)  
    display.text('o',40,0,1)
    moveLeft(pixelDistance)
    display.text('n',40,0,1)
    moveLeft(pixelDistance)  
    display.text(' ',40,0,1)
    moveLeft(pixelDistance)
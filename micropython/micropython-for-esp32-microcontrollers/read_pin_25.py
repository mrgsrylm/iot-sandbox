# read_pin_25.py

from machine import Pin
from time import sleep

pin_in = Pin(25, Pin.IN, Pin.PULL_DOWN)

while(True):
    print(pin_in())
    sleep(1)

# LED_interrupt.py

from machine import Pin
from time import sleep

timeOn=3
key_pressed=False

def handle_interrupt(pin):
  global key_pressed
  key_pressed=True
  
led = Pin(25, Pin.OUT)
button1 = Pin(4, Pin.IN)
button1.irq(trigger=Pin.IRQ_RISING, handler=handle_interrupt)

while True:
  if key_pressed:
    print('Interrupt detected')
    led.value(1)
    sleep(timeOn)
    led.value(0)
    key_pressed = False 
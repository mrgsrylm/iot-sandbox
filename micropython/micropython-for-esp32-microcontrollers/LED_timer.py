# LED_timer.py

import machine

led = machine.Pin(25, machine.Pin.OUT)
timer = machine.Timer(0)  

def handleInterrupt(timer):
  led.value(not led.value())

timer.init(period=1000, mode=machine.Timer.PERIODIC, callback=handleInterrupt)
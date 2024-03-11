# LED_double_timer.py

import machine

led1 = machine.Pin(25, machine.Pin.OUT)
led2 = machine.Pin(26, machine.Pin.OUT)

timer1 = machine.Timer(0)  
timer2 = machine.Timer(1)

def handleInterrupt1(timer1):
  led1.value(not led1.value())
def handleInterrupt2(timer2):
  led2.value(not led2.value())

timer1.init(period=125, mode=machine.Timer.PERIODIC, callback=handleInterrupt1)
timer2.init(period=517, mode=machine.Timer.PERIODIC, callback=handleInterrupt2)

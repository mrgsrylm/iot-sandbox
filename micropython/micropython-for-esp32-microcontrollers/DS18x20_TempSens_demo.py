# DS18x20_TempSens_demo.py

from machine import Pin
import onewire
import ds18x20
import time

ow = onewire.OneWire(Pin(25))  # init one wire bus
ow.scan()
ds=ds18x20.DS18X20(ow)         # create ds18x20 object

while True:
  units=ds.scan() # scan for ds18x20 units
  # print(units)
  ds.convert_temp() # convert temperature
  for unit in units:
    T=ds.read_temp(unit)
    output="T = {:5.1f} °C"
    print(output.format(T))
    time.sleep(1)
  print()
  

#This file is executed on every boot (including wake-boot from deepsleep)
#connect to networtk

import network

try:
  import usocket as socket
except:
  import socket
  
import esp
esp.osdebug(None)
import gc
gc.collect()

ssid='ABCDEFGHIJ1234'
password='12345678901234567890'

station=network.WLAN(network.STA_IF)
station.active(True)
station.connect(ssid, password)

while station.isconnected()==False:
  pass

print('Connection successful')
print(station.ifconfig())









#This file is executed on every boot (including wake-boot from deepsleep)

#connect to network
import network
from time import sleep

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
  print("connecting...")
  sleep(1)

print('Connection successful')
print(station.ifconfig())









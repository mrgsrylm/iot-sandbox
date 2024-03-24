#  thingspeak.py

from time import sleep, sleep_ms
import network
from umqtt.simple import MQTTClient

# ThingSpeak com data
SERVER="mqtt.thingspeak.com"
CHANNEL_ID="123456"
WRITE_API_KEY="ABCDEFGHIJKL1234"
PUB_TIME_SEC=15 # final->300

# MQTT client object & MQTT topic string
client=MQTTClient("umqtt_client", SERVER)
topic="channels/"+CHANNEL_ID+"/publish/"+WRITE_API_KEY

# Function to read all data:
def collectData():
  data0,data1=20,65
  return data0,data1

#connect to networtk
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

# send data continuously
while True:
  data0,data1=collectData()
  #check data on terminal
  print(data0,data1)
  payload="field1="+str(data0)+"&field2="+str(data1)
  client.connect()
  client.publish(topic, payload)
  client.disconnect()
  sleep(PUB_TIME_SEC)   
  








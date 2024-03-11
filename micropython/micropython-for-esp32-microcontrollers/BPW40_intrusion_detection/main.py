#  BPW40_intrusion_detection.py
from time import sleep
from umqtt.simple import MQTTClient
from machine import Pin, ADC

# ThingSpeak data
SERVER="mqtt.thingspeak.com"
CHANNEL_ID="123456"
WRITE_API_KEY="ABCDEFGHIJK12345"
PUB_TIME_SEC=15 # final->300
# MQTT client object & MQTT topic string
client=MQTTClient("umqtt_client", SERVER)
topic="channels/"+CHANNEL_ID+"/publish/"+WRITE_API_KEY

fotoPin = ADC(Pin(34))
fotoPin.atten(ADC.ATTN_11DB)  # input range 0 ... 3,3 V

# Function to read all data:
def collectData():
  data0=fotoPin.read()/40.96
  return data0

# send data continuously
while True:
  data0=collectData()
  #check data on terminal
  print(data0)
  payload="field1="+str(data0)
  client.connect()
  client.publish(topic, payload)
  client.disconnect()
  sleep(PUB_TIME_SEC)   
  
  










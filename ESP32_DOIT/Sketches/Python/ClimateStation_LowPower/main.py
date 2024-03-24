#  ClimateStation_low_power.py
import network
from umqtt.simple import MQTTClient
from time import sleep
from machine import Pin, I2C
import machine
import ssd1306
import BME280

PUB_TIME_SEC=15000 # in milliseconds final->300000

# ThingSpeak com data
SERVER="mqtt.thingspeak.com"
CHANNEL_ID="123456"
WRITE_API_KEY="ABCDEFGHIJKL1234"

# MQTT client object & MQTT topic string
client=MQTTClient("umqtt_client", SERVER)
topic="channels/"+CHANNEL_ID+"/publish/"+WRITE_API_KEY

# ESP32 - Pin assignment
i2c = I2C(scl=Pin(22), sda=Pin(21), freq=10000)

# OLED setup
oled_width = 128
oled_height = 64
oled = ssd1306.SSD1306_I2C(oled_width, oled_height, i2c)

# Function to read all data:
def collectData():
  bme =BME280.BME280(i2c=i2c)
  temp=0.01*int(bme.read_temperature())
  humi=0.01*int(bme.read_humidity()/10.24)
  pres=0.01*int(bme.read_pressure()/256)
  return temp,humi,pres

# send data continuously
while True:
  oled.fill(0)
  oled.text('BME280 climate', 0, 0)
  temp,humi,pres=collectData()
    
  print('Temp: %7.1f' %temp)
  print('Humi: %7.1f' %humi)
  print('Pres: %7.1f' %pres)
  print()
  
  temp_string=str('Temp:%7.2f' %temp)
  humi_string =str('Humi:%7.2f' %humi)
  pres_string=str('Pres:%7.2f' %pres)
    
  oled.text(temp_string, 0, 10)
  oled.text(' C', 90 ,10)
  oled.text(humi_string, 0, 20)
  oled.text(' %', 90 ,20)
  oled.text(pres_string, 0, 30)
  oled.text(' hPa', 90 ,30)
  oled.show()
    
  #check data on terminal
  print("Data for ThingSpeak:")
  print(temp,humi,pres)
  print("--------------------")
  #send date to ThingSpeak
  payload="field1="+str(temp)+"&field2="+str(humi)+"&field3="+str(pres)
  client.connect()
  client.publish(topic, payload)
  client.disconnect()
  sleep(1)
  oled.text('Going to sleep.. ', 0 ,50)
  oled.show()
  machine.deepsleep(PUB_TIME_SEC)   
  








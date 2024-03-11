# main: MQTT_ThingSpeak

from umqtt.robust import MQTTClient
import time
import os
#import gc
import sys
from machine import ADC, Pin

adc = ADC(Pin(34))  # create ADC object on ADC pin
adc.atten(ADC.ATTN_11DB)
 
# create a random MQTT clientID 
randomNum = int.from_bytes(os.urandom(3), 'little')
myMqttClient = bytes("client_"+str(randomNum), 'utf-8')

# connect to Thingspeak MQTT broker via unsecure TCP (port 1883)
THINGSPEAK_URL=b"mqtt.thingspeak.com" 
THINGSPEAK_USER_ID=b'abcdefghijklm'
THINGSPEAK_MQTT_API_KEY=b'ABCDEFGHIJ123456'
client=MQTTClient(client_id=myMqttClient, 
                    server=THINGSPEAK_URL, 
                    user=THINGSPEAK_USER_ID, 
                    password=THINGSPEAK_MQTT_API_KEY, 
                    ssl=False)
                    
try:            
    client.connect()
except Exception as e:
    print('could not connect to MQTT server {}{}'.format(type(e).__name__, e))
    sys.exit()

# publish to Thingspeak using MQTT
THINGSPEAK_CHANNEL_ID = b'123456'
THINGSPEAK_CHANNEL_WRITE_API_KEY = b'ABCDEFGHJI123456'
PUB_TIME_SEC = 15 
while True:
    try:
        dummyData = adc.read()
        print(dummyData)
        credentials = bytes("channels/{:s}/publish/{:s}".format(THINGSPEAK_CHANNEL_ID, THINGSPEAK_CHANNEL_WRITE_API_KEY), 'utf-8')  
        payload = bytes("field1={:.1f}\n".format(dummyData), 'utf-8')
        client.publish(credentials, payload)
        time.sleep(PUB_TIME_SEC)
    except KeyboardInterrupt:
        print('exit...')
        client.disconnect()
        sys.exit()    

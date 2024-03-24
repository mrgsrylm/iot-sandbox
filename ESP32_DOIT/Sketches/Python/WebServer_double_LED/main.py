# main.py: WebServer_WLAN_switch

from machine import Pin
led1 = Pin(22,Pin.OUT)
led2 = Pin(23,Pin.OUT)

def web_page():
  if led1.value()==1:
    gpio_state1="ON"
  else:
    gpio_state1="OFF"
  
  if led2.value()==1:
    gpio_state2="ON"
  else:
    gpio_state2="OFF"
  
  html = """<html><head> <title>WLAN server</title> <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="data:,"> 
  
  <style>html{font-family: Arial; display:inline-block; margin: 0px auto; text-align: left}
  h1{color: black; padding: 2vh; font-size: 20px;}
  
  .buttonGreen{display: inline-block; background-color: green; border: none; font-size: 20px; margin: 10px; cursor: pointer;}  
  .buttonRed{display: inline-block; background-color: red; border: none; font-size: 20px; margin: 10px; cursor: pointer;}
  
  </style></head><body> <h1>WLAN server V 1.2</h1; text-align: left> 
  
  <p>Channel 1: """ + gpio_state1 + """
  </p><p><a href="/led1=on"><button class="buttonGreen">ON</button></a>
         <a href="/led1=off"><button class="buttonRed">OFF</button></a></p>
  
  <p>Channel 2: """ + gpio_state2 + """
  </p><p><a href="/led2=on"><button class="buttonGreen">ON</button></a>
         <a href="/led2=off"><button class="buttonRed">OFF</button></a></p>
  </body></html>"""
    
  return html

s=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(('', 80))
s.listen(5)

while True:
  conn, addr = s.accept()
  print('Got a connection from %s' % str(addr))
  request = conn.recv(1024)
  request = str(request)
  print('Content = %s' % request)
  led1_on = request.find('/led1=on')
  led1_off = request.find('/led1=off')
  led2_on = request.find('/led2=on')
  led2_off = request.find('/led2=off')
  if led1_on==6:
    print('LED ON')
    led1.value(1)
  if led1_off==6:
    print('LED OFF')
    led1.value(0)
  if led2_on==6:
    print('LED ON')
    led2.value(1)
  if led2_off==6:
    print('LED OFF')
    led2.value(0)
  
  response = web_page()
  conn.send(response)
  conn.close()

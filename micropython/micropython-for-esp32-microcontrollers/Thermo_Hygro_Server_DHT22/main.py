# main.py: Thermo_Hygro_Server_DHT22

from machine import Pin
import dht
sensor = dht.DHT22(Pin(14))

def read_sensor():
  global temp, hum
  temp = hum = 0
  try:
    sensor.measure()
    temp = sensor.temperature()
    hum = sensor.humidity()
    msg = (b'{0:3.1f},{1:3.1f}'.format(temp, hum))
    print(msg)
    return(msg)
  except OSError as e:
    return('Failed to read sensor.')

def web_page():
  html = """<!DOCTYPE HTML><html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
    html { font-family: Arial; display: inline-block; margin: 0px auto; text-align: center;    }
    h2 { font-size: 2.0rem; } p { font-size: 2.0rem; }
    .units { font-size: 2.0rem; }
    .dht-labels{ font-size: 2.0rem; vertical-align:bottom; padding-bottom: 0px; }
  </style>
</head>
<body>
  <h2>Thermo/Hygro Server</h2>
  <p>
    <span class="dht-labels">Temperature:</span> 
    <span>"""+str(temp)+"""</span>
    <span class="units">&deg;C</span>
  </p>
  <p>
    <span class="dht-labels">Humidity:</span>
    <span>"""+str(hum)+"""</span>
    <span class="units">%</span>
  </p>
</body>
</html>"""
  return html

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(('', 80))
s.listen(5)

while True:
  conn, addr = s.accept()
  print('Got a connection from %s' % str(addr))
  request = conn.recv(1024)
  print('Content = %s' % str(request))
  sensor_readings = read_sensor()
  print(sensor_readings)
  response = web_page()
  conn.sendall(response)
  conn.close()









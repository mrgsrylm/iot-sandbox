# I2C_scanner.py

from machine import Pin, I2C

#i2c = I2C(scl=Pin(5), sda=Pin(4))
i2c = I2C(-1, scl=Pin(22), sda=Pin(21))

print('Scan i2c bus...')
devices = i2c.scan()

if len(devices) == 0:
  print("No i2c device !")
else:
  print('i2c devices found:',len(devices))

  for device in devices:  
    print("Decimal address: ",device," - Hex address: ",hex(device))

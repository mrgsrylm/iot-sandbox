# Hall_sensor_test.py

import esp32
from time import sleep

esp32.hall_sensor()     # read internal hall sensor

while True:
    print(esp32.hall_sensor())
    sleep(1)
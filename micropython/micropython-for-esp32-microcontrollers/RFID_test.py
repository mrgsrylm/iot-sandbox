# RFID_test.py

import mfrc522

# RFID RX pinning
sck = 0
mosi= 2
miso= 4
rst = 5
cs  =14    # SDA on RFID-RC522 boards

def do_read():
    rdr = mfrc522.MFRC522(sck, mosi, miso, rst, cs)
    print("Place card before reader")
    try:
        while True:
            (stat, tag_type) = rdr.request(rdr.REQIDL)
            if stat == rdr.OK:
                (stat, raw_uid) = rdr.anticoll()
                if stat == rdr.OK:
                    print("Card detected")
                    print("type: 0x%02x" % tag_type)
                    print(raw_uid[0], raw_uid[1], raw_uid[2], raw_uid[3])
                    print("")
    except KeyboardInterrupt:
        print("Bye")
        
while True:
    do_read()
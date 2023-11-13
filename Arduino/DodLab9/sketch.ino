#include "OneWire.h"

OneWire ds(8); // Create a OneWire object for the 1-Wire bus to interact with the sensor

byte i;
byte present = 0;
byte data[12];
float celsius;
//---------------------------------------------
#define DHT22_PIN 7

unsigned long HIGH_TIME = 0;
unsigned long LOW_TIME = 0;

unsigned int humidity = 0;
// unsigned int temperature = 0;
int p;

unsigned char dataByte[5];
unsigned int dataPackage[40];
unsigned char bitData = 0;
unsigned char checksumByte = 0;
int bitCounter = 0;
//------------------------------------------

void setup()
{
    Serial.begin(9600);
    delay(1000);
}

void loop()
{
    pinMode(DHT22_PIN, OUTPUT);
    digitalWrite(DHT22_PIN, LOW);
    delay(18);
    digitalWrite(DHT22_PIN, HIGH);
    pinMode(DHT22_PIN, INPUT_PULLUP);

    LOW_TIME = pulseIn(DHT22_PIN, LOW);
    if (LOW_TIME <= 84 && LOW_TIME >= 76)
    {
        while (1)
        {
            HIGH_TIME = pulseIn(DHT22_PIN, HIGH);
            if (HIGH_TIME <= 28 && HIGH_TIME >= 20)
            {
                bitData = 0;
            }
            else if (HIGH_TIME <= 74 && HIGH_TIME >= 65)
            {
                bitData = 1;
            }
            else if (bitCounter == 40)
            {
                break;
            }
            dataByte[bitCounter / 8] |= bitData << (7 - (bitCounter % 8));
            dataPackage[bitCounter] = bitData;
            bitCounter++;
        }
    }

    checksumByte = dataByte[0] + dataByte[1] + dataByte[2] + dataByte[3];

    if (checksumByte == dataByte[4] && checksumByte != 0)
    {

        Serial.println("Humidity: ");
        for (int c = 0; c <= 7; c++)
        {
            Serial.print(dataPackage[c]);
        }
        Serial.print(" ");
        for (int c = 0; c <= 7; c++)
        {
            Serial.print(dataPackage[c + 8]);
        }
        Serial.print("\t");

        p = 15;
        for (int c = 0; c <= 15; c++)
        {
            humidity += dataPackage[c] * pow(2, p);
            p--;
        }
        Serial.print(humidity / 10);
        Serial.print(".");
        Serial.print(humidity % 10);
        Serial.println("%");
        Serial.println();

        Serial.println("Checksum Byte: ");
        for (int c = 0; c <= 7; c++)
        {
            Serial.print(dataPackage[c + 32]);
        }
        Serial.print(" ");
        Serial.print("CHECKSUM_OK");
        Serial.println();
    }

    bitCounter = 0;
    dataByte[0] = dataByte[1] = dataByte[2] = dataByte[3] = dataByte[4] = 0;
    humidity = 0;
    // temperature = 0;

    // Determine the temperature from the DS18b20 sensor
    ds.reset();        // Start interaction by resetting all previous commands and parameters
    ds.write(0xCC);    // Command the DS18b20 sensor to skip the address search. In our case, there is only one device
    ds.write(0x44, 1); // Command the DS18b20 sensor to measure the temperature.
    // We do not receive the temperature value itself yet - the sensor stores it in its internal memory

    delay(1000);

    present = ds.reset();
    ds.write(0xCC);
    ds.write(0xBE); // Request the sensor to transfer the register values containing the temperature
    for (i = 0; i < 9; i++)
    { // We need 9 bytes
        data[i] = ds.read();
    }

    /* Convert the data to actual temperature
    ** since the result is a 16-bit signed integer, 
    ** it must be stored in the "int16_t" type, 
    ** which always has a length of 16 bits
    ** even when compiled on a 32-bit processor.*/
    int16_t raw = (data[1] << 8) | data[0];
    // case 0x10: Chip = DS18S20" or old DS1820
    raw = raw << 3; // 9-bit resolution default
    if (data[7] == 0x10)
    {
        // "count remain" gives full 12-bit resolution
        raw = (raw & 0xFFF0) + 12 - data[6];
    }

    celsius = (float)raw / 16.0;
    Serial.print("Temperature = ");
    Serial.print(celsius);
    Serial.println("C");
}

#include <dht.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);
dht DHT;

void setup() {
  lcd.begin();
  lcd.backlight();
  delay(1000);
}

void loop() {
  DHT.read11(7);

  lcd.clear();
  lcd.print("Temp : ");
  lcd.print(DHT.temperature);
  lcd.print(" C");
  lcd.setCursor(0,1);
  lcd.print("Humid : ");
  lcd.print(DHT.humidity);
  lcd.print(" %");

  delay(5000);
}

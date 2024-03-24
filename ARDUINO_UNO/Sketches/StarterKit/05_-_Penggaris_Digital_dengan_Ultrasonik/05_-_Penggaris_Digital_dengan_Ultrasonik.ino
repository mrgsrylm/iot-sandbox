#include <HCSR04.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);
HCSR04 hc(5,6);//initialisation class HCSR04 (trig pin , echo pin)

void setup(){
  lcd.begin();
  lcd.backlight();
  lcd.print("Jarak Objek : ");
}

void loop(){
  lcd.setCursor(0,1);
  lcd.print(hc.dist());
  lcd.print(" cm          ");
  delay(300);
}

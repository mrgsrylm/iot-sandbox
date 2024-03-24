#include <LiquidCrystal_I2C.h>

int lcdColumns = 16;
int lcdRows = 2;

LiquidCrystal_I2C lcd(0x27, lcdColumns, lcdRows);

void setup(){
    // initialize LCD
    lcd.init();
    // turn on LCD backlight
    lcd.backlight();
}

void loop(){
    // set cursor to first column, first row
    lcd.setCursor(0, 0);
    // print message
    lcd.print("Hello, World!");
    delay(1000);
    // clears the display to print new message
    lcd.clear();
    // set cursor to first column, second row
    lcd.setCursor(0,1);
    lcd.print("Hello, World!");
    delay(1000);
    lcd.clear();
}

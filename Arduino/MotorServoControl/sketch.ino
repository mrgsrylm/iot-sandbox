#include <Servo.h>

Servo motorServo;

int pinPotentiometer = A0;
int value;

void setup() {
  motorServo.attach(9);

}

void loop() {
  value = analogRead(pinPotentiometer);
  value = map(value, 0, 1023, 0, 180);
  motorServo.write(value);
  delay(15);
}

#include <Servo.h>

Servo motorServo;

int pinPotentiometer = A0;
int nilai;

void setup() {
  motorServo.attach(9);
}

void loop() {
  nilai = analogRead(pinPotentiometer);
  nilai = map(nilai, 0, 1023, 0, 180);
  motorServo.write(nilai);
  delay(15);
}

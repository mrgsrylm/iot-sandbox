#include <Servo.h>

Servo myServo;

unsigned long MOVING_TIME = 3000;  // moving time is 3 seconds
unsigned long moveStartTime;
int startAngle = 0;
int stopAngle = 90;

void setup() {
  delay(3000);
  myServo.attach(9);
  myServo.write(90);
}


void loop() {
  unsigned long progress = millis() - moveStartTime;
  if (progress <= MOVING_TIME) {
    // map(value, fromLow, fromHigh, toLow, toHigh)
    long angle = map(progress, 0, MOVING_TIME, startAngle, stopAngle);
    myServo.write(angle);
  }
}

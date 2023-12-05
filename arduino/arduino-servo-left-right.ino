#include <Servo.h>

Servo myServo;

// unsigned long MOVING_TIME = 3000;  // moving time is 3 seconds
// unsigned long moveStartTime;
// int startAngle = 0;
// int stopAngle = 90;

bool pos = false;

void moveServo(bool pos);

void setup() {
  delay(3000);
  myServo.attach(9);
  myServo.write(90);
}

void loop() {
  int count = 1;
  if (count == 1) {
    moveServo(false, true);
    count = 2;
  }
}

// Fungsi untuk menggerakkan servo sesuai kondisi left dan right
void moveServo(bool left, bool right) {
  if (left) {
    myServo.write(180);   // Posisi 90 derajat ke kiri
    delay(2000);          // Tunggu sebentar
    myServo.write(90);    // Kembali ke posisi awal (0 derajat)
    delay(2000);          // Tunggu sebentar
    left = false;        // Set left ke false setelah berputar
  }

  if (right) {
    myServo.write(0);   // Posisi 90 derajat ke kanan
    delay(2000);          // Tunggu sebentar
    myServo.write(90);    // Kembali ke posisi awal (0 derajat)
    delay(2000);          // Tunggu sebentar
    right = false;       // Set right ke false setelah berputar
  }
}

// void loop() {
//   unsigned long progress = millis() - moveStartTime;
//   if (progress <= MOVING_TIME) {
//     // map(value, fromLow, fromHigh, toLow, toHigh)
//     long angle = map(progress, 0, MOVING_TIME, startAngle, stopAngle);
//     myServo.write(angle);
//   }
// }

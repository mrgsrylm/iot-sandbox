int red_RGB = 11;
int green_RGB = 10;
int blue_RGB = 9;

void setup() {
  pinMode(red_RGB, OUTPUT);
  pinMode(green_RGB, OUTPUT);
  pinMode(blue_RGB, OUTPUT);
}

void loop() {
  RGB_color(255, 0, 0); // Red
  delay(1000);
  RGB_color(0, 255, 0); // Green
  delay(1000);
  RGB_color(0, 0, 255); // Blue
  delay(1000);
  RGB_color(255, 255, 125); // Raspberry
  delay(1000);
  RGB_color(0, 255, 255); // Cyan
  delay(1000);
  RGB_color(255, 0, 255); // Magenta
  delay(1000);
  RGB_color(255, 255, 0); // Yellow
  delay(1000);
  RGB_color(255, 255, 255); // White
  delay(1000);
}

void RGB_color(int nilaiRed, int nilaiGreen, int nilaiBlue)
 {
  analogWrite(red_RGB, nilaiRed);
  analogWrite(green_RGB, nilaiGreen);
  analogWrite(blue_RGB, nilaiBlue);
}

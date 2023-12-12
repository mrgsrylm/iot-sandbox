int pinLed = 7;
int pinSwitch = 3;
int val = 0;

void setup() {
  pinMode(pinLed, OUTPUT);
  pinMode(pinSwitch, INPUT);
}

void loop() {
  val = digitalRead(pinSwitch);
  if(val == HIGH) {
    digitalWrite(pinLed, LOW);
  }
  else {
    digitalWrite(pinLed, HIGH);
  }
}

int PIR = 3;
int buzzer = 7;
int detect = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(PIR, INPUT);
  pinMode(buzzer, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  detect = digitalRead(PIR);

  if (detect == HIGH) {
    activeAlarm();
  }
}

void activeAlarm() {
  for (int i = 0; i < 10; i++) {
    digitalWrite(buzzer, HIGH);
    delay(100);
    digitalWrite(buzzer, LOW);
    delay(100);
  }
}
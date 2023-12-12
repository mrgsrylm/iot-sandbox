int sensor = 5;
int buzzer = 7;
int detektor = 0;

void setup() {
  pinMode(sensor, INPUT);
  pinMode(buzzer, OUTPUT);
}

void loop() {
  detektor = digitalRead(sensor);

  if(detektor == LOW) {
    digitalWrite(buzzer, HIGH);
    delay(200);
  }
  else {
    digitalWrite(buzzer, LOW);
  }
}

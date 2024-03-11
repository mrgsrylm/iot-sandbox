void setup() {
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
}

void loop() {
   digitalWrite(5, HIGH);
   delay(200);
   digitalWrite(6, HIGH);
   delay(200);
   digitalWrite(7, HIGH);
   delay(200);
   digitalWrite(5, LOW);
   delay(200);
   digitalWrite(6, LOW);
   delay(200);
   digitalWrite(7, LOW);
   delay(200);
}

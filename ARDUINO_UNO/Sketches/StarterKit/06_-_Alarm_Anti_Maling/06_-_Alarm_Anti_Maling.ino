int pir = 3;
int buzzer = 7;
int deteksi = 0;

void setup() {
  pinMode(pir, INPUT);
  pinMode(buzzer,OUTPUT);
}

void loop() {
  deteksi = digitalRead(pir);

  if(deteksi == HIGH) {
    alarmAktif();
  }
}

void alarmAktif() {
  for(int i=0; i<10; i++) {
    digitalWrite(buzzer, HIGH);
    delay(100);
    digitalWrite(buzzer, LOW);
    delay(100);
  }
}

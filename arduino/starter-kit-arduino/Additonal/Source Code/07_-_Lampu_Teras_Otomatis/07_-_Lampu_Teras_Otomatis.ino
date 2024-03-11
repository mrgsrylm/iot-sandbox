int ldr = A0;
int led = 7;
int intensitas = 0;

void setup() {
  pinMode(led, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  intensitas = analogRead(ldr);
  Serial.println(intensitas);

  if(intensitas < 700) {
    digitalWrite(led, HIGH);
  }
  else {
    digitalWrite(led, LOW);
  }

  delay(500);
}

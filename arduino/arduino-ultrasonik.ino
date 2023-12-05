const int trigPin = 2;  // Pin trigger sensor ultrasonik
const int echoPin = 3;  // Pin echo sensor ultrasonik

void setup() {
  Serial.begin(9600);  // Inisialisasi komunikasi serial
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
}

void loop() {
  // Mengirimkan sinyal ultrasonik
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  // Menerima dan menghitung durasi echo
  long duration = pulseIn(echoPin, HIGH);

  // Menghitung jarak menggunakan kecepatan suara
  // Jarak = (durasi echo * kecepatan suara) / 2
  float distance = (duration * 0.0343) / 2;

  // Menampilkan hasil ke Serial Monitor
  Serial.print("Jarak: ");
  Serial.print(distance);
  Serial.println(" cm");

  delay(1000);  // Tunggu sejenak sebelum mengukur lagi
}

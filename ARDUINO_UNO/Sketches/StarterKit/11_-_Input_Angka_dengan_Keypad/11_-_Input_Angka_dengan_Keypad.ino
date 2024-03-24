#include <Keypad.h>

const byte BARIS = 4; //4 baris
const byte KOLOM = 4; //4 kolom

//tentukan posisi tiap tombol
char poosisiTombol[BARIS][KOLOM] = {
  {'1','2','3','A'},
  {'4','5','6','B'},
  {'7','8','9','C'},
  {'*','0','#','D'}
};
byte pinBaris[BARIS] = {13, 12, 11, 10}; //koneksi pin baris Keypad
byte pinKolom[KOLOM] = {9, 8, 7, 6}; //koneksi pin kolom Keypad

Keypad tombolKeypad = Keypad( makeKeymap(poosisiTombol), pinBaris, pinKolom, BARIS, KOLOM); 

void setup(){
  Serial.begin(9600);
}
  
void loop(){
  char tombol = tombolKeypad.getKey();
  
  if(tombol){
    Serial.println(tombol);
  }
}

int slide_1 = 2;
int slide_2 = 3;
int greenLED = 12;
int redLED = 11;

int slidestate_1 = 0;
int slidestate_2 = 0;
int waiting = 1;

int dt1 = 1000;

void setup()
{
    // put your setup code here, to run once:
    Serial.begin(9600);
    pinMode(slide_1, INPUT);
    pinMode(slide_2, INPUT);
    pinMode(greenLED, OUTPUT);
    pinMode(redLED, OUTPUT);
}

void loop()
{
    // put your main code here, to run repeatedly:
    slidestate_1 = digitalRead(slide_1);
    slidestate_2 = digitalRead(slide_2);

    if (slidestate_1 == HIGH & slidestate_2 == HIGH)
    {
        Serial.println("Product not availible");
        digitalWrite(redLED, HIGH);
        delay(dt1);
        digitalWrite(redLED, LOW);
        delay(dt1);
        waiting = 1;
    }
    if (slidestate_1 == HIGH & slidestate_2 == LOW)
    {
        Serial.println("Vending soda");
        digitalWrite(greenLED, HIGH);
        delay(dt1);
        digitalWrite(greenLED, LOW);
        delay(dt1);
        waiting = 1;
    }
    if (slidestate_2 == HIGH & slidestate_1 == LOW)
    {
        Serial.println("Vending water");
        digitalWrite(greenLED, HIGH);
        delay(dt1);
        digitalWrite(greenLED, LOW);
        delay(dt1);
        waiting = 1;
    }
    if (slidestate_2 == LOW & slidestate_1 == LOW)
    {
        if (waiting == 1)
        {
            Serial.println("Waiting...");
            waiting = 0;
        }
    }
}

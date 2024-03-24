# Mastering Arduino

At the heart of the Arduino is the microcontroller. A microcontroller is a standalone, single- chip integrated circuit that contains a CPU, read-only memory, random access memory and various I/O busses. Most Arduino boards use the Atmel 8-bit AVR microcontroller.
The Arduino UNO R3 uses the ATmega328 chip. This chip is an 8-bit RISC-based microcontroller that features 32 KB of flash memory with read-write capabilities, 1 Kbyte EEPROM, 2 Kbytes SRAM, 23-general purpose I/O lines and 32 general-purpose registers.

All the hardware and software that make up the Arduino platform are distributed as open source and licensed under the GNU Lesser General Public License (LGPL) or the GNU General Public License (GPL). This allows for the manufacture and distribution of Arduino boards by anyone and has led to numerous generic, lower cost, Arduino compatible boards.


## List of major components of the Arduino Uno

- DC supply Input: The DC supply input can be used with an AC-to-DC power adapter or a battery. The power source can be connected using a 2.1 mm center-positive plug. The Arduino Uno operates at 5 volts but can have a maximum input of 20 volts; however, it is recommended to not use more than 12V.
- Voltage Regulator: The Arduino uses a linear regulator to control the voltage going into the board.
- USB Port: The USB port can be used to power and program the board.
- RESET button: This button, when pressed, will reset the board.
- ICSP for USB: The in-circuit serial programming pins are used to flash the firmware on the USB interface chip.
- ICSP for ATmega328: The in-circuit serial programming pins are used to flash the firmware on the ATmega microcontroller.
- Digital and PWM connectors: These pins, labeled 0 to 13, can be used as either a digital input or output pins. The pins labeled with the tilde (~) can also be used for Pulse-Width Modulation (PWM) output.
- Analog In Connectors: The pins, labeled A0 to A5, can be used for analog input. These pins can be used to read the output from analog sensors.
- Power and External Reset: These pins in this header, provide ground and power for external devices and sensors from the Arduino. The Arduino can also be powered through these pins. There is also a reset pin that can be used to reset the
Arduino.
- ATmega328: The microcontroller for the Arduino Uno board.


## References

- [Fritzing](https://fritzing.org/learning/)
- []
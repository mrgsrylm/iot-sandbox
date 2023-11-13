#ifndef OneWire_Direct_GPIO_h
#define OneWire_Direct_GPIO_h

// This header should ONLY be included by OneWire.cpp. These defines are
// meant to be private, used within OneWire.cpp, but not exposed to Arduino
// sketches or other libraries which may include OneWire.h.

#include <stdint.h>

// Platform-specific I/O definitions

#if defined(__AVR__)
// For AVR architecture, use 8-bit unsigned integer type
#define PIN_TO_BASEREG(pin) (portInputRegister(digitalPinToPort(pin)))
#define PIN_TO_BITMASK(pin) (digitalPinToBitMask(pin))
#define IO_REG_TYPE uint8_t
#define IO_REG_BASE_ATTR asm("r30")
#define IO_REG_MASK_ATTR
#if defined(__AVR_ATmega4809__)
#define DIRECT_READ(base, mask) (((*(base)) & (mask)) ? 1 : 0)
#define DIRECT_MODE_INPUT(base, mask) ((*((base)-8)) &= ~(mask))
#define DIRECT_MODE_OUTPUT(base, mask) ((*((base)-8)) |= (mask))
#define DIRECT_WRITE_LOW(base, mask) ((*((base)-4)) &= ~(mask))
#define DIRECT_WRITE_HIGH(base, mask) ((*((base)-4)) |= (mask))
#else
#define DIRECT_READ(base, mask) (((*(base)) & (mask)) ? 1 : 0)
#define DIRECT_MODE_INPUT(base, mask) ((*((base) + 1)) &= ~(mask))
#define DIRECT_MODE_OUTPUT(base, mask) ((*((base) + 1)) |= (mask))
#define DIRECT_WRITE_LOW(base, mask) ((*((base) + 2)) &= ~(mask))
#define DIRECT_WRITE_HIGH(base, mask) ((*((base) + 2)) |= (mask))
#endif

#elif defined(__MK20DX128__) || defined(__MK20DX256__) || defined(__MK66FX1M0__) || defined(__MK64FX512__)
// For specific ARM architectures, use 8-bit unsigned integer type
#define PIN_TO_BASEREG(pin) (portOutputRegister(pin))
#define PIN_TO_BITMASK(pin) (1)
#define IO_REG_TYPE uint8_t
#define IO_REG_BASE_ATTR
#define IO_REG_MASK_ATTR __attribute__((unused))
#define DIRECT_READ(base, mask) (*((base) + 512))
#define DIRECT_MODE_INPUT(base, mask) (*((base) + 640) = 0)
#define DIRECT_MODE_OUTPUT(base, mask) (*((base) + 640) = 1)
#define DIRECT_WRITE_LOW(base, mask) (*((base) + 256) = 1)
#define DIRECT_WRITE_HIGH(base, mask) (*((base) + 128) = 1)

// (Other architectures follow, similar patterns)

#elif defined(ARDUINO_ARCH_STM32)
// For STM32 architecture, use 32-bit unsigned integer type
#define PIN_TO_BASEREG(pin) (0)
#define PIN_TO_BITMASK(pin) ((uint32_t)digitalPinToPinName(pin))
#define IO_REG_TYPE uint32_t
#define IO_REG_BASE_ATTR
#define IO_REG_MASK_ATTR
#define DIRECT_READ(base, pin) digitalReadFast((PinName)pin)
#define DIRECT_WRITE_LOW(base, pin) digitalWriteFast((PinName)pin, LOW)
#define DIRECT_WRITE_HIGH(base, pin) digitalWriteFast((PinName)pin, HIGH)
#define DIRECT_MODE_INPUT(base, pin) pin_function((PinName)pin, STM_PIN_DATA(STM_MODE_INPUT, GPIO_NOPULL, 0))
#define DIRECT_MODE_OUTPUT(base, pin) pin_function((PinName)pin, STM_PIN_DATA(STM_MODE_OUTPUT_PP, GPIO_NOPULL, 0))

// (Other architectures follow, similar patterns)

#elif defined(__SAMD21G18A__)
// For SAMD21G18A architecture, use 32-bit unsigned integer type
#define PIN_TO_BASEREG(pin) portModeRegister(digitalPinToPort(pin))
#define PIN_TO_BITMASK(pin) (digitalPinToBitMask(pin))
#define IO_REG_TYPE uint32_t
#define IO_REG_BASE_ATTR
#define IO_REG_MASK_ATTR
#define DIRECT_READ(base, mask) (((*((base) + 8)) & (mask)) ? 1 : 0)
#define DIRECT_MODE_INPUT(base, mask) ((*((base) + 1)) = (mask))
#define DIRECT_MODE_OUTPUT(base, mask) ((*((base) + 2)) = (mask))
#define DIRECT_WRITE_LOW(base, mask) ((*((base) + 5)) = (mask))
#define DIRECT_WRITE_HIGH(base, mask) ((*((base) + 6)) = (mask))

// (Other architectures follow, similar patterns)

#else
// Use unsigned integer type as a fallback
#define PIN_TO_BASEREG(pin) (0)
#define PIN_TO_BITMASK(pin) (pin)
#define IO_REG_TYPE unsigned int
#define IO_REG_BASE_ATTR
#define IO_REG_MASK_ATTR
#define DIRECT_READ(base, pin) digitalRead(pin)
#define DIRECT_WRITE_LOW(base, pin) digitalWrite(pin, LOW)
#define DIRECT_WRITE_HIGH(base, pin) digitalWrite(pin, HIGH)
#define DIRECT_MODE_INPUT(base, pin) pinMode(pin, INPUT)
#define DIRECT_MODE_OUTPUT(base, pin) pinMode(pin, OUTPUT)
#warning "OneWire. Fallback mode. Using API calls for pinMode, digitalRead, and digitalWrite. Operation of this library is not guaranteed on this architecture."

#endif

#endif
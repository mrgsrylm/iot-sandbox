#ifndef OneWire_Direct_RegType_h
#define OneWire_Direct_RegType_h

#include <stdint.h>

// Platform-specific I/O register type

#if defined(__AVR__)
// For AVR architecture, use 8-bit unsigned integer type
#define IO_REG_TYPE uint8_t

#elif defined(__MK20DX128__) || defined(__MK20DX256__) || defined(__MK66FX1M0__) || defined(__MK64FX512__)
// For specific ARM architectures, use 8-bit unsigned integer type
#define IO_REG_TYPE uint8_t

#elif defined(__IMXRT1052__) || defined(__IMXRT1062__)
// For IMXRT1052 and IMXRT1062 architectures, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(__MKL26Z64__)
// For MKL26Z64 architecture, use 8-bit unsigned integer type
#define IO_REG_TYPE uint8_t

#elif defined(__SAM3X8E__) || defined(__SAM3A8C__) || defined(__SAM3A4C__)
// For SAM3X8E, SAM3A8C, SAM3A4C architectures, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(__PIC32MX__)
// For PIC32MX architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(ARDUINO_ARCH_ESP8266)
// For ESP8266 architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(ARDUINO_ARCH_ESP32)
// For ESP32 architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t
#define IO_REG_MASK_ATTR

#elif defined(ARDUINO_ARCH_STM32)
// For STM32 architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(__SAMD21G18A__)
// For SAMD21G18A architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(__ASR6501__)
// For ASR6501 architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(RBL_NRF51822)
// For RBL_NRF51822 architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(__arc__) /* Arduino101/Genuino101 specifics */
// For ARC architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#elif defined(__riscv)
// For RISC-V architecture, use 32-bit unsigned integer type
#define IO_REG_TYPE uint32_t

#else
// Use unsigned integer type as a fallback
#define IO_REG_TYPE unsigned int

#endif
#endif

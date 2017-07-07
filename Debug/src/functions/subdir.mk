################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/functions/ansisop.c \
../src/functions/config.c \
../src/functions/instruction_cycle.c \
../src/functions/interruption.c \
../src/functions/log.c \
../src/functions/memory.c \
../src/functions/pcb.c \
../src/functions/primitivas.c \
../src/functions/serialization.c \
../src/functions/stack.c 

OBJS += \
./src/functions/ansisop.o \
./src/functions/config.o \
./src/functions/instruction_cycle.o \
./src/functions/interruption.o \
./src/functions/log.o \
./src/functions/memory.o \
./src/functions/pcb.o \
./src/functions/primitivas.o \
./src/functions/serialization.o \
./src/functions/stack.o 

C_DEPS += \
./src/functions/ansisop.d \
./src/functions/config.d \
./src/functions/instruction_cycle.d \
./src/functions/interruption.d \
./src/functions/log.d \
./src/functions/memory.d \
./src/functions/pcb.d \
./src/functions/primitivas.d \
./src/functions/serialization.d \
./src/functions/stack.d 


# Each subdirectory must supply rules for building sources it contributes
src/functions/%.o: ../src/functions/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '



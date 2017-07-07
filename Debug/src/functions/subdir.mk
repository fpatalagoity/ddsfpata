################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/functions/cache.c \
../src/functions/config.c \
../src/functions/frame.c \
../src/functions/hash_function.c \
../src/functions/log.c \
../src/functions/memory.c \
../src/functions/ram.c \
../src/functions/utils.c 

OBJS += \
./src/functions/cache.o \
./src/functions/config.o \
./src/functions/frame.o \
./src/functions/hash_function.o \
./src/functions/log.o \
./src/functions/memory.o \
./src/functions/ram.o \
./src/functions/utils.o 

C_DEPS += \
./src/functions/cache.d \
./src/functions/config.d \
./src/functions/frame.d \
./src/functions/hash_function.d \
./src/functions/log.d \
./src/functions/memory.d \
./src/functions/ram.d \
./src/functions/utils.d 


# Each subdirectory must supply rules for building sources it contributes
src/functions/%.o: ../src/functions/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '



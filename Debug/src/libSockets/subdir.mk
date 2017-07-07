################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/libSockets/client.c \
../src/libSockets/recv.c \
../src/libSockets/send.c \
../src/libSockets/server.c 

OBJS += \
./src/libSockets/client.o \
./src/libSockets/recv.o \
./src/libSockets/send.o \
./src/libSockets/server.o 

C_DEPS += \
./src/libSockets/client.d \
./src/libSockets/recv.d \
./src/libSockets/send.d \
./src/libSockets/server.d 


# Each subdirectory must supply rules for building sources it contributes
src/libSockets/%.o: ../src/libSockets/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '



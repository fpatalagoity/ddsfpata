################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/threads/handlers.c \
../src/threads/request.c \
../src/threads/select.c 

OBJS += \
./src/threads/handlers.o \
./src/threads/request.o \
./src/threads/select.o 

C_DEPS += \
./src/threads/handlers.d \
./src/threads/request.d \
./src/threads/select.d 


# Each subdirectory must supply rules for building sources it contributes
src/threads/%.o: ../src/threads/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '



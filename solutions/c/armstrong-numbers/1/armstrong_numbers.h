#ifndef ARMSTRONG_NUMBERS_H
#define ARMSTRONG_NUMBERS_H

#include <stdbool.h>
#include <stdio.h>
#include <math.h>

bool is_armstrong_number(int candidate);
void set_digits(int candidate, int digits[], int digitsCount);
int sum_digits(int acc, int i, int digits[]);

#endif

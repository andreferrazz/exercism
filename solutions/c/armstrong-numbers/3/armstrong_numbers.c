#include "armstrong_numbers.h"
#include <math.h>

bool is_armstrong_number(int candidate) {
    int number = candidate;
    int digit_count = log10(candidate) + 1;
    int result = 0;

    while (number > 0) {
        int digit = number % 10;
        int digit_raised_by_digit_count = 1;
        for (int i = 0; i < digit_count; i++) {
            digit_raised_by_digit_count *= digit;
        }
        result += digit_raised_by_digit_count;
        number /= 10;
    }

    return result == candidate;
}

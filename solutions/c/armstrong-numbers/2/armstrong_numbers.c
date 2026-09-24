#include "armstrong_numbers.h"
#include <math.h>

bool is_armstrong_number(int candidate) {
    if (candidate < 10) {
        return true;
    }

    int digit_count = log10(candidate) + 1;

    int num = candidate;
    int result = 0;
    while (num > 0) {
        int digit = num % 10;
        int partial_result = 1;
        for (int i = 0; i < digit_count; i++)
            partial_result *= digit;
        result += partial_result;
        num /= 10;
    }
    return candidate == result;
}

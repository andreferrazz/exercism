#include "armstrong_numbers.h"

bool is_armstrong_number(int candidate)
{
	int digits[8] = {0, 0, 0, 0, 0, 0, 0, 0};
	set_digits(candidate, digits, 0);
	int result = sum_digits(0, 1, digits);
	printf("Candidate %d\n", candidate);
	printf("Result %d\n", result);
	return result == candidate;
}

void set_digits(int candidate, int digits[], int digitsCount)
{
	int digit = candidate % 10;
	digitsCount++;
	digits[digitsCount] = digit;
	digits[0] = digitsCount;

	if (candidate < 10) return;

	set_digits(candidate / 10, digits, digitsCount);
}


int sum_digits(int acc, int i, int digits[])
{
	if (i > digits[0]) {
		return acc;
	}

	acc += pow(digits[i], digits[0]);

	return sum_digits(acc, ++i, digits);
}
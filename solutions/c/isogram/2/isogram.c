#include "isogram.h"
#include <stdio.h>

bool is_alpha(int c);
int to_lower(int c);

bool is_isogram(const char *phrase) {
    if (phrase == NULL) {
        return false;
    }

    for (int i = 0; phrase[i] != '\0'; i++) {
        if (!is_alpha(phrase[i])) {
            continue;
        }
        for (int j = i - 1; j >= 0; j--) {
            if (!is_alpha(phrase[j])) {
                continue;
            }
            if (to_lower(phrase[i]) == to_lower(phrase[j])) {
                return false;
            }
        }
    }
    return true;
}

bool is_alpha(int c) { return (c >= 65 && c <= 90) || (c >= 97 && c <= 122); }

int to_lower(int c) {
    if (c >= 65 && c <= 90) {
        return c + 32;
    }
    return c;
}

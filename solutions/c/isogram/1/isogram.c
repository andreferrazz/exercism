#include "isogram.h"
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>

bool is_isogram(const char *phrase) {
    if (phrase == NULL) {
        return false;
    }

    for (int i = 0; phrase[i] != '\0'; i++) {
        if (!isalpha(phrase[i])) {
            continue;
        }
        for (int j = i - 1; j >= 0; j--) {
            if (!isalpha(phrase[j])) {
                continue;
            }
            if (tolower(phrase[i]) == tolower(phrase[j])) {
                return false;
            }
        }
    }
    return true;
}

#include "isogram.h"

bool is_isogram(const char *phrase) {
    if (!phrase)
        return false;

    int letter_flags = 0;
    char sub = 'a';

    while (*phrase) {
        char letter = *phrase;
        if (letter >= 'a' && letter <= 'z')
            sub = 'a';
        else if (letter >= 'A' && letter <= 'Z')
            sub = 'A';
        else
            sub = 'X';

        if (sub != 'X') {
            int letter_offset = 1 << (letter - sub);

            if ((letter_flags & letter_offset) != 0) {
                return false;
            }
            letter_flags |= letter_offset;
        }
        phrase++;
    }
    return true;
}

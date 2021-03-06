#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the repeatedString function below.
def repeatedString(s, n):
    residual_char = n % len(s)
    repeated_word = n // len(s)
    count = s.count('a')
    residual_count = s[:residual_char].count('a')
    return count * repeated_word + residual_count

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    n = int(input())

    result = repeatedString(s, n)

    fptr.write(str(result) + '\n')

    fptr.close()

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the jumpingOnClouds function below.
def jumpingOnClouds(n,c):
    i = 0
    jump = 0
    while i < n-1:
        if i+2 < n and c[i+2] == 0:
            jump += 1
            i += 2
        else:
            jump += 1
            i += 1
    return jump

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(n,c)

    fptr.write(str(result) + '\n')

    fptr.close()

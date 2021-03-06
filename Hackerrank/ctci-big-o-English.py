#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the primality function below.
def primality(n):
    if n == 2:
        return "Prime"
    if n == 1 or n % 2 == 0:
        return "Not prime"
    for i in range(3,int(math.sqrt(n))+2,2):
        if n % i == 0:
            return "Not prime"
    return "Prime"
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    p = int(input())

    for p_itr in range(p):
        n = int(input())

        result = primality(n)

        fptr.write(result + '\n')

    fptr.close()

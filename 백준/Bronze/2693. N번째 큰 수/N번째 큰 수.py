import sys

input = sys.stdin.readline
n = int(input())

for i in range(n):
    array = list(map(int, input().split()))
    array.sort(reverse = True)
    print(array[2])
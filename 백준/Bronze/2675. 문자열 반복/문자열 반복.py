a = int(input())
for i in range(a):
    b, c = input().split()
    c = list(c)
    b = int(b)
    for j in range(len(c)):
        for m in range(b):
            print(c[j],end = '')
    print('')

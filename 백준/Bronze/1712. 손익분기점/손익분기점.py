a,b,c = map(int,input().split())
breakevenpoint = 0
if (c <= b):
    print("-1")
else:
    breakevenpoint = a//(c-b) + 1
    print(breakevenpoint)

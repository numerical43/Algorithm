x = int(input())
n = int(input())
total = 0
    
for i in range(n):
  price, count = map(int, input().split())
  total += (price * count)

if x == total:
  print("Yes")
else:
  print("No")
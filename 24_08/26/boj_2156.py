import sys

N = int(sys.stdin.readline())
amounts = [int(sys.stdin.readline()) for _ in range(N)]

max_amounts = [[amounts[i], amounts[i]] for i in range(N)]

answer = 0
for i in range(N):
  # 점프 X
  if i-1 >= 0:
    max_amounts[i][1] += max_amounts[i-1][0]
  # 점프 O
  prev_pool = [0]
  if i-2 >= 0:
    prev_pool.append(max(max_amounts[i-2]))
  if i-3 >= 0: 
    prev_pool.append(max(max_amounts[i-3]))

  max_amounts[i][0] += max(prev_pool)
  answer = max(max(max_amounts[i]), answer)

print(answer)
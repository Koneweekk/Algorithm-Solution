N, K = map(int, input().split())

num_arr = [i + 1 for i in range(N)]

idx = -1
remain = N

answer = []
for _ in range(N):
  idx = (idx + K) % remain
  answer.append(num_arr.pop(idx))
  remain -= 1
  idx -= 1

print('<' + ', '.join(map(str, answer)) + '>')

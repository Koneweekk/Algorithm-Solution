K = int(input())

for _ in range(K):
  # 입력값 할당
  N, M = map(int, input().split())
  queue = list(map(int, input().split()))

  # 중요도별 배열 묶음 생성
  num_idx_arr = [[] for _ in range(0, 10)]
  for i in range(N):
    num_idx_arr[queue[i]].append(i)

  # 정답 도출
  current_idx = 0
  count = 0
  answer = -1
  for arr in num_idx_arr[::-1]:
    start_point = 0
    now_count = len(arr)
    # 현재 중요도에서 시작지점 찾기
    for i in range(now_count):
      if arr[i] >= current_idx:
        start_point = i
        break
    
    # 현재 중요도 탐색
    start_point -= 1
    for i in range(now_count):
      start_point = (start_point + 1) % now_count
      current_idx = arr[start_point]
      count += 1
      if arr[start_point] == M:
        answer = count
        break
      
    if answer > 0:
      break

  print(answer)

def solution(strs, t):
    # 활용할 변수 정리
    N = len(t)
    str_set = set(strs)
    min_counts = [20001 for _ in range(N)]
    
    # dp를 통해 최소 개수 연산
    for i in range(N):
        for j in range(i, min(N, i+5)):
            if (not t[i:j+1] in str_set): continue
            min_counts[j] = 1 if i == 0 else min(min_counts[j], min_counts[i-1] + 1)

    return -1 if min_counts[N-1] == 20001 else min_counts[N-1]  
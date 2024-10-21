def solution(k, tangerine):
    # 1. 귤 크기별 개수 정리
    sizeCount = dict()
    for t in tangerine:
        if not sizeCount.get(t): sizeCount[t] = 1
        else: sizeCount[t] += 1
    
    # 2. 귤 개수 내림차순으로 정렬
    sortedCount = sorted(sizeCount.values(), reverse=True)
    
    # 3. 개수가 많은 것부터 연산
    count = 0
    for c in sortedCount:
        k -= c
        count += 1
        if (k <= 0): break
        
    return count
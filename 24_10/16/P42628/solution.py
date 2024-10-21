import heapq

def solution(operations):
    # 1. 활용할 변수 선언
    max_heap = []  # 최대 힙
    min_heap = []  # 최소 힙
    numbers = {}  # 저장된 변수
    count = 0
    
    # 2. 연산 진행
    for o in operations:
        # 2.1 명령어 변수에 할당
        o = o.split(" ")
        n = int(o[1])

        # 2.3 삽입 명령
        if (o[0] == "I"):
            # numbers에 숫자 삽입
            if (n in numbers): numbers[n] += 1
            else: numbers[n] = 1
            # 총 개수 증가
            count += 1
            # 힙에 숫자 추가
            heapq.heappush(min_heap, n)
            heapq.heappush(max_heap, -n)

        # 2.4 삭제 명령
        if (o[0] == "D"):
            # count 확인
            if (not count): continue
            # 최대값 제거
            if (n == 1):
                next = -heapq.heappop(max_heap)
                while (not numbers.get(next)):
                    next = -heapq.heappop(max_heap)
                numbers[next] -= 1
            # 최솟값 제거
            if (n == -1):
                next = heapq.heappop(min_heap)
                while (not numbers.get(next)):
                    next = heapq.heappop(min_heap)
                numbers[next] -= 1
            # 총개수 감소
            count -= 1
            # 2.2 비어있는 힙 정리
            if (not count):
                max_heap = []
                min_heap = []

    # 3. 덜 제거된 숫자를 모두 제거 후 최대값 최소값 출력
    if (not count):
        return [0, 0]
    else:
        while (not numbers.get(-max_heap[0])):
            heapq.heappop(max_heap)
        while (not numbers.get(min_heap[0])):
            heapq.heappop(min_heap)

        return [-max_heap[0], min_heap[0]]


print(solution(["I 5", "I 4", "I 3", "I 2", "I 1", "D -1", "D -1", "D -1", "I 1", "D 1", "D 1"]))
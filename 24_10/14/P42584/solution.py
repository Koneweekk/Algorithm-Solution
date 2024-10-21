from collections import deque

def solution(prices):
    # 활용할 변수 준비
    N = len(prices)  # 초단위 주식 길이
    stack = deque()  # 연산을 위한 스택
    answer  = [0 for _ in range(N)]  # 정답을 담을 
    
    # 주식가격을 순회하며 넣고 빼기
    idx = 0
    while idx < N:
        if (not stack or stack[-1][0] <= prices[idx]):
            stack.append([prices[idx], idx])
            idx += 1
        else:
            sell = stack.pop()
            answer[sell[1]] = idx - sell[1]
            
    # 남아있는 주식 정리
    idx -= 1
    while stack:
        sell = stack.pop()
        answer[sell[1]] = idx - sell[1]
            
            
    return answer
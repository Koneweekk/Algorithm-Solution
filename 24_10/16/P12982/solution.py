def solution(d, budget):
    d.sort()
    
    answer = 0
    for cost in d:
        if (budget < cost): break
        answer += 1
        budget -= cost
    
    return answer
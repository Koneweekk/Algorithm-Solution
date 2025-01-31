def solution(people, limit):
    people.sort()
    l, r = 0, len(people) - 1
    
    cnt = 0
    while (l <= r):
        if (people[l] <= limit - people[r]): 
            l += 1
        r -= 1
        cnt += 1

    return cnt
function solution(d, budget) {
    // 1. 가격 정렬
    d.sort((a,b) => a - b);
    
    // 2. 최소 가격부터 탐색
    let answer = 0;
    for (const cost of d) {
        if (budget < cost) break;
        budget -= cost;
        answer++;
    }

    return answer;
}
function solution(people, limit) {
    // 사람 몸무게 정렬     
    people.sort((a,b) => a - b);
    // 가벼운쪽, 무거운쪽 인덱스
    let left = 0, right = people.length - 1;
    
    // 무거운쪽부터 태우고 남은 무게가 있으면 가벼운쪽 태우기
    let count = 0
    while (left <= right) {
        const remain = limit - people[right--];
        if (people[left] <= remain) left++
        count++
    }

    return count;
}
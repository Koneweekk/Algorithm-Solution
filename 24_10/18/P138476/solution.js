function solution(k, tangerine) {
    // 1. 귤 개수 구하기 
    tangObject = {}
    for (const t of tangerine) {
        if (!tangObject[t]) {
            tangObject[t] = 1
        } else {
            tangObject[t]++
        }
    }
    
    // 2. 귤 개수 내림차순으로 정렬
    tangNumbers = Object.values(tangObject)
    tangNumbers.sort((a,b) => {
        return b - a
    })
    
    // 3. k가 0이하가 될 때까지 연산
    let count = 0;
    for (const n of tangNumbers) {
        k -= n
        count++;
        if (k <= 0) break;
    }
    
    return count;
}
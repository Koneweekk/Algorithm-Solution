function solution(strs, t) {
    // 활용할 변수 정리     
    const N = t.length;
    const strSet = new Set(strs);
    
    // dp를 통해 최소 단어 개수 반환
    const minCounts = new Array(N).fill(20001);
    for (let i = 0; i < N; i++) {
        const maxIdx = Math.min(N, i+5);
        for (let j = i; j < maxIdx; j++) {
            if (!strSet.has(t.slice(i, j+1))) continue;
            minCounts[j] = i === 0 ? 1 : Math.min(minCounts[i-1] + 1, minCounts[j]);
        }
    }

    return minCounts[N-1] === 20001 ? -1 : minCounts[N-1];
}
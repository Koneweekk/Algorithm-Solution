function solution(dirs) {
    // 1. 방문 표시할 배열 선언
    const vVisited = new Array(10).fill().map(() => new Array(11).fill(false));
    const hVisited = new Array(11).fill().map(() => new Array(10).fill(false));
    
    // 2. 활용할 변수 선언
    let r = c = 0;  // 현재 행과 열
    let count = 0;  // 새로 지나온 길 개수
    const dirMap = {"U" : [1, 0], "D" : [-1, 0], "R": [0, 1], "L":[0, -1]};  // 방향 좌표 매핑
    
    for (let d of dirs) {
        // 유효한 좌표인지 확인
        const nr = r + dirMap[d][0];
        const nc = c + dirMap[d][1];
        if (nr < -5 || nr > 5 || nc < -5 || nc > 5) continue;
        // 방문 표시
        if (d === "U" && !vVisited[r + 5][c + 5]) {
            vVisited[r + 5][c + 5] = true;
            count++;
        } else if (d === "D" && !vVisited[r + 4][c + 5]) {
            vVisited[r + 4][c + 5] = true;
            count++;
        } else if (d === "R" && !hVisited[r + 5][c + 5]) {
            hVisited[r + 5][c + 5] = true;
            count++;
        } else if (d === "L" && !hVisited[r + 5][c + 4]) {
            hVisited[r + 5][c + 4] = true;
            count++;
        } 
        
        // 좌표 이동
        r = nr, c = nc;
    }

    return count;
}
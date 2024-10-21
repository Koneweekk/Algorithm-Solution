function solution(msg) {
    // 단어 길이
    const N = msg.length;
    
    // 사전 선언
    const dict = {};
    for (let i = 1; i <= 26; i++) {
        dict[String.fromCharCode(i + 64)] = i;
    }
    
    // 압축 진행
    let idx = 0;
    let dictNum = 27;
    const answer = [];
    while (idx < N) {
        let end = idx + 2;
        while (end <= N && dict[msg.slice(idx, end)]) {
            end++;
        }
        if (end <= N) {
            dict[msg.slice(idx, end)] = dictNum++;
        }
        answer.push(dict[msg.slice(idx, --end)]);
        idx = end;
    }

    
    return answer;
}
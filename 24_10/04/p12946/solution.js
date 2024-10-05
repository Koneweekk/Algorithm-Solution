const answer = [];

function solution(n) {
  hanoi(1, 2, 3, n);
  
  return answer;
}

function hanoi(s, m, e, h) {
  if (h === 0) return;

  hanoi(s, e, m, h-1);
  answer.push([s,e]);
  hanoi(m, s, e, h-1);
}

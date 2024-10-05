function solution(n) {
  if (n === 1) {
    return 1;
  } 
  
  return n % 2 === 1 ? solution(parseInt(n/2)) + 1 : solution(parseInt(n/2))
}
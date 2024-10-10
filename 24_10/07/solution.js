function solution(n) {
  const memo = new Array(n);
  memo[0] = 1;
  memo[1] = 2;

  for (let i = 2; i < n; i++) {
    memo[i] = (memo[i-1] + memo[i-2]) % 1000000007
  }

  return memo[n-1];
}


console.log(solution(5));
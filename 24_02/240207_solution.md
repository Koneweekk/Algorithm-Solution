# 240207 문제풀이

## queuestack (백준)

카테고리 : 자료 구조, 큐, 스텍, 덱

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 입력값 변수에 할당
const N = Number(input[0].trim());
const M = Number(input[3].trim());
const queueStack = input[1].split(" ").map(v => Number(v.trim()));
const arr1 = input[2].split(" ").map(v => Number(v.trim()));
const arr2 = input[4].split(" ").map(v => Number(v.trim()));

// 큐에 들어간 자료들만 추려내기
let queue = [];
for (let i = N-1; i >= 0; i--) {
  if (!queueStack[i]) queue.push(arr1[i]);
}

// 큐에 추가 자료 삽입하기
queue.push(...arr2)

// M개의 개수 만큼 뽑아내서 출력
console.log(queue.slice(0, M).join(" "))
```

[문제 링크](https://www.acmicpc.net/problem/24511)

<hr><br>

## 풍선 터뜨리기 (백준)

카테고리 : 자료 구조, 덱

풀이코드
```python
N = int(input())
balloons = [(i+1, v) for i, v in enumerate(map(int, input().split()))]

now_loc = 0
result = ["1"]
while N > 1:
  N -= 1
  target = balloons.pop(now_loc)
  move = target[1] - 1 if target[1] > 0 else target[1]
  next_loc = ( now_loc + move + N * N ) % N
  result.append(str(balloons[next_loc][0]))
  now_loc = next_loc

print(" ".join(result))
```

[문제 링크](https://www.acmicpc.net/problem/2346)
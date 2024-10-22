def solution(dirs):
    # 방문 표시를 위한 set
    visited = set()
    # 방향과 좌표 매핑
    dir_map = {"U": [1, 0], "D": [-1, 0], "R": [0, 1], "L": [0, -1]}
    
    # 좌표 순회
    answer = 0
    r, c = 0, 0
    for d in dirs:
        # 유효한 좌표인지 확인
        nr, nc = r + dir_map[d][0], c + dir_map[d][1]
        if (nr < -5 or nr > 5 or nc < -5 or nc > 5): 
            continue
        # 방문한 선분인지 확인
        line1 = (r, c, nr, nc)
        line2 = (nr, nc, r, c)
        if (line1 not in visited and line2 not in visited): 
            visited.add(line1)
            visited.add(line2)
            answer += 1
        # 좌표 갱신
        r, c = nr, nc
        
    return answer
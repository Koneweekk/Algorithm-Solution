import string

def solution(msg):
    # 글자수
    N = len(msg)
    # 사전 선언
    msg_dict = {string.ascii_uppercase[i] : i + 1 for i in range(26)}
    
    # 글자 압축
    idx = 0
    dict_num = 27
    answer = []
    while (idx < N):
        end = idx + 2
        while (end <= N and msg[idx:end] in msg_dict): end += 1
        if (end <= N): msg_dict[msg[idx:end]] = dict_num
        
        end -= 1
        answer.append(msg_dict.get(msg[idx:end]))
        
        dict_num += 1
        idx = end
    
    return answer
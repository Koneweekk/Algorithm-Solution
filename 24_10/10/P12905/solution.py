import string

def solution(s):

    if (not s): return s
    if (s[0] in string.ascii_lowercase): return s[0] + solution(s[1:])

    brackets = [0, 0]
    start, end = 0, 0
    for i in range(len(s)):
        if (s[i] == "("):
            if not brackets[0]: start = i + 1
            brackets[0] += 1
        elif (s[i] == ")"):
            brackets[1] += 1
            if brackets[0] == brackets[1]:
                end = i
                break

    if (s[0] == "S"):
        return "".join(sorted(s[start:end])) + s[end + 1:]
    
    if (s[2] == "P"):
        temp = s[start:end].split(",")
        return solution(temp[0]) * int(temp[1]) + s[end + 1:]
    
    if (s[2] == "V"):
        return solution(s[start:end])[::-1] + s[end + 1:]

print(solution("REPEAT(dREVERSE(SORT(ccccbac)),2)a"))

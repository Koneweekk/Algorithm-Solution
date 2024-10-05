import java.util.*;

public class Solution {
    public int solution(int[] topping) {
        // 1. 사용할 변수 정리
        // 1.1 잘랐을 때 좌측 우측 토핑 가짓수 배열
        int[] typeCount = new int[topping.length];
        // 1.2 토핑 종류를 담을 set
        
        // 2 topping을 순회하며 토핑 가짓수 세기
        // 2.1 좌측부터 세기
        Set<Integer> typeSet = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            typeSet.add(topping[i]);
            typeCount[i] = typeSet.size();
        }
        // 2.2 우측부터 세면서 좌측과 비교
        int count = 0;
        typeSet = new HashSet<>();
        for (int i = topping.length - 1; i > 0; i--) {
            typeSet.add(topping[i]);
            if (typeSet.size() == typeCount[i-1]) {
                count++;
            }
        }
        
        return count;
    }
}
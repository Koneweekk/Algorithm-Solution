import java.util.*;

public class Solution {
    public int solution(int n) {
        if (n == 1) {
            return 1;
        } else if (n % 2 == 1) {
            return solution(n/2) + 1;
        } else {
            return solution(n/2);
        }
    }
}
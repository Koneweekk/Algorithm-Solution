import java.io.*;
import java.util.*;

public class Main {
    // 입출력 관련 필드
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 공용 필드
    int N;

    // 주요 실행함수
    void run() throws IOException {
        // 입력값 할당
        N = Integer.parseInt(br.readLine());

        // 해쉬맵에 순서와 차량번호 저장
        String[] idList = new String[N];
        HashMap<String, Integer> idMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String carId = br.readLine();
            idList[i] = carId;
            idMap.put(carId, i);
        }

        // 들어온 차량 순서를 보며 추월 차량 분별
        int nowOrder = 0;  // 현재 차량 순서
        int count = 0; // 과속 차량 대수
        while (nowOrder < N) {
            // 이 순서에 있어야할 차량이 이미 과속한 상태
            if (idList[nowOrder] == "") {
                nowOrder++;
                continue;
            }
            String carId = br.readLine();
            // 현재 들어온 차량이 이전 순서와 맞지 않는 경우
            if (!idList[nowOrder].equals(carId)) {
                count++;
                idList[idMap.get(carId)] = "";
            } else {
                nowOrder += 1;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }
}
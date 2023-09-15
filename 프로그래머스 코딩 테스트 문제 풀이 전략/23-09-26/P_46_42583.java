package PGS_BOOK.CH11.CH11_01;

import java.util.LinkedList;
import java.util.Queue;

// 다리건너는거로 넣고 검사하기근데 2초걸리는건 어케?
// time 하나씩 올리고 queue에 0으로 자리메꾸면서 돌아감
// 최근 코테에서 만난 문제랑 비슷해서 쫄았음,,
public class P_46_42583 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i<bridge_length; i++){
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;

        while (truckIndex < truck_weights.length){
            bridgeWeight -= bridge.poll();
            int truckWeight = truck_weights[truckIndex];
            if (bridgeWeight + truckWeight <= weight){
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            }else{
                bridge.add(0);
            }
            time++;
        }

        while(bridgeWeight > 0){
            bridgeWeight -= bridge.poll();
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        int[] int_list = {7,4,5,6};
        System.out.println(solution(2,10,int_list));
    }
}

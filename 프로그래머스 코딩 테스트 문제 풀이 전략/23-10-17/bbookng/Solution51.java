package Programmers;

import java.util.*;

public class Solution51 {

    // 작업(Job) 객체를 정의합니다.
    // 각 작업은 시작 시간(start)과 작업 소요 시간(duration)을 가지고 있습니다.
    // 이를 사용하여 작업을 나타냅니다.

    public static int solution(int[][] jobs) {
        int answer = 0;

        int request = -1;
        int now = 0;
        int cnt = 0;

        // 작업을 관리하기 위한 우선순위 큐(PriorityQueue)를 생성합니다.
        // 작업 소요 시간(duration)이 짧은 순서대로 정렬되도록 Comparator를 사용합니다.
        PriorityQueue<Job> controller = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return job1.duration - job2.duration;
            }
        });

        // 입력으로 주어진 jobs 배열을 Job 객체로 변환하여 리스트에 저장합니다.
        List<Job> jobList = new ArrayList<>();
        for (int[] job : jobs) {
            jobList.add(new Job(job[0], job[1]));
        }

        // 모든 작업을 처리할 때까지 반복합니다.
        while (cnt != jobs.length) {
            // 현재 시간(now)에서 요청 시간(request)보다 빠르고 현재 시간 이후에 시작하는 작업을 큐에 추가합니다.
            for (Job job : jobList) {
                if (request < job.start && job.start <= now) {
                    controller.offer(job);
                }
            }

            // 큐에서 작업을 꺼내서 처리합니다.
            if (!controller.isEmpty()) {
                Job job = controller.poll();
                request = now;
                now += job.duration;
                answer += now - job.start;
                cnt++;
            } else {
                now++;
            }
        }

        // 평균 대기 시간을 계산하여 반환합니다.
        return answer / jobs.length;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int result = solution(jobs);
        System.out.println(result);  // 출력 결과: 9
    }
}

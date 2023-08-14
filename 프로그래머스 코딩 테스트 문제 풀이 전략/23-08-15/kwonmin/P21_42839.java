// 순열
// 같은 숫자가 나와서는 안 됨
// Set으로 조합된 것 관리
// 필요한 함수 : 2개
// 조합 -> 숫자 만들어내는 함수
// 만들어낸 숫자 -> 소수 판별하는 함수


import java.util.HashSet;
import java.util.Set;


public class PrimeSearch {
	
	private boolean isPrime(int x){

		if (x <= 1) return false;   // 이거 안해서 한번 틀림. 0과 1은 소수가 아니다...

		for (int i = 2; i * i <= x; i++) { // 범위 설정. python에서는 math함수로 제곱근을 구해야 효율적인 작성이 가능했는데, 자바는 for문이 달라서 좀 더 편하게 설정 가능한듯
			if (x % i == 0) return false;
		}

		return true;
	}

	private void getPrime(int num, int[] nums, boolean[] visited, Set<Integer> primes){ // 파라미터. num * 10의 형식으로 하고 있는데, 앞이 0이 오는 경우를 생각하면 이게 현명할듯.
		if(isPrime(num)) primes.add(num); // 재귀하기 때문에, 시작부분에 판별

		for (int i = 0; i < nums.length; i++) { // 돌긴 돌아야하는데... 다 돌았는데도 불필요하게 한번 더 도는 거 좀 마음에 안듦. 일일히 길이 확인하는것도 애매할듯;
			if (visited[i]) continue; // 방문처리했으면 넘어가기
			int nextNum = num * 10 + nums[i]; // 자릿수 늘려주고 앞에 추가

			visited[i] = true;
			getPrime(nextNum, nums, visited, primes);
			visited[i] = false;
		}

	}
	

	public int solution(String numbers) {
		Set<Integer> primes = new HashSet<>();
		int[] num_array = numbers.chars().map(c -> c - '0').toArray(); // 이 부분이 아직 좀 낯설다. map 관련은 자바나 자스나 비슷한데, 잘 안익혀지는듯
		getPrime(0, num_array, new boolean[num_array.length], primes);
		return primes.size();
	}
}

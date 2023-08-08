class 카펫 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		for(int i=1; i<= yellow+1; i++){
			if(yellow % i == 0){
				int a = yellow / i;
				if((a+2)*(i+2) == (brown+yellow)){
					answer[0] = Math.max((a+2),(i+2));
					answer[1] = Math.min((a+2),(i+2));
					break;
				}
			}
		}
		return answer;
	}
}
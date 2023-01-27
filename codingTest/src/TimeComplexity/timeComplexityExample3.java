package TimeComplexity;

public class timeComplexityExample3 {

	public static void main(String[] args	) {

		// 시간복잡도_판별 원리2
		/* 연산 횟수가 3N인 경우*/		
		int N = 100000;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			System.out.println("연산 횟수:" + cnt++);
		}
		for(int i = 0; i  < N; i++) {
			System.out.println("연산 횟수:" + cnt++);
		}
		for(int i = 0; i< N; i++) {
			System.out.println("연산 횟수:" + cnt++);
		}
	}
}

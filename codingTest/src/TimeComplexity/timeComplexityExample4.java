package TimeComplexity;

public class timeComplexityExample4 {

	public static void main(String[] args	) {

		// 시간복잡도_판별 원리3
		// 연산 횟수가 N제곱인 경우
		int N = 100000;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.println("연산 횟수:" + cnt++);
			}
		}
	}
}

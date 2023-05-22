package grammarBasic;

public class Main {

	
	public static void main(String[] args) {

		// Random 클래스
//		Random r = new Random();
//		int rand = r.nextInt(4) + 5;

		// 0 ~ 4 -> 5~ 9
		// 5 ~ 9
		
		// if문과 삼항연산자
		boolean a2 = true;
		
		String str3;
		
		str3 = a2? "참이다" : "거짓이다";
		
		if(a2) {
			str3 ="참이다";
		} else {
			str3="거짓이다";
		}
		System.out.println(str3);
		
		
		
		//정수
		int x = 20;
		long l = 20L;
		short s = 30;
		byte b = 20;

		int i = (int)20L;	//형변환
		long ll = 30; //int
		
		//실수
		double dd = 20.0;
		float ff = 10.0f;		
		dd = ff;
		ff = (float)dd; 	//큰거를 변환 할때는 강제로 형변환 해야한다
		x = 30;
		System.out.println(x);
		
		//final int y = 30; 이거는 변화를 하지 않게 하는것


		
		//참 거짓
		boolean isMarried = true;
		isMarried = false;
		
		//문자열 ( char는 잘 안쓰고 주로 String 사용)
		char c = '0';
		char c1 = 'd';
		String str = "여러 글자"; 
		
		System.out.printf("저는 %s입니다. 나이는 %d이고, 키는 %fcm 입니다. \n", "홍길동", 20, 150.0f);
		
		String str2 = String.format("저는 %s입니다. 나이는 %d이고, 키는 %fcm 입니다. \n", "홍길동", 20, 150.0f);
		
		System.out.println(str2);
		
		
		//수학적 관련 Math활용
		System.out.println(Math.max(10, 30)); //큰값찾기
		System.out.println(Math.min(10, 23));//작은값찾기
		System.out.println(Math.abs(-30)); //절대값 만들어 주기
		
		//String, int 서로 변환
		String st1 = "100";
		int i2 = Integer.parseInt(st1);
		long l2 = Long.parseLong(st1);
		
		String st2 = String.valueOf(i2);
		
		System.out.println(i2);
		System.out.println(st2);
		
		// 반복문
//		for(int j = 0; j < 10; j++) {
//			System.out.println(j);
//		}
//		
//		int j = 0;
//		while(j < 10) {
//			System.out.println(j);
//			j++;
//		}
		
		// 배열 과 리스트
		int[] array = new int[] {10, 20, 30, 40};	//중가로 안에 넣을려면 []이 비어 있어야함 아니면  new int[]생략가능.
		int count = array.length; //배열의 길이
		
		String[] names = new String[2];
		
		//ArrayList<Integer> scoreList = new ArrayList<>();
//		socreList.add(10);
//		scoreList.add(20);
//		scoreList.add(30);
//		
//		System.out.println(scoreList.get(2));
		
		

		 
		
		
		
		
		
				
	}

}

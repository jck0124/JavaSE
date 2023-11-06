package section05;
/*
 * 2. do ~ while문
 * while문과 비슷하지만, 최초 한번은 무조건 실행된다.
 * 
 */

public class Loop02 {
	public static void main(String[] args) {
		
		int count = 0;
		do {
			// 반복 실행할 코드 영역
			System.out.println(count);
			count++;
		} while (count < 100);
	}

}

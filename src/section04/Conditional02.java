package section04;
/*
 * 1-2. if~else문
 * 	if조건식{
 * 	조건식 true일 때 실행 명령문
 * }else{
 * 	조건식 false일 때 실행 명령문
 * }
 * 
 */
public class Conditional02 {
	public static void main(String[] args) {
		int num=72;
		
		if(num%2==0) {
			System.out.println("num은 짝수입니다.");
		}else {
			System.out.println("num은 홀수입니다.");
		}
		if(num%2==0) 
			System.out.println("num은 짝수입니다.");
		else 
			System.out.println("num은 홀수입니다.");
		
	}
}

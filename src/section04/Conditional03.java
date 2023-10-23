package section04;
/*
 * 1-3. if ~ else if ~ else 문
 * if(조건식1){
 * 
 * } else if(조건식2) {
 * 
 * } else {
 * 
 * }
 * 
 */

public class Conditional03 {
	public static void main(String[] args) {
		//double num=13.5;
		int num=10;
		if(num%3==0) {
			System.out.println("num%3==0");
		}else if(num%3==1) {
			System.out.println("num%3==1");
		}else if(num%3==2) {
			System.out.println("num%3==2");
		}else {
			System.out.println("num은 정수가 아닙니다.");
		}
	}
}

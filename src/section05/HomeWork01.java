package section05;

public class HomeWork01 {
	public static void main(String[] args) {
		for(int i=0;i<4;i++) {
			for(int j=3;j>0;j--) {
				if(j>i) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
				
			}
			System.out.println("*");
		}
		
		
		System.out.println("===============");
		
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<3-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		System.out.println("================");
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<3-i;j++) {
				// 4, 3, 2, 1
				//System.out.print("o");
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++) {
				// 1, 3, 5 ,7
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("======================");
		
		for(int i=0;i<7;i++) {
			if(i<4) {
				// i=0,1,2,3
				for(int j=0;j<3-i;j++) {
					// 3 2 1 0
					System.out.print(" ");
				}
				for(int j=0;j<2*i+1;j++) {
					// 1 3 5 7
					System.out.print("*");
				}
				System.out.println();
			}else {
				// i=4,5,6
				for(int j=0;j<i-3;j++) {
					// 1 2 3
					System.out.print(" ");
				}
				for(int j=0;j<(13-2*i);j++) {
					// 5 3 1
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		System.out.println("=====================");
		
		
		
	}
}

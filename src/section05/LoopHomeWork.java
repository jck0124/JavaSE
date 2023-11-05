package section05;
/*
2번 
   *
  **
 ***
****

3번
	*
   ***
  *****
 *******

4번
    *
   ***
  *****
 *******
  *****
   ***
    *
    
5번 구구단
 2 x 1 = 2  3 x 1 = 3  4 x 1 = 4
 
    
 */

public class LoopHomeWork {
	public static void main(String[] args) {
		
		for (int k=0; k<3; k++) {
			System.out.println("k = " + k);
			for(int i=0; i<9; i++) {
				for(int j=0; j<3; j++) {
					 int dan = j+2+(k*3);
					 int num = i+1;
					 
					 if(dan<10) System.out.print(dan+"x"+num+"="+dan*num+"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		
		
	}
	
}

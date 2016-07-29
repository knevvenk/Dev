//Input is a two dimension array of alphabets (case insensitive). Find out the number of palindromes in the whole matrix (including 2 digit words).
public class PalindromesIn2DMatrix {

	private static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char alpha[][] = new char[][]{
			{'a','b','a'},
			{'b','a','b'},
			{'a','a','b'}
		};
		noOfPalindromes(alpha);
		System.out.println("No of Pali's"+count);
		
	}

	private static void noOfPalindromes(char[][] alpha) {
		// TODO Auto-generated method stub
		for (int a = 0; a < 3; a++) {			
			for (int i = 0; i < 3;) {
				String str = "";
				int index = i;
				int row=a;
				for (; row < 3; row++) {
					str += alpha[row][index];
					int k = index + 1;
					if (str.length() > 1) {
//						 System.out.println("++++++====="+str);
						if (checkPalindrome(str)) {
							System.out.println("--- " + str);
							count++;
						}
					}
					for (; k < 3; k++) {

						str += alpha[row][k];
//						 System.out.println("**********"+str);
						if (checkPalindrome(str)) {
							System.out.println("--- " + str);
							count++;
						}

					}

					k = 0;
					index = 0;

				}
				row=0;
				i++;
				
			}
			
		}
		
	}
	
	private static boolean checkPalindrome(String str){
		boolean isPalindrome = true;
		int start=0;
		int end = str.length()-1;
		while(start<=end){
			if(str.charAt(start)!=str.charAt(end)){
				isPalindrome = false;
				return isPalindrome;
			}
			start++;
			end--;
		}
		return isPalindrome;
	}

}

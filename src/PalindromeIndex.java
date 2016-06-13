import java.util.Scanner;
/**
 * 
 * @author banve02
 *
 */
public class PalindromeIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		String[] input = new String[size];
		for(int i=0; i<size;i++){
			in = new Scanner(System.in);
			String s = in.next();	
			input[i] = s;
//			System.out.println(returnWrongIndex(s));
		}
		
		for(int i=0; i<size;i++){
			System.out.println(returnWrongIndex(input[i]));
		}
		
	}

	private static int returnWrongIndex(String s) {
		// TODO Auto-generated method stub
		int startIndex=0, endIndex=s.length()-1, wrongIndex=-1;
		
		while(startIndex<=endIndex){
			if(s.charAt(startIndex)==s.charAt(endIndex)){
				startIndex++;
				endIndex--;
			}
			else if(s.charAt(startIndex+1)==s.charAt(endIndex)){
				wrongIndex = startIndex;
				break;
			}
			else if(s.charAt(startIndex)==s.charAt(endIndex-1)){
				wrongIndex = endIndex;
				break;
			}
		}
		return wrongIndex;
	}

}

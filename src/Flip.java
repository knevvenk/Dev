import java.util.ArrayList;

public class Flip {
    public ArrayList<Integer> flip(String A) {
        if(!A.contains("0"))
            return new ArrayList<Integer>();
        char[] ch = A.toCharArray();        
        int index1 = -1;
        int index2 = -1;
        int count =0, tempCount =0;
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch.length; j++) {
				int k = i;
				while (k <= j) {
					if (ch[k] == '0')
						ch[k] = '1';
					else
						ch[k] = '0';
					k++;
				}
				tempCount = countOnes(ch);
				if(count<tempCount) {
					count = tempCount;
					index1 = i;
					index2 = j;
				}
				ch = A.toCharArray();
			}			
		}
		ArrayList<Integer> output = new ArrayList<Integer>();
		output.add(index1+1);
		output.add(index2+1);
        return output;
    }

	private int countOnes(char[] ch) {
		int count =0;
		for(int i =0;i<ch.length;i++)
			if(ch[i] == '1')
				count++;
		return count;
	}
	
	public static void main(String[] args) {
		String A = "010";
		Flip f = new Flip();
		System.out.println(f.flip(A));
	}
    
}
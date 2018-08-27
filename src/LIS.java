
public class LIS {
	
	public static void main(String[] args) {
		int arr[] = {11,9, 10, 22, 9, 33, 21, 50, 41, 60, 80, 7};
		int length = arr.length;
		int LIS[] = new int[length];
		
		for(int i=0; i<length;i++)
			LIS[i] = 1;
		int count =0;
		for(int i =1; i<length; i++) {
			for(int j =0; j<i; j++) {
				if(arr[i]>arr[j] && LIS[i]<LIS[j]+1)
					LIS[i] = LIS[j]+1;
				count++;
			}
		}
		int max =0;
		for(int i =0; i<LIS.length;i++) {
			System.out.print(LIS[i]);
			if(LIS[i]>max)
				max = LIS[i];
		}
		
		System.out.println("\n"+count+" -- "+max);
		for(int i=length-1; i>=0;i--) {
			if(LIS[i] == max) {
				System.out.print(arr[i]+", ");
				max -= 1;
			}
		}
	}
}

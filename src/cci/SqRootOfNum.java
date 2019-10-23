package cci;

public class SqRootOfNum {
	public static double findSqRoot(int n, int precision) {
		int start = 0, end = n - 1;
		int mid = 0;
		double sqRoot = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if ((mid * mid) == n) {
				sqRoot = mid;
				return mid;
			} else if ((mid * mid) > n) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		sqRoot = mid;
		double increment = 0.1;
		while (precision > 0) {
			while ((sqRoot * sqRoot) <= n) {
				sqRoot += increment;
			}
			sqRoot = sqRoot - increment;
			increment = increment / 10;
			precision = precision - 1;
		}
		return sqRoot;
	}

	public static int sqrt(int x) {
		if (x == 0)
			return 0;
		int start = 1, end = x, ans=0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid <= x / mid) {
				start = mid + 1;
				ans = mid;
			} else {
				end = mid - 1;
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		int n = 22;
		System.out.println(findSqRoot(n,3));
	}
}

public class CoverDistance {

	public int dp_cd(int distance) {
	
		if (distance == 0 || distance == 1)
			return 1;
		if (distance == 2)
			return 2;

		int[] dp = new int[distance+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i=3; i<=distance; i++)
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];

		return dp[distance];
	}

	private int cd_util(int currentStep, int distance) {
	
		if (currentStep == distance)
			return 1;

		if (currentStep > distance)
			return 0;

		int oneStep = cd_util(currentStep+1, distance);
		int twoStep = cd_util(currentStep+2, distance);
		int threeStep = cd_util(currentStep+3, distance);

		return oneStep + twoStep + threeStep;
	}

	public int cd(int distance) {
	
		return cd_util(0,distance);
	}

	public static void main(String[] args) {

		CoverDistance obj = new CoverDistance();
		System.out.println(obj.cd(8));
		System.out.println(obj.dp_cd(8));
	}
}

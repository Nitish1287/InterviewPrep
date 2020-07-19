Recursive - Brute Force Approach:
check combination of all weights
starting from last item, for each item check two cases a)with item b)without item
public int solveKnapsack(int[] profits, int[] weights, int capacity) {
	int maxProfit = 0;
	int n = weights.length;
	maxProfit = helper(profits, weights, capacity, n-1);
    return maxProfit;
}

public int helper(int[] profits, int[] weights, int currCapacity, int currWeightIndex){
	if(currWeightIndex<0){
		return 0;
	}

	if(weights[currWeightIndex]>currCapacity){
		return helper(profits, weights, currCapacity, currWeightIndex-1);
	}else{
		return Math.max( helper(profits, weights, currCapacity, currWeightIndex-1), 
			profits[currWeightIndex]+helper(profits, weights, currCapacity-weights[currWeightIndex], currWeightIndex-1)
			);
	}

	
}


Time complexity - O(2^n).. each item branches into two paths
Space complexity - O(n).. recursion stack of depth n
==========================================================================================================================

Recursive - DP: Top down
public int solveKnapsack(int[] profits, int[] weights, int capacity) {
	int maxProfit = 0;
	int n = weights.length;
	int[][] dp = new int[n][capacity+1];
	maxProfit = helper(profits, weights, capacity, n-1, dp);
    return maxProfit;
}

public int helper(int[] profits, int[] weights, int currCapacity, int currWeightIndex, int[][] dp){
	if(currWeightIndex<0){
		return 0;
	}

	if(dp[currWeightIndex][currCapacity] > 0){
		return dp[currWeightIndex][currCapacity];
	}

	if(weights[currWeightIndex]>currCapacity){
		dp[currWeightIndex][currCapacity] = helper(profits, weights, currCapacity, currWeightIndex-1);
	}else{
		dp[currWeightIndex][currCapacity] =Math.max(
										helper(profits, weights, currCapacity, currWeightIndex-1), 
			profits[currWeightIndex]+helper(profits, weights, currCapacity-weights[currWeightIndex], currWeightIndex-1)
			);
	}
	return dp[currWeightIndex][currCapacity];
}


Time complexity - O(n * capacity).. once an index and capicity combination is calculated, it can be used by memorization
Space complexity - ??

============================================================================================================================

Iterative - DP: Bottom up
public int solveKnapsack(int[] profits, int[] weights, int capacity) {
	int n = weights.length;
	int[][] dp = new int[n][capacity+1];

	for(int i=0; i<n; i++){
		for(int j=1; j<=capacity; j++){
			if(j>=weights[i]){
				dp[i][j] = Math.max(dp[i-1][j], profits[i]+dp[i-1][j-weights[i]]);
			}else{
				dp[i][j] = dp[i-1][j];
			}
		}
	}

    return dp[n][capacity];
}


Time complexity - O(n * capacity)
Space complexity - O(n * capacity)
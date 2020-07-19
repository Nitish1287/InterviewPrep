Recursive - Brute Force Approach:
check combination of all weights
starting for last item, for each item check two cases a)with item b)without item
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
		return Math.max(
										helper(profits, weights, currCapacity, currWeightIndex-1), 
			profits[currWeightIndex]+helper(profits, weights, currCapacity-weights[currWeightIndex], currWeightIndex-1)
			);
	}

	
}


Time complexity - O(2^n).. each item branches into two paths
Space complexity - O(n).. recursion stack of depth n
==========================================================================================================================

Recursive - DP:
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
Space complexity - O(n).. recursion stack of depth n

===========================================================================================================================
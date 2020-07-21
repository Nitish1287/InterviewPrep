public int singleNonDuplicate(int[] nums) {
	int n = nums.length;
	if(n==1 || (nums[0]!=nums[1])){
		return nums[0];
	}
	if(nums[n-1]!=nums[n-2]){
		return nums[n-1];
	}
	for(int i=1; i<=n-2; i++){
		if(nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
			return nums[i];
		}
	}
	return -1;
}

Time Complexity - O(n)
Space Complexity - O(1)

==================================================================

public int singleNonDuplicate(int[] nums) {
        int lo= 0;
        int hi = nums.length-1;
        while(lo<=hi){
            if(lo==hi){
                return nums[lo];
            }
            int mid = lo+(hi-lo)/2;
            if(nums[mid]==nums[mid+1]){
                if((hi-mid)%2==1){
                    hi = mid-1;
                }else{
                    lo = mid+2;
                }
            }else if(nums[mid]==nums[mid-1]){
                if((mid-lo)%2==1){
                    lo = mid+1;
                }else{
                    hi = mid-2;
                }
            }else{
                return nums[mid];
            }
        }
        return -1;
}

Time Complexity - O(log n)
Space Complexity - O(1)
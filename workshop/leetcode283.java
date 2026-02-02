import java.util.Arrays;

class leetcode283 
{
    public static void moveZeroes(int[] nums){
        int k=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
             int temp=nums[k];
              nums[k]=nums[i];
             nums[i]=temp;
             k++;
            }
        }
		
    }
	public static void main(String ... args)
		{	
		int  nums[]={1,0,2,0,3,0,4};
			
			
			moveZeroes(nums);
			
			System.out.println(Arrays.toString(nums);
			
			for(int i : nums)
			{
				System.out.println(i);
			}
			
		}
}

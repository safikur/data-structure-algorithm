package ds.arrays;

public class EvenNumberOfDigits {

	public static void main(String[] args) {
		int[] nums = new int[]{12,345,2,6,7896};
//		System.out.println(9/10);
//		System.out.println(getDigits(999));
		System.out.println(findNumbers(nums));
	}
	
	public static int findNumbers(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            // get number of digits
        	int temp = nums[i], digit=1;
            while(temp/10 > 0){
                temp=temp/10;
                digit++;
            }
            if (digit%2==0){
                count++;
            }
        }
        return count;
    }
	
	public static int getDigits(int num) {
		int temp = num, digit=1;
        while(temp/10 > 0){
            temp=temp/10;
            digit++;
        }
        return digit;
	}
}

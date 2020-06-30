import java.util.Arrays;
public class Sort012 {
  public static void main(String args[]){
    int[] a = {1};
    sort(a);
    System.out.println(Arrays.toString(a));
  }
    public static void sort(int[] nums) {
        int pivot = 1;
        int i = -1, j = -1, temp;
        for(int k = 0 ; k < nums.length ; k++){
            if(nums[k] < pivot){
                i++;
                j++;
                temp = nums[k];
                nums[k] = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            } else if(nums[k] == pivot){
                j++;
                temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
            }
        }
    }
}

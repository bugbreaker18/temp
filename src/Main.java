public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,3};
      //  int target = 40;  
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);
    }
   /** static int simplebinarysearchinarray
            (int[] arr,
             int target) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]) {
                start = 0;
                end = mid - 1;
            }else if(target>arr[mid]){
                end = arr.length -1;
                start = mid+1;
            }else if(target==arr[mid]) return mid;
        }
        return -1;
    }
    //#---------------------------------------------------------------------#

   /** static int unknownsortedbinarysearchinarray
            (int []arr,
             int target){
        int start = 0;
        int end = 0;
        int mid = 0;
        if(arr[0]<arr[arr.length-1]){
             start = 0;
             end = arr.length-1;
             for(int i= 0; i<arr.length-1;i++){
                 mid = start + (end -start)/2;
                 if(target>arr[mid]){
                     start = 0;
                     end = mid-1;
                 }
                 if(target<arr[mid]){
                     start = mid+1;
                     end = arr.length;
                 }
                 if(target == arr[mid]) return mid;
             }
        }
        if(arr[0]>arr[arr.length-1]){
            start = 0;
            end = arr.length-1;
            for(int i = 0; i<arr.length-1;i++){
                mid = start + (end -start)/2;
                if(target>arr[mid]){
                    start  = 0;
                    end = mid-1;
                }
                if(target<arr[mid]){
                    start= mid+1;
                    end = arr.length;
                }
                if(target == arr[mid]) return mid;
            }
        }
        return start;
    }
    #----------------------------------------------------------------------------------
    **/

   /**static int searchelementininfinitearray(int[] arr, int target){
       int start = 0;
       int end = 2;
       int mid= 0;
       int n= 2;
       int ans = -1;
       while(start<=end){
           if(target<arr[end]){
               ans = simplebinarysearchinarray(arr, target);
               break;
           } else{
               int newstart = end+1;
               end = start + (end-start+1);
               start = newstart;
           }
       }
       return ans;
   }
   **/

   static int peakIndexInMountainArray(int[] arr) {
       int start = 0;
       int end = arr.length -1;
       while(start<=end){
           int mid = start + (end - start)/2;
           if(arr[mid] > arr[mid+1]){
               end = mid;
           } else{
               start = mid+1;
           }
       }
       return start;
   }
}
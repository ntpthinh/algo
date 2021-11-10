class Solution {
    public int longestMountain(int[] arr) {
        int max = 0;
        int start = 0;
        int peek = 0;
        int n = arr.length;
        while(start < n){
            int end = start;
            while(end + 1 < n && arr[end+1] > arr[end])
                end++;
            peek = end;
            while(end+ 1<n && arr[end+1]<arr[end]) end++;

            if(start!=peek&&peek!=end){
                max = Math.max(end-start+1,max);
            }
            if(start!=end) start = end;
            else start++;
        }
        return max;
        // NOT WORKING
//         int max = 0;
//         boolean isMountain = false;
//         int start = 0, end = 0;
//         while(end<arr.length-1){
//             if(!isMountain){
//                 if(arr[end]>arr[end+1])
//                     isMountain = true;
//                 end++;
//             }else{
//                 if(arr[end]<arr[end+1]){
//                     max = Math.max(end-start+1, max);
//                     isMountain = false;
//                     start = end;
//                 }else{
//                     max = Math.max(end-start+1, max);
//                     end++;
//                 } 
//             }
//         }
//         if(isMountain&&arr[end]<arr[end-1]){
//                                 max = Math.max(end-start+1, max);

//         }
//         return max>=3?max:0;
    }
}
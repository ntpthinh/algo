class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Brute-force solution: tranverse matrix to find x => O(mxn)
        // If we start from the beginning, we will have 4 options to go. 
        // However, when starting from right bottom corner, we only have 2
        int i = matrix.length-1;
        int j = 0;
        while(i>=0 && j < matrix[0].length){
            if(matrix[i][j]== target) return true;
            else if(matrix[i][j]>target){
                i--;
            } else{
                j++;
            }
        }
        return false;
    }
}
import java.util.*;
public class TwoDBinarySearch {

    public static void main(String[] args) {
        // input 2d array
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(twodbinarysearch(arr, 15)));
    }

    static int[] twodbinarysearch(int[][] matrix, int target){
        int rows = matrix.length; // total no. of rows
        int rStart = 0;  // starting row
        int rEnd = matrix.length -1; // ending row
        int cols = matrix[0].length; // total no. of columns
        //if matrix is 1d:
        if(rows == 1){
            return binarysearch(matrix, 0, 0, cols -1, target);
        }

        int cStart = 0; //starting col
        int cEnd = cols -1; //ending col
        int cMid = cols/2; // mid col

        // Perform binary search on mid column and depending on the conditions ignore the above or below rows
        // Perform binary search until 2 rows are remaining, bcoz in the mid wala row.. there may be and element greater/smaller than mid which may be equal to the target.
        while(rStart < rEnd -1 ){
            int rMid = rStart + (rEnd - rStart)/2 ; //mid row -> to perform binarysearch in midcol;

            if( matrix[rMid][cMid] == target){
                return new int[]{rMid, cMid};
            }
            else if( matrix[rMid][cMid] < target){
                rStart = rMid;
            }
            else{
                rEnd = rMid;
            }

        }
        // now we are having 2 rows only..    1. rStart   2. rEnd = rStart +1

        // check if the target is in the mid column
        // if target = first element of mid column
        if(matrix[rStart][cMid] >= target ){
            return new int[]{rStart, cMid};
        }
        // if target = 2nd element of mid column
        if(matrix[rStart + 1][cMid] >= target ){
            return new int[]{rStart + 1, cMid};
        }

        // The remaining matrix is now divided into 4 parts.
        // Check the conditions where the target fits and accordingly apply binary search in that specific part.

        // Check in part 1, in 1st row, from 1st element to the element just before the element in mid col
        if(matrix[rStart][cMid - 1] >= target){
            binarysearch(matrix, rStart, 0, cMid - 1, target);
        }
        // Check in part 2, in 1st row, from the  element just after the element in mid col to the last element
        if(matrix[rStart + 1][cMid - 1] >= target){
            binarysearch(matrix, rStart + 1, 0, cMid - 1, target);
        }
        // Check in part 3, in 2nd row, from 1st element to the element just before mid element
        if(matrix[rStart][cMid + 1] <= target && target <= matrix[rStart][cEnd]){
            binarysearch(matrix, rStart, cMid + 1, cEnd, target);
        }
        // Check in part 4, in 2nd row, from the  element just after the element in mid col to the last eleme
        if(matrix[rStart + 1][cMid + 1] <= target && target <= matrix[rStart + 1][cEnd]){
            binarysearch(matrix, rStart + 1, cMid + 1, cEnd, target);
        }
        return new int[]{-1, -1};
    }

    static int[] binarysearch(int[][] arr, int row, int cStart, int cEnd, int target){
        //Normal Binary Search
        while(cStart < cEnd){
            int mid = cStart + (cEnd - cStart)/2 ;
            if(arr[row][mid] == target){
                return new int[]{row,mid};
            }
            if(arr[row][mid] > target){
                cStart = mid + 1;
            } else{
                cEnd = mid -1;
            }
        }
        return new int[]{-1,-1};
    }

}


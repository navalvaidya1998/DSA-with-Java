package arrays;
public class MedianOfTwoSortedArraysBruteForceApproach {
    public static double findMedianOf2SortedArrays(int[] arr1,int[] arr2){
        int m = arr1.length, n= arr2.length,i=0,j=0,k=0;
        int[] mergeArray = new int[m+n];
        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                mergeArray[k++]=arr1[i++];
            }else{
                mergeArray[k++]=arr2[j++];
            }
        }
        while(i<m){
            mergeArray[k++]=arr1[i++];
        }
        while(j<n){
            mergeArray[k++]=arr2[j++];
        }
        if(mergeArray.length%2==0){
            return ((mergeArray[mergeArray.length/2]+mergeArray[mergeArray.length/2-1])/2.0);
        }else{
            return mergeArray[mergeArray.length/2];
        }
        
    }

}

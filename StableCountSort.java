public class StableCountSort {
    static void displayArr(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static void countSort(int[] arr){
        int n = arr.length;
        int [] output = new int[n];
        int max = findMax(arr);
        int[] count = new int[max+1];
        for(int i = 0 ; i < arr.length ; i++){ // Make frequency array
            count[arr[i]]++;
        }

        // Make prefix sum array of count array

        for(int i = 1 ; i < count.length ; i++){
            count[i] += count[i-1];
        }

        // Find the index of each element in the original array and put it in output array
        
        for(int i = n-1 ; i >= 0 ; i--){
            int index = count[arr[i]] - 1;
            output[index] = arr[i];
            count[arr[i]]--;
        }

        // Copy alll elements of output to arr

        for(int i = 0 ; i < n ; i++){
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,3,1,5,3,1,3,5};
        countSort(arr);
        displayArr(arr);
    }
}

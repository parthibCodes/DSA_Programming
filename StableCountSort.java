public class StableCountSort {
    static void displayArr(int[] arr){
        for(int i : arr){   // TC --> n
            System.out.print(i+" ");
        }
    }

    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i : arr){   // TC --> n
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static void countSort(int[] arr){
        int n = arr.length; // SC--> n
        int [] output = new int[n];
        int max = findMax(arr);
        int[] count = new int[max+1]; // SC--> max+1
        for(int i = 0 ; i < arr.length ; i++){ // Make frequency array     // TC-->n
            count[arr[i]]++;
        }

        // Make prefix sum array of count array

        for(int i = 1 ; i < count.length ; i++){ //TC--> k / max
            count[i] += count[i-1];
        }

        // Find the index of each element in the original array and put it in output array
        
        for(int i = n-1 ; i >= 0 ; i--){  // TC --> n
            int index = count[arr[i]] - 1;
            output[index] = arr[i];
            count[arr[i]]--;
        }

        // Copy alll elements of output to arr

        for(int i = 0 ; i < n ; i++){ // TC--> n
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,3,1,5,3,1,3,5};
        countSort(arr);
        displayArr(arr);
    }
}


// Overall TC ---> O(n+max)

// Overall SC ---> O(n+max)

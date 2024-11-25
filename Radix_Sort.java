public class Radix_Sort {
    static void displayArr(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static void countSort(int[] arr ,int place){
        int n = arr.length;
        int [] output = new int[n];
        int[] count = new int[10];
        for(int i = 0 ; i < arr.length ; i++){ // Make frequency array    if arr[i] = 105 and place is one then we have to make the frequency array of only 1's place's digit that's '5'
            count[(arr[i]/place)%10]++;
        }

        // Make prefix sum array of count array

        for(int i = 1 ; i < count.length ; i++){
            count[i] += count[i-1];
        }

        // Find the index of each element's parthicular place's digits in the original array and put it in output array
        
        for(int i = n-1 ; i >= 0 ; i--){
            int index = count[(arr[i]/place)%10] - 1;
            output[index] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        // Copy alll elements of output to arr

        for(int i = 0 ; i < n ; i++){
            arr[i] = output[i];
        }
    }
    static void radixSort(int[] arr){
        int max = findMax(arr); // TC---> O(n)
        
        // apply counting sort to sort elemnts based on their place-value

        // For place value--->

        for(int place = 1 ; max/place > 0 ; place*=10){
            countSort(arr , place); // TC---> O(dn) ; here max=10 and d = number of digits in the number
        }
    }
    public static void main(String[] args) {
        int[] arr = {170,45,75,90,802,2};
        radixSort(arr);
        displayArr(arr);
    }
}


// Overall TC---> O(d*n)

// Overall SC---> O(1)
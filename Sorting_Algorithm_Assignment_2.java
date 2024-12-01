public class Sorting_Algorithm_Assignment_2 {

    // Question 1--->
    static void swapToSort(int[] arr, int n) {
        int x = -1;
        int y = -1;
        if(n <= 1)return;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                if (x == -1) {
                    x = i - 1;
                } else {
                    y = i;
                }
            }
        }
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // Question 2--->

    static void partition(int[] arr){
        int l = 0 , r = arr.length-1;
        while(l < r){
            while(arr[l] <= 0)l++;
            while(arr[r] > 0)r--;
            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }
    static void swap(int[] arr, int x ,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void sort012(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr, mid, high);
                high--;
            }
            else{
                mid++;
            }
        }
    }
    public static void main(String[] args) {
        // int[] num = { -10, 5, -6, 7, 8, -9, 3 };
        int[] num = {2,1,1,1,1,0,0,2,2,1,1};
        // swapToSort(num, num.length);
        sort012(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}

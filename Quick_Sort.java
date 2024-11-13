public class Quick_Sort {
    static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr , int st , int end){
        int pivot = arr[st];
        int count = 0;// Count the number of elements less than pivot
        for(int i = st+1 ; i <= end ; i++ ){
            if(arr[i] <= pivot)count++;
        }
        int pivotIndex = st+count;
        swap(arr,st,pivotIndex);
        int i = st , j = end;
        while(i < pivotIndex && j > pivotIndex){
            while(arr[i] <= pivot)i++;
            while(arr[j] > pivot)j--;

            if(i < pivotIndex && j > pivotIndex){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }
    static void quickSort(int[] arr , int st , int end){
        if(st>=end)return;
        int pi = partition(arr , st , end);
        quickSort(arr, st, pi-1);
        quickSort(arr, pi+1, end);
    }
    public static void main(String[] args) {
        int[] arr = {7,13,8,5,10,2,4};
        quickSort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}

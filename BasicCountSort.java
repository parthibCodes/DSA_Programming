public class BasicCountSort{

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
        //find largest element
        int max = findMax(arr);
        int[] count = new int[max+1];
        for(int i = 0 ; i < arr.length ; i++){
            count[arr[i]]++;
        }
        int k = 0;
        for(int i = 0 ; i < count.length ; i++){
            for(int j = 0 ; j < count[i] ; j++){
                arr[k++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,3,1,5,3,1,3,5};
        countSort(arr);
        displayArr(arr);
    }
}
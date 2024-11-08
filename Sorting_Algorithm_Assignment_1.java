//  Question--->1) Given an array of strings arr[]. Sort given strings using Bubble Sort and display the sorted
// array.

public class Sorting_Algorithm_Assignment_1{
    static void sortStrings(String[] str){
        int n = str.length;
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0 ; j < n-i-1 ; j++){
                if(str[j].compareTo(str[j+1]) > 0){
                    String temp = str[j];
                    str[j] = str[j+1];
                    str[j+1] = temp;
                }
            }
        }
    }


//  Question---->2) Given a string s, return the string which contains all characters of s in lexicographical
//  order.    
    static String sortCharacters(String str){
        int n = str.length();
        char[] chars = str.toCharArray();
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0 ; j < n-i-1 ; j++){
                if(chars[j] > chars[j+1]){
                    char temp = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = temp;
                }
            }
        }
        return new String(chars);
    }

//Question---->3)Given an integer array and an integer k where k<size of array, We need to return the kth smallest element of the array.


    static int kthSmallestElement(int[] arr , int k){
        int n = arr.length;
        for(int i = 0 ; i < n-1 ; i++){
            int min_index = i;
            for(int j = i+1 ; j < n ; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        if(k == 0){
            return arr[0];
        }
        return arr[k-1];
    }


    // static void greaterThanSizeOfArray(int[] arr){
    //     int n = arr.length;
    //     for(int i = 0 ; i < n ; i++){
    //         if(n % 2 == 0 && arr[i] > n){
    //             System.out.println(arr[i]+" ");
    //         }
    //         if(n%2 != 0 && arr[i] > n){

    //         }
    //     }
    // }

    public static void main(String[] args) {
        String[] str = {"coding" , "is" , "fun"};
        sortStrings(str);
        System.out.print("The lexicographical order is: ");
        for (String i : str) {
            System.out.print(i + " ");
        }

        System.out.println();

        String s = "coding";
        System.out.println("The lexicographical order of the string " + s + " is " + sortCharacters(s));

        System.out.println();

        int[] arr = {6,4,10,5};
        System.out.println(kthSmallestElement(arr, 0));
    }
}






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

    //Question 4 --->Given an array of n elements, the task is to find the elements that are greater than half of elements in an array. In case of odd elements, we need to print elements larger than floor(n/2) elements where n is total number of elements in array.

    static void GreaterThanHalves(int[] arr , int n){
        for(int i = 1 ; i < n ; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }

        int si = (n % 2 == 0) ? n / 2 : (n + 1) / 2;

        for(int i = si ; i < n ; i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    //Question 5---> Given an array of digits (values are from 0 to 9), the task is to find the minimum possible sum of two numbers formed from digits of the array. Please note that all digits of the given array must be used to form the two numbers.

    static void sumOfDigits(int[] arr){
        int n = arr.length;

        for(int i = 1 ; i < n ; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        
        }
        int a = 0 , b = 0;
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){
                a = a*10 + arr[i];
            }
            else{
                b = b*10 + arr[i];
            }
        }
        System.out.println(a + b);
    }

    //Q6 - Given an array with N distinct elements, convert the given array to a form where all elements are in the range from 0 to N-1. The order of elements is the same, i.e., 0 is placed in the place of the smallest element, 1 is placed for the second smallest element, ... N-1 is placed for the largest element.

    static void postionAfterSorting(int[] arr){
        int[] temp = arr.clone();
        int n = temp.length;
        for(int i = 1 ;  i < n ; i++){
            int j = i ;
            while(j > 0 && arr[j] < arr[j-1]){
                int tempv = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tempv;
                j--;
            }
        }
        int pos = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < temp.length ; j++){
                if(arr[j] == temp[i]){
                    arr[j] = pos;
                    pos++;
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }


    //Q7- Given an array, sort it using insertion sort recursively.

    static void recursivelyInsertion(int[] arr, int l, int r) {
        // Base condition to end recursion
        if (l >= r) return;
    
        // Compare and swap elements if needed
        if (arr[l] > arr[r]) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    
        // Recursively call with narrowed range
        recursivelyInsertion(arr, l + 1, r - 1);
    }
    
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

        System.out.println();

        int[] array = {10,4,2,8,9};
        GreaterThanHalves(array, array.length);

        System.out.println();

        int[] a = {6,8,4,5,2,3};
        sumOfDigits(a);

        System.out.println();

        int[] ar = {10,40,20};
        postionAfterSorting(ar);

        System.out.println();

        recursivelyInsertion(a,0,a.length-1);
        for(int i : a){
            System.out.print(i+" ");
        }
    }
}






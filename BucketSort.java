import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    static void bucketSort(float[] arr){
        int n = arr.length;
        //Buckets
        ArrayList<Float>[] buckets = new ArrayList[n];
        //Create empty buckets
        for(int i = 0 ; i < n ; i++){
            buckets[i] = new ArrayList<Float>();
        }

        // Add elements into our buckets

        for(int i = 0 ; i < n ; i++){
            int bucketIndex = (int) arr[i] * n;
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort each bucket individually
        for(int i = 0 ; i < buckets.length ; i++){
            Collections.sort(buckets[i]);
        }

        //Merge all the buckets to get final sorted array

        int index = 0;
        for(int i = 0 ; i < buckets.length ; i++){
            ArrayList<Float> currentBucket = buckets[i];
            for(int j = 0 ; j < currentBucket.size() ; j++){
                arr[index++] = currentBucket.get(j);
            }
        }
    }
    public static void main(String[] args) {
        float[] arr = {.5f,.6f,.4f,.1f,.2f,.3f};
        bucketSort(arr);
        for(float val : arr){
            System.out.print(val + " ");
        }
    }
}

package ArraysHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    /* Brute Force Approach
TC - O(K log D) as we are Poll K distinct elements from the Heap
     here D is no. of distinct (unique) elements in the input array

SC - O(D), this is the size of the heap.
HashMap and Heap
Make freq map
Make maxheap and fill it with keys and on the peek of our heap we will be
having most frequent elements

*/
    public int[] topKFrequentBF(int[] A, int k) {
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int key : map.keySet()) {
            maxHeap.add(key);
        }
        int[] res = new int[k];
        for (int i = 0 ; i < k ; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

/* TC - O(n) SC - O(n)
Create a bucket list of arrays size + +
go to that freq index and add the elements as list of arrays
now if we traverse bucket array from right to left we will get max visa versa

*/
    public int[] topKFrequent(int[] A, int k) {
        int n = A.length;
        List<Integer>[] bucket = new List[n + 1];
        HashMap<Integer, Integer>map = new HashMap<>();

        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        /*
            Now create bucket array add frequency

        */
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                //if null create list in that bucket frequency
                bucket[freq] = new ArrayList<>();
            }
            //now add the element
            bucket[freq].add(key);
        }

        //now traverse from right
        int[] ans = new int[k];
        int count = 0;
        for (int i = bucket.length - 1 ; i >= 0 ; i--) {
            if (bucket[i] != null) {
                //traverse the list
                for (int j = 0 ; j < bucket[i].size() ; j++) {
                    ans[count++] = bucket[i].get(k);
                }
            }
            if (count == k) break;
        }
        return ans;
    }
}

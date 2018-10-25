package sort;

/**
 * Sedgewick, Robert and Wayne, Kevin. Algorithms, 4th Edition.. : Addison-Wesley, 2011.
 * The design logic for sink, and the heap sort method below was taken from the cited textbook, Pg. 316, and 324.
 */
public class Heap {
	
    /**
	 * heap sort using Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
    public static void sortHeap(Comparable<Job>[] x, int n) {
        for (int key = n/2; key >= 1; key--)
            sink(x, key, n);
        
        while (n > 1) {
            swapJob(x, 1, n);
            n--;
            sink(x, 1, n);
        }
        
    }

    /**
	 * Sinks a Job element into its proper position
	 * @param x - the input array containing jobs.
	 * @param key - the index of a Job array that is being compared.
	 * @param n - the size of the Job array
	 */
    private static void sink(Comparable<Job>[] x, int key , int n) {
        while (2*key <= n) {
            int i = 2*key;
            if (i < n && x[i-1].compareTo((Job) x[i]) < 0) {
            	i++;
            }
            if (x[key-1].compareTo((Job) x[i-1]) > 0) {
            	break;
            }
            swapJob(x, key, i);
            key = i;
        }
        
    }
    
    /**
	 * Swaps two elements of an array of type Job
	 * @param x - the input array containing jobs.
	 * @param a - the index of a Job array that needs to be swapped.
	 * @param b - the index of a Job array that argument a is being swapped with.
	 */
    private static void swapJob(Comparable<Job>[] x, int a, int b) {
       Comparable<Job> temp = x[a - 1];
        x[a - 1] = x[b - 1];
        x[b - 1] = temp;
    }
}

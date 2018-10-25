package sort;

/**
 * Sedgewick, Robert and Wayne, Kevin. Algorithms, 4th Edition.. : Addison-Wesley, 2011.
 * The design logic for BinarySearch, swapJob, and each insertion method below was taken from the cited textbook, Pg. 47, 245, and 251.
 * Sedgewick, Robert, and Kevin Wayne. "BinaryInsertion.java." Princeton University. Accessed February 22, 2018. https://algs4.cs.princeton.edu/21elementary/BinaryInsertion.java.html.
 * The design logic for sortBinary was taken from the cited website.
 */
public class Insertion{
	
	/**
	 * Swaps two elements of an array of type Job
	 * @param x - the input array containing jobs.
	 * @param a - the index of a Job array that needs to be swapped.
	 * @param b - the index of a Job array that argument a is being swapped with.
	 */
	private static void swapJob(Comparable<Job>[] x, int a, int b) {
		Comparable<Job> temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	}
	
	/**
	 * regular insertion sort
	 * @param x - the input array containing jobs that need to be sorted.
	 */
	public static void sortInsert ( Job[] x ) {
		int n = x.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && x[j].getRunTime() < x[j-1].getRunTime(); j--) {
				swapJob(x, j, j-1);
			}
		}
		
	}
	
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable (Comparable<Job>[] x, int n ) {
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && x[j].compareTo((Job) x[j-1]) < 0; j--) {
				swapJob(x, j, j-1);
			}
		}
		
	}
	
	/**
	 * optimized insertion sort
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary ( Comparable<Job>[] x, int n ) {
		for (int i = 1; i < n; i++) {
			int lo = 0, hi = i;
            Comparable<Job> temp = x[i];
            
            while (lo < hi) {
                int mid = (lo + hi) / 2; 
                if (temp.compareTo((Job) x[mid]) < 0) {
                	hi = mid;
                }
                else {
                	lo = mid + 1;
                }
            }

            for (int j = i; j > lo; --j) {
            	x[j] = x[j-1];
            }
            
            x[lo] = temp;
        }
	    
	}
	
}

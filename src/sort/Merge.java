package sort;

/**
 * Sedgewick, Robert and Wayne, Kevin. Algorithms, 4th Edition.. : Addison-Wesley, 2011.
 * The design logic for the merge sort method below was taken from the cited textbook, Pg. 271, and 273.
 */
public class Merge { 
	
	/**
	 * Merge sort
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
    public static void sortMerge(Comparable<Job>[] x, int n) {
        Comparable<Job>[] temp = new Job[n];
        int lo = 0, hi = n - 1;
        
        splitArray(x, temp, lo, hi);
    }
	
	/**
	 * Recursively separate Comparable array into two sub-arrays until the sub-array only has two elements
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param lo - the first index of the array
	 * @param hi - the last index of the array
	 */
    private static void splitArray(Comparable<Job>[] x, Comparable<Job>[] temp, int lo, int hi) {
        if (lo == hi) {
        	return; 
        }
        
        int mid = (lo + hi) / 2;
        splitArray(x, temp, lo, mid);
        splitArray(x, temp, mid + 1, hi); 
        merge(x, temp, lo, mid, hi);
    }
    
    /**
	 * Merging two sub-arrays using Comparable.
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param lo - the first index of the array
	 * @param mid - the middle index of the array
	 * @param hi - the last index of the array
	 */
	private static void merge(Comparable<Job>[] x, Comparable<Job>[] temp, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
        	temp[i] = x[i]; 
        }
        
        int currentLo = lo, rightIndex = mid + 1;
        for (int key = lo; key <= hi; key++) {
            if (currentLo > mid) {
            	x[key] = temp[rightIndex]; 
            	rightIndex++;
            }
            else if (hi < rightIndex) {
            	x[key] = temp[currentLo]; 
            	currentLo++;
            }
            else if (temp[rightIndex].compareTo((Job) temp[currentLo]) < 0) {
            	x[key] = temp[rightIndex]; 
            	rightIndex++;
            }
            else {
            	x[key] = temp[currentLo]; 
            	currentLo++;
            }
        }
        
    }
	
}

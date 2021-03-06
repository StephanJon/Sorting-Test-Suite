package sort;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testMerge {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSortMerge() throws FileNotFoundException {
		String[][] initial = JobReader.readFileToArray("data/a1_in.txt");
		Job[][] Jobs = JobReader.StringtoJobArray(initial);
		int counter = 4;
		
		for (int i = 0; i < Jobs.length; i++) {
			Stopwatch timer = new Stopwatch();
			
			sort.Merge.sortMerge(Jobs[i], Jobs[i].length);
			System.out.printf("Elapsed Time List %d (size 2^%d): %.5fs\n", i+1, counter, timer.elapsedTime());
			assert SortedCheck(Jobs[i], Jobs[i].length);
			counter += 2;
		}
		System.out.printf("(Merge sort)\n\n");
	}
	
	private static boolean SortedCheck(Comparable<Job>[] x, int n) {
        for (int i = 1; i < n; i++) {
            if (x[i].compareTo((Job) x[i-1]) < 0) {
            	System.out.println("Not Sorted");
            	return false;
            }
        }
        return true;
            
    }	
}

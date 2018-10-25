package sort;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testHeapSort.class, testInsertBinary.class, testInsertComparable.class, testMerge.class,
		testSortInsertion.class })
public class testAllSort {

}

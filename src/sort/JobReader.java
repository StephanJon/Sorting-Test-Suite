package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobReader extends Insertion{

	/**
	 * Read a file of lists of Jobs separated by a newline;
	 * @param file - The name of the file to be read
	 */
	public static String[][] readFileToArray(String file) throws FileNotFoundException {
		Scanner in  = new Scanner(new File(file));
		List<String[]> lines = new ArrayList<String[]>();
		while(in.hasNextLine()) {
			String line = in.nextLine();
			String[] split = line.split("},");
			for (int i = 0; i < split.length; i++) {
				split[i] = split[i].substring(1);
			}
			int LastIndex = split.length - 1;
			split[LastIndex] = split[LastIndex].substring(0, split[LastIndex].indexOf("}"));
			lines.add(split);
		} in.close();
		
		String[][] result = new String[lines.size()][];
		for(int i = 0; i < result.length; i++) {
			result[i] = lines.get(i); 
		}
		return result;	}
	
	/**
	 * Converts a String[][] into Job[][]
	 * @param x - the input 2D array containing Strings
	 */
	public static Job[][] StringtoJobArray(String[][] x){
		List<Job[]> listofJobs = new ArrayList<Job[]>();
		for(int i = 0; i < x.length; i++) {
			Job[] add = new Job[x[i].length];
			for (int j = 0; j < x[i].length; j++) {
				int index = x[i][j].indexOf(",");
				add[j] = new Job(x[i][j].substring(0, index), Integer.parseInt(x[i][j].substring(index+1)));
			}
			listofJobs.add(add);
		}
		Job[][] Jobs = new Job[listofJobs.size()][]; 
		for(int i = 0; i < Jobs.length; i++) {
			Jobs[i] = listofJobs.get(i); 
		}
		return Jobs;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String[][] initial = readFileToArray("data/a1_in.txt");
		Job[][] Jobs = StringtoJobArray(initial);

		for (int i = 0; i < Jobs[4].length; i++) {
//			System.out.printf(Jobs[4][i].getJobID() + " " + Jobs[4][i].getRunTime());
//			System.out.println();
		}
		System.out.println(Jobs[4].length);
		System.out.printf(Jobs[6][0].getJobID() + " " + Jobs[6][0].getRunTime());
		System.out.println();
//		System.out.println();
//		sort.Heap.sortHeap(Jobs[1], Jobs[1].length);
		
//		for (int i = 0; i < Jobs[1].length; i++) {
//			System.out.printf(Jobs[1][i].getJobID() + " " + Jobs[1][i].getRunTime());
//			System.out.println();
//		}
	}

}

	
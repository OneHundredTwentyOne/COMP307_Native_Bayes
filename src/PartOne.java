import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PartOne {
	static int[][] labelled = new int[200][13];
	static int[][] probabilityTable = new int [200][13];
	int[][] unlabelled = new int[12][10];

	public static void main(String[] args) throws IOException {
		readData("spamLabelled.dat");
		printData();
		calcProbabilities();
	}

	public static void readData(String fileName) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			int lineCount = 0;
			String line = br.readLine();
			while (line.length() > 0) {
				String[] vals = line.trim().split("     ");
				// System.out.println(lineCount);
				for (int i = 0; i < vals.length; i++) {
					int val = Integer.valueOf(vals[i]);
					// System.out.println(val);
					labelled[lineCount][i] = val;
				}
				System.out.println(lineCount);
				System.out.println(line);
				lineCount++;
				if (lineCount < 200) {
					line = br.readLine();
				}
				else{
					break;
				}
			}
			br.close();
		} catch (IOException e) {

		}
	}

	public static void printData() {
		for (int x = 0; x < 200; x++) {
			for (int y = 0; y < 12; y++) {
				// System.out.println(labelled[x][y]);
			}
		}
	}
	
	public static void calcProbabilities(){
		
	}

}

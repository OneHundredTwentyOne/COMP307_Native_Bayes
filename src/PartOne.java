import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PartOne {
	static int[][] labelled = new int[200][13];
	static int[][] probabilityTable = new int [13][2];
	int[][] unlabelled = new int[25][10];

	public static void main(String[] args) throws IOException {
		readLabelledData("spamLabelled.dat");
		printData();
		createProbabilityTable();
		nativeBayes();
	}

	public static void readLabelledData(String fileName) throws IOException {
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
	
	public static void createProbabilityTable(){
		int totalSpam = 1; //Small constant to account for zero counts
		int totalNotSpam = 1;
		int totalA1 = 1;
		int totalNotA1 = 1;
		int totalA2 = 1;
		int totalNotA2 = 1;
		int totalA3 = 1;
		int totalNotA3 = 1;
		int totalA4 = 1;
		int totalNotA4 = 1;
		int totalA5 = 1;
		int totalNotA5 = 1;
		int totalA6 = 1;
		int totalNotA6 = 1;
		int totalA7 = 1;
		int totalNotA7 = 1;
		int totalA8 = 1;
		int totalNotA8 = 1;
		int totalA9 = 1;
		int totalNotA9 = 1;
		int totalA10 = 1;
		int totalNotA10 = 1;
		int totalA11 = 1;
		int totalNotA11 = 1;
		int totalA12 = 1;
		int totalNotA12 = 1;
		
		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][12]==1){
				totalSpam++;
			}
			else if(labelled[x][12]==0){
				totalNotSpam++;
			}
		}
		System.out.println("Total Spam is: " + totalSpam);
		System.out.println("Total notSpam is: " + totalNotSpam);
		probabilityTable[0][0] = totalSpam/200; //P(Class) = Spam
		probabilityTable[0][1] = totalNotSpam/200; //P(Class) = Not Spam
		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][1]==1){
				totalA1++;
			}
			else if(labelled[x][1]==0){
				totalNotA1++;
			}
		}
		int spamGivenA1 = totalA1/totalSpam;
		int notSpamGivenA1 = totalA1/totalNotSpam;
		int spamGivenNotA1 = totalNotA1/totalSpam;
		int notSpamGivenNotA1 = totalNotA1/totalNotSpam;
		probabilityTable[1][0] = spamGivenA1; //P(Attribute 1 | Class) = Spam
		probabilityTable[1][1] = notSpamGivenA1; //P(Attribute 1 | Class) = Not Spam
		probabilityTable[2][0] = spamGivenNotA1; //P(Not Attribute 1 | Class) = Spam
		probabilityTable[2][1] = notSpamGivenNotA1; //P(Not Attribute 1 | Class) = Not Spam
		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][2]==1){
				totalA2++;
			}
			else if(labelled[x][2]==0){
				totalNotA2++;
			}
		}
		int spamGivenA2 = totalA2/totalSpam;
		int notSpamGivenA2 = totalA2/totalNotSpam;
		int spamGivenNotA2 = totalNotA2/totalSpam;
		int notSpamGivenNotA2 = totalNotA2/totalNotSpam;
		probabilityTable[3][0] = spamGivenA2; //P(Attribute 2 | Class) = Spam
		probabilityTable[3][1] = notSpamGivenA2; //P(Attribute 2 | Class) = Not Spam
		probabilityTable[4][0] = spamGivenNotA2; //P(Not Attribute 2 | Class) = Spam
		probabilityTable[4][1] = notSpamGivenNotA2; //P(Not Attribute 2 | Class) = Not Spam

		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][3]==1){
				totalA3++;
			}
			else if(labelled[x][3]==0){
				totalNotA3++;
			}
		}
		int spamGivenA3 = totalA3/totalSpam;
		int notSpamGivenA3 = totalA3/totalNotSpam;
		int spamGivenNotA3 = totalNotA3/totalSpam;
		int notSpamGivenNotA3 = totalNotA3/totalNotSpam;
		probabilityTable[5][0] = spamGivenA3; //P(Attribute 3 | Class) = Spam
		probabilityTable[5][1] = notSpamGivenA3; //P(Attribute 3 | Class) = Not Spam
		probabilityTable[6][0] = spamGivenNotA3; //P(Not Attribute 3 | Class) = Spam
		probabilityTable[6][1] = notSpamGivenNotA3; //P(Not Attribute 3 | Class) = Not Spam

		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][4]==1){
				totalA4++;
			}
			else if(labelled[x][4]==0){
				totalNotA4++;
			}
		}
		int spamGivenA4 = totalA4/totalSpam;
		int notSpamGivenA4 = totalA4/totalNotSpam;
		int spamGivenNotA4 = totalNotA4/totalSpam;
		int notSpamGivenNotA4 = totalNotA4/totalNotSpam;
		probabilityTable[7][0] = spamGivenA4; //P(Attribute 4 | Class) = Spam
		probabilityTable[7][1] = notSpamGivenA4; //P(Attribute 4 | Class) = Not Spam
		probabilityTable[8][0] = spamGivenNotA4; //P(Not Attribute 4 | Class) = Spam
		probabilityTable[8][1] = notSpamGivenNotA4; //P(Not Attribute 4 | Class) = Not Spam

		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][5]==1){
				totalA5++;
			}
			else if(labelled[x][5]==0){
				totalNotA5++;
			}
		}
		int spamGivenA5 = totalA5/totalSpam;
		int notSpamGivenA5 = totalA5/totalNotSpam;
		int spamGivenNotA5 = totalNotA5/totalSpam;
		int notSpamGivenNotA5 = totalNotA5/totalNotSpam;
		probabilityTable[9][0] = spamGivenA5; //P(Attribute 5 | Class) = Spam
		probabilityTable[9][1] = notSpamGivenA5; //P(Attribute 5 | Class) = Not Spam
		probabilityTable[10][0] = spamGivenNotA5; //P(Not Attribute 5 | Class) = Spam
		probabilityTable[10][1] = notSpamGivenNotA5; //P(Not Attribute 5 | Class) = Not Spam

		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][6]==1){
				totalA6++;
			}
			else if(labelled[x][6]==0){
				totalNotA6++;
			}
		}
		int spamGivenA6 = totalA6/totalSpam;
		int notSpamGivenA6 = totalA6/totalNotSpam;
		int spamGivenNotA6 = totalNotA6/totalSpam;
		int notSpamGivenNotA6 = totalNotA6/totalNotSpam;
		probabilityTable[11][0] = spamGivenA6; //P(Attribute 6 | Class) = Spam
		probabilityTable[11][1] = notSpamGivenA6; //P(Attribute 6 | Class) = Not Spam
		probabilityTable[12][0] = spamGivenNotA6; //P(Not Attribute 6 | Class) = Spam
		probabilityTable[12][1] = notSpamGivenNotA6; //P(Not Attribute 6 | Class) = Not Spam

		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][7]==1){
				totalA7++;
			}
			else if(labelled[x][7]==0){
				totalNotA7++;
			}
		}
		int spamGivenA7 = totalA7/totalSpam;
		int notSpamGivenA7 = totalA7/totalNotSpam;
		int spamGivenNotA7 = totalNotA7/totalSpam;
		int notSpamGivenNotA7 = totalNotA7/totalNotSpam;
		probabilityTable[13][0] = spamGivenA7; //P(Attribute 7 | Class) = Spam
		probabilityTable[13][1] = notSpamGivenA7; //P(Attribute 7 | Class) = Not Spam
		probabilityTable[14][0] = spamGivenNotA7; //P(Not Attribute 7 | Class) = Spam
		probabilityTable[14][1] = notSpamGivenNotA7; //P(Not Attribute 7 | Class) = Not Spam

		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][8]==1){
				totalA8++;
			}
			else if(labelled[x][8]==0){
				totalNotA8++;
			}
		}
		int spamGivenA8 = totalA8/totalSpam;
		int notSpamGivenA8 = totalA8/totalNotSpam;
		int spamGivenNotA8 = totalNotA8/totalSpam;
		int notSpamGivenNotA8 = totalNotA8/totalNotSpam;
		probabilityTable[15][0] = spamGivenA8; //P(Attribute 8 | Class) = Spam
		probabilityTable[15][1] = notSpamGivenA8; //P(Attribute 8 | Class) = Not Spam
		probabilityTable[16][0] = spamGivenNotA8; //P(Not Attribute 8 | Class) = Spam
		probabilityTable[16][1] = notSpamGivenNotA8; //P(Not Attribute 8 | Class) = Not Spam

		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][9]==1){
				totalA9++;
			}
			else if(labelled[x][9]==0){
				totalNotA9++;
			}
		}
		int spamGivenA9 = totalA9/totalSpam;
		int notSpamGivenA9 = totalA9/totalNotSpam;
		int spamGivenNotA9 = totalNotA9/totalSpam;
		int notSpamGivenNotA9 = totalNotA9/totalNotSpam;
		probabilityTable[17][0] = spamGivenA9; //P(Attribute 9 | Class) = Spam
		probabilityTable[17][1] = notSpamGivenA9; //P(Attribute 9 | Class) = Not Spam
		probabilityTable[18][0] = spamGivenNotA9; //P(Not Attribute 9 | Class) = Spam
		probabilityTable[18][1] = notSpamGivenNotA9; //P(Not Attribute 9 | Class) = Not Spam
		
		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][10]==1){
				totalA10++;
			}
			else if(labelled[x][10]==0){
				totalNotA10++;
			}
		}
		int spamGivenA10 = totalA10/totalSpam;
		int notSpamGivenA10 = totalA10/totalNotSpam;
		int spamGivenNotA10 = totalNotA10/totalSpam;
		int notSpamGivenNotA10 = totalNotA10/totalNotSpam;
		probabilityTable[19][0] = spamGivenA10; //P(Attribute 10 | Class) = Spam
		probabilityTable[19][1] = notSpamGivenA10; //P(Attribute 10 | Class) = Not Spam
		probabilityTable[20][0] = spamGivenNotA10; //P(Not Attribute 10 | Class) = Spam
		probabilityTable[20][1] = notSpamGivenNotA10; //P(Not Attribute 10 | Class) = Not Spam
		
		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][11]==1){
				totalA11++;
			}
			else if(labelled[x][11]==0){
				totalNotA11++;
			}
		}
		int spamGivenA11 = totalA11/totalSpam;
		int notSpamGivenA11 = totalA11/totalNotSpam;
		int spamGivenNotA11 = totalNotA11/totalSpam;
		int notSpamGivenNotA11 = totalNotA11/totalNotSpam;
		probabilityTable[21][0] = spamGivenA11; //P(Attribute 11 | Class) = Spam
		probabilityTable[21][1] = notSpamGivenA11; //P(Attribute 11 | Class) = Not Spam
		probabilityTable[22][0] = spamGivenNotA11; //P(Not Attribute 11 | Class) = Spam
		probabilityTable[22][1] = notSpamGivenNotA11; //P(Not Attribute 11 | Class) = Not Spam

		for(int x = 0;x<labelled.length;x++){
			if(labelled[x][12]==1){
				totalA12++;
			}
			else if(labelled[x][12]==0){
				totalNotA12++;
			}
		}
		int spamGivenA12 = totalA12/totalSpam;
		int notSpamGivenA12 = totalA12/totalNotSpam;
		int spamGivenNotA12 = totalNotA12/totalSpam;
		int notSpamGivenNotA12 = totalNotA12/totalNotSpam;
		probabilityTable[23][0] = spamGivenA12; //P(Attribute 12 | Class) = Spam
		probabilityTable[23][1] = notSpamGivenA12; //P(Attribute 12 | Class) = Not Spam
		probabilityTable[24][0] = spamGivenNotA12; //P(Not Attribute 12 | Class) = Spam
		probabilityTable[24][1] = notSpamGivenNotA12; //P(Not Attribute 12 | Class) = Not Spam
	}
	
	public static void nativeBayes(){
		
	}

}

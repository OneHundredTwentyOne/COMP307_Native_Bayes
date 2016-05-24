import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PartOne {
	static int[][] labelled = new int[200][13];
	static double[][] probabilityTable = new double [25][2];
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
		double totalSpam = 1; //Small constant to account for zero counts
		double totalNotSpam = 1;
		double totalA1 = 1;
		double totalNotA1 = 1;
		double totalA2 = 1;
		double totalNotA2 = 1;
		double totalA3 = 1;
		double totalNotA3 = 1;
		double totalA4 = 1;
		double totalNotA4 = 1;
		double totalA5 = 1;
		double totalNotA5 = 1;
		double totalA6 = 1;
		double totalNotA6 = 1;
		double totalA7 = 1;
		double totalNotA7 = 1;
		double totalA8 = 1;
		double totalNotA8 = 1;
		double totalA9 = 1;
		double totalNotA9 = 1;
		double totalA10 = 1;
		double totalNotA10 = 1;
		double totalA11 = 1;
		double totalNotA11 = 1;
		double totalA12 = 1;
		double totalNotA12 = 1;
		
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
		double spamGivenA1 = totalA1/totalSpam;
		double notSpamGivenA1 = totalA1/totalNotSpam;
		double spamGivenNotA1 = totalNotA1/totalSpam;
		double notSpamGivenNotA1 = totalNotA1/totalNotSpam;
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
		double spamGivenA2 = totalA2/totalSpam;
		double notSpamGivenA2 = totalA2/totalNotSpam;
		double spamGivenNotA2 = totalNotA2/totalSpam;
		double notSpamGivenNotA2 = totalNotA2/totalNotSpam;
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
		double spamGivenA3 = totalA3/totalSpam;
		double notSpamGivenA3 = totalA3/totalNotSpam;
		double spamGivenNotA3 = totalNotA3/totalSpam;
		double notSpamGivenNotA3 = totalNotA3/totalNotSpam;
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
		double spamGivenA4 = totalA4/totalSpam;
		double notSpamGivenA4 = totalA4/totalNotSpam;
		double spamGivenNotA4 = totalNotA4/totalSpam;
		double notSpamGivenNotA4 = totalNotA4/totalNotSpam;
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
		double spamGivenA5 = totalA5/totalSpam;
		double notSpamGivenA5 = totalA5/totalNotSpam;
		double spamGivenNotA5 = totalNotA5/totalSpam;
		double notSpamGivenNotA5 = totalNotA5/totalNotSpam;
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
		double spamGivenA6 = totalA6/totalSpam;
		double notSpamGivenA6 = totalA6/totalNotSpam;
		double spamGivenNotA6 = totalNotA6/totalSpam;
		double notSpamGivenNotA6 = totalNotA6/totalNotSpam;
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
		double spamGivenA7 = totalA7/totalSpam;
		double notSpamGivenA7 = totalA7/totalNotSpam;
		double spamGivenNotA7 = totalNotA7/totalSpam;
		double notSpamGivenNotA7 = totalNotA7/totalNotSpam;
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
		double spamGivenA8 = totalA8/totalSpam;
		double notSpamGivenA8 = totalA8/totalNotSpam;
		double spamGivenNotA8 = totalNotA8/totalSpam;
		double notSpamGivenNotA8 = totalNotA8/totalNotSpam;
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
		double spamGivenA9 = totalA9/totalSpam;
		double notSpamGivenA9 = totalA9/totalNotSpam;
		double spamGivenNotA9 = totalNotA9/totalSpam;
		double notSpamGivenNotA9 = totalNotA9/totalNotSpam;
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
		double spamGivenA10 = totalA10/totalSpam;
		double notSpamGivenA10 = totalA10/totalNotSpam;
		double spamGivenNotA10 = totalNotA10/totalSpam;
		double notSpamGivenNotA10 = totalNotA10/totalNotSpam;
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
		double spamGivenA11 = totalA11/totalSpam;
		double notSpamGivenA11 = totalA11/totalNotSpam;
		double spamGivenNotA11 = totalNotA11/totalSpam;
		double notSpamGivenNotA11 = totalNotA11/totalNotSpam;
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
		double spamGivenA12 = totalA12/totalSpam;
		double notSpamGivenA12 = totalA12/totalNotSpam;
		double spamGivenNotA12 = totalNotA12/totalSpam;
		double notSpamGivenNotA12 = totalNotA12/totalNotSpam;
		probabilityTable[23][0] = spamGivenA12; //P(Attribute 12 | Class) = Spam
		probabilityTable[23][1] = notSpamGivenA12; //P(Attribute 12 | Class) = Not Spam
		probabilityTable[24][0] = spamGivenNotA12; //P(Not Attribute 12 | Class) = Spam
		probabilityTable[24][1] = notSpamGivenNotA12; //P(Not Attribute 12 | Class) = Not Spam
	}
	
	public static void nativeBayes(){
		
	}

}

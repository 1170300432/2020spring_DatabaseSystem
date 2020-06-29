package enter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateData{
	
	public static void main(String[] args) {
		int j = 0;
		int k = 1;
		for(int i = 1; i <= 1000000; i++) {
			j++;
			File file = new File("origin/data" + k + ".txt");
			try {
				FileWriter fileWriter = new FileWriter(file, true);
				fileWriter.write(i + ":abcdefghijkl\n");
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(j == 32000) {
				j = 0;
				k++;
			}
		}
	}
	
}
package enter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adt.Data;

public class MessUp{
	
	private static List<Data> datas = new ArrayList<Data>();
	
	public static void main(String[] args) {
		for(int i = 1; i <= 32; i++) {
			File file = new File("origindata/data" + i + ".txt");
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String currStr = null;
				while((currStr = bufferedReader.readLine()) != null) {
					String regex = "(.*):(.*)";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(currStr);
					if(matcher.find()) {
						Data data = new Data(Integer.valueOf(matcher.group(1)), matcher.group(2));
						datas.add(data);
					}
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int j = 0;
		int k = 1;
		Random random = new Random();
		for (int i = 1; i <= 1000000; i++) {
			j++;
			int index = 0;
			if(i != 1000000) {
				index = random.nextInt(1000000 - i);
			}
			File file = new File("messdata/data" + k + ".txt");
			try {
				FileWriter fileWriter = new FileWriter(file, true);
				fileWriter.write(datas.get(index).toString() + "\n");
				datas.remove(index);
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
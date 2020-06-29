package enter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adt.BTree;
import adt.Data;

public class BtreeIndex{
	
	public static void main(String[] args) {
		// Insert
		BTree bTree = new BTree(3);
        for (int i = 0; i < 32; i++) {  
            bTree.insertElem((32000*i+1), ("origindata/data" + (i+1) + ".txt"));
//            System.out.println(bTree);  
        }
        // BTree Search
        System.out.println("Input a key to search:");
        Scanner scanner = new Scanner(System.in);
        String keyString = scanner.nextLine();
        scanner.close();
        System.out.println("------------------------------");
        System.out.println("BTree Search begin.");
        long t1 = System.currentTimeMillis();
        int key = Integer.valueOf(keyString);
        int searchKey = (int)Math.floor(key/32000)*32000+1;
        String textName = bTree.searchValue(searchKey);
        File file = new File(textName);
        List<Data> dataList = new ArrayList<Data>();
        try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String currentString = null;
			while((currentString = bufferedReader.readLine()) != null) {
				String regex = "(.*):(.*)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(currentString);
				if(matcher.find()) {
					Data data = new Data(Integer.valueOf(matcher.group(1)), matcher.group(2));
					dataList.add(data);
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        for(Data data: dataList) {
        	if(data.getKey() == key) {
        		System.out.println("The value is: " + data.getValue());
        		break;
        	}
        }
        long t2 = System.currentTimeMillis();
        System.out.println("BTree Search time cost: " + (t2-t1) + " ms.");
        System.out.println("------------------------------");
        // Normal Search
        System.out.println("Normal Search begin");
        t1 = System.currentTimeMillis();
        boolean flag = false;
        for(int i = 1; i <= 32; i++) {
        	dataList = new ArrayList<Data>();
        	file = new File("origindata/data" + i + ".txt");
        	try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String currentString = null;
				while((currentString = bufferedReader.readLine()) != null) {
					String regex = "(.*):(.*)";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(currentString);
					if(matcher.find()) {
						Data data = new Data(Integer.valueOf(matcher.group(1)), matcher.group(2));
						dataList.add(data);
					}
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	for(Data data: dataList) {
            	if(data.getKey() == key) {
            		System.out.println("The value is: " + data.getValue());
            		flag = true;
            		break;
            	}
            }
        	if(flag == true) {
        		break;
        	}
        }
        t2 = System.currentTimeMillis();
        System.out.println("Normal Search time cost: " + (t2-t1) + " ms.");
	}
	
}
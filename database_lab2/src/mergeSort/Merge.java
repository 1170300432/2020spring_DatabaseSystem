package mergeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adt.Data;


public class Merge{
	
    public static final int blockNUM = 3750;
    private static List<BufferedReader> bReaders = new ArrayList<>();
    private static BufferedWriter bw1;
    private static int blockCount = 0;
    private static int ways = 16;
    
    public static void merge(List<String> filePath, String writePath) {
        try {
            initializeFile(filePath, writePath);
            mergesort();
            fileClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void initializeFile(List<String> filePath, String writePath) {
        int size = filePath.size();
        if (size < 16) {
            System.out.println("****  The number of paths involved in merging sort is less than 16  ****");
            System.exit(0);
        }
        try {
            for(int i =0; i<ways; i++) {
                File file = new File(filePath.get(i));
                BufferedReader reader = new BufferedReader(new FileReader(file));
                bReaders.add(reader);              
            }
            File writeFile = new File(writePath);
            bw1 = new BufferedWriter(new FileWriter(writeFile));   
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    private static void fileClose() {
        try {
            for(int i = 0; i < bReaders.size(); i++) {
                bReaders.get(i).close();
            }        
            bw1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }
    
    private static List<Data> readBlock(BufferedReader br){
        List<Data> datasBlock = new ArrayList<>();
        String currentLine;
        int num = 0;
        String regexString = "(.*):(.*)";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher;
        try {
            while((currentLine = br.readLine()) != null && num < blockNUM) {       
                matcher = pattern.matcher(currentLine);
                if (matcher.find()) {
                    Data newData = new Data(Integer.valueOf(matcher.group(1)), matcher.group(2));
                    datasBlock.add(newData);
                    num ++;
                }
            }    
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datasBlock;
    }
    
    private static boolean writeBlock(BufferedWriter bw, List<Data> dataBlock) {
        int size = dataBlock.size();
        try {
            bw.write("####  block: " + blockCount + "\n");
            for(int i = 0; i<size; i++) {
                bw.write(dataBlock.get(i).toString() + "\n");
            }
            bw.write("\n\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    private static void mergesort() {
        
        int[] dead = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};    
        int writeNum = 0;
        List<List<Data>> lists = new ArrayList<List<Data>>();  
        for(int i =0; i< ways; i++) {
            lists.add(readBlock(bReaders.get(i)));
        }
        List<Data> writeBack = new ArrayList<>();
        int stop = 0;
        while(true){
            int leastKey = 2000000;
            Data leastData = null;
            int leastWay = -1;
            for(int i = 0; i < ways; i++ ) {        
                if (dead[i] == 0) {
                    if (lists.get(i).size()>0 && lists.get(i).get(0).getKey() <= leastKey) {
                        leastKey = lists.get(i).get(0).getKey();
                        leastData = lists.get(i).get(0);
                        leastWay = i;
                   }
                }
            }
            if (leastWay >= 0) {
                writeBack.add(leastData);
                writeNum ++;
                if (writeNum == blockNUM) {
                    writeBlock(bw1, writeBack);
                    System.out.println("Write back " + blockCount + " block.");
                    writeBack = new ArrayList<>();
                    writeNum = 0;
                    blockCount++;
                }
                lists.get(leastWay).remove(0);
                if ( lists.get(leastWay).size() == 0 && dead[leastWay] == 0 ) {
                    List<Data> newblock = readBlock(bReaders.get(leastWay));
                    if (newblock.size() == 0) {
                        dead[leastWay] = 1;
                        System.out.println("Road "+ dead[leastWay] + " is dead.");
                    }else {
                        lists.set(leastWay, newblock);
                        newblock = null;
                    }
                }
            }
            for(int i =0; i< ways; i++) {
                stop = stop + dead[i];
            }
            if (stop >= 16) {
                writeBlock(bw1, writeBack);
                break;
            }else {
                stop = 0;
            }   
        }
    }
}

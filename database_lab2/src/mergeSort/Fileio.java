package mergeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adt.Data;

public class Fileio{
  
    public static List<Data> readFiles(String filePath){
        File dataFile = new File(filePath);
        List<Data> datas = new ArrayList<>();
        
        try {
            String regexString = "(.*):(.*)";
            Pattern pattern = Pattern.compile(regexString);
            Matcher matcher;
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                matcher = pattern.matcher(currentLine);
                if (matcher.find()) {
                    Data newData = new Data(Integer.valueOf(matcher.group(1)), matcher.group(2));
                    datas.add(newData);
                }
            }
            reader.close();          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;       
    }
    
    public static boolean writeData(List<Data> datas, String filePath) {
        File writeFile = new File(filePath);
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(writeFile, false));
            int length = datas.size();
            for(int i = 0; i < length; i++) {
                bWriter.write(datas.get(i).toString() + "\n");
            }
            bWriter.close();
        } catch (Exception e) {          
            e.printStackTrace();
            return false;
        }
        return true;
    }
    

}

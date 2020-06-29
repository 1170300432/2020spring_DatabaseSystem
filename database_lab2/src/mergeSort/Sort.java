package mergeSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import adt.Data;

public class Sort{

    public static void main(String[] args) {
    	
    	Quick("messdata/data1.txt", "messdata/data2.txt", "sortdata/quick1.txt");
        Quick("messdata/data3.txt", "messdata/data4.txt", "sortdata/quick2.txt");
        Quick("messdata/data5.txt", "messdata/data6.txt", "sortdata/quick3.txt");
        Quick("messdata/data7.txt", "messdata/data8.txt", "sortdata/quick4.txt");
        Quick("messdata/data9.txt", "messdata/data10.txt", "sortdata/quick5.txt"); 
        Quick("messdata/data11.txt", "messdata/data12.txt", "sortdata/quick6.txt");
        Quick("messdata/data13.txt", "messdata/data14.txt", "sortdata/quick7.txt");
        Quick("messdata/data15.txt", "messdata/data16.txt", "sortdata/quick8.txt");
        Quick("messdata/data17.txt", "messdata/data18.txt", "sortdata/quick9.txt");
        Quick("messdata/data19.txt", "messdata/data20.txt", "sortdata/quick10.txt");
        Quick("messdata/data21.txt", "messdata/data22.txt", "sortdata/quick11.txt");
        Quick("messdata/data23.txt", "messdata/data24.txt", "sortdata/quick12.txt");
        Quick("messdata/data25.txt", "messdata/data26.txt", "sortdata/quick13.txt");
        Quick("messdata/data27.txt", "messdata/data28.txt", "sortdata/quick14.txt");
        Quick("messdata/data29.txt", "messdata/data30.txt", "sortdata/quick15.txt");
        Quick("messdata/data31.txt", "messdata/data32.txt", "sortdata/quick16.txt");
        List<String> filePath = Arrays.asList("sortdata/quick1.txt", "sortdata/quick2.txt", "sortdata/quick3.txt", 
        		"sortdata/quick4.txt", "sortdata/quick5.txt", "sortdata/quick6.txt", "sortdata/quick7.txt", 
        		"sortdata/quick8.txt", "sortdata/quick9.txt", "sortdata/quick10.txt", "sortdata/quick11.txt", 
        		"sortdata/quick12.txt", "sortdata/quick13.txt", "sortdata/quick14.txt", "sortdata/quick15.txt", 
        		"sortdata/quick16.txt");
        Merge.merge(filePath, "sortdata/mergedata.txt"); 
    }
    
    private static void Quick(String filePath1, String filePath2, String writePath) {
    	List<Data> list1 = Fileio.readFiles(filePath1);
    	List<Data> list2 = Fileio.readFiles(filePath2);
        list1.addAll(list2);
        if (list1 != null) {
            Collections.sort(list1);
        }
        Fileio.writeData(list1, writePath);    
        System.out.println("File " + filePath1 + " and file " + filePath2 + " quicksort complete.");
    }

}

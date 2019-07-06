package readinglargefile;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingLargeFile {

    public static void main(String[] args) throws IOException {
        BufferedReader cursor = null;
        try {
            String fileName = "";
            cursor = new BufferedReader(new FileReader(new File("BTVN-5.txt")));
            Map<String, Integer> statisticsTable = new LinkedHashMap<>();
            try {
                while (true) {
                    String line = cursor.readLine();
                    String[] words = line.toLowerCase().split("\\W+");
                    for (int i = 0; i < words.length; i++) {
                        Integer frequency = statisticsTable.get(words[i]);
                        if (frequency == null) {
                            statisticsTable.put(words[i],1);
                        } else {
                            statisticsTable.put(words[i],1);
                        }
                    }
                }
            } catch (EOFException e) {
                
            }
            TreeSet<Entry<String, Integer>> listWords = (TreeSet<Entry<String, Integer>>) statisticsTable.entrySet();
            Iterator<Entry<String, Integer>> iterator = listWords.iterator();
            while (iterator.hasNext()) {
                Entry<String, Integer> aWord = iterator.next();
                System.out.println(aWord.getKey() + " " + aWord.getValue());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadingLargeFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cursor.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadingLargeFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}

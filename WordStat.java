import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;


public class WordStat {


    public static String getType(char c){
        switch (Character.getType(c)) {
            case Character.DASH_PUNCTUATION:
                return "DASH";
            case Character.CONNECTOR_PUNCTUATION:
                return "Connector";
            case Character.OTHER_PUNCTUATION:
                return "OTHER";
            default:
                return "DEFAULT";
        }
    }

    private static boolean isCorrectPartOfWord(char c){
        return Character.isLetter(c) || c == '\'' || Character.getType(c) == Character.DASH_PUNCTUATION;
    }



    public static void main(String[] args) throws IOException {
        String input = args[0], output = args[1];
        BufferedReader reader =null;
        BufferedWriter writer;
        ArrayList<Pair<String, Integer>> stat = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "utf8"));
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "utf8"));
        try {
            String line;
            int j = 0;
            while((line = reader.readLine()) != null) {
                int i = 0;
                int n = line.length();
                while(i < n)
                {
                    while(i < n && !isCorrectPartOfWord(line.charAt(i)))
                        i++;
                    while (i < n && isCorrectPartOfWord(line.charAt(i)))
                        j++;
                    String curWord = line.substring(i, i+j);
                    j = 0;
                    curWord = curWord.toLowerCase();
                    boolean find = false;
                    for(int k = 0; k < stat.size(); k++) {
                        Pair<String, Integer> t = stat.get(k);
                        if(curWord.equals(t.getKey())){
                            find = true;
                            stat.set(k, new Pair<>(curWord, t.getValue() + 1));
                        }
                    }
                    if(!find)
                        stat.add(new Pair<String, Integer>(curWord, 1));
                }
            }
            StringBuilder result = new StringBuilder();
            for(Pair<String, Integer> t: stat){
                result.append(t.getKey()).append(" ").append(t.getValue()).append("\n");
            }
            writer.write(result.toString());
        }finally {
            reader.close();
            writer.close();
        }


    }


    }



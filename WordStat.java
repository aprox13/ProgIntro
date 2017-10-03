import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.util.ArrayList;


public class WordStatWords {

	
	public static Comparator<Pair<String, Integer>> pairComparator = new Comparator<Pair<String, Integer>>(){
		public int compare(Pair<String, Integer> first, Pair<String, Integer> second) {
				return first.getKey().compareTo(second.getKey());
		}
		
	};

    private static boolean isCorrectPartOfWord(char c){
        return Character.isLetter(c) || c == '\'' || Character.getType(c) == Character.DASH_PUNCTUATION;
    }
	
	
	private static String getSortedResult(ArrayList<Pair<String, Integer>> base){
		Collections.sort(base, pairComparator);
		StringBuilder result = new StringBuilder();
        for(Pair<String, Integer> t: base){
            result.append(t.getKey()).append(" ").append(t.getValue()).append("\n");
		}
		return result.toString();
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
            /*StringBuilder result = new StringBuilder();
            for(Pair<String, Integer> t: stat){
                result.append(t.getKey()).append(" ").append(t.getValue()).append("\n");
            }*/
			writer.write(getSortedResult(stat));
        }finally {
            reader.close();
            writer.close();
        }


    }


    }



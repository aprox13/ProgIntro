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



    public static void main(String[] args) {
		try{
			String input = args[0], output = args[1];
			ArrayList<Pair<String, Integer>> stat = new ArrayList<>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "utf8"));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "utf8"));
			try {
				String line;
				while((line = reader.readLine()) != null) {
					int i = 0;
					int n = line.length();
					while(i < n)
					{
						while(i < n && !isCorrectPartOfWord(line.charAt(i))) {
							i++;
						}
						int begin = i;
						while (i < n && isCorrectPartOfWord(line.charAt(i))) {
							i++;
						}
						if(begin != i) {
							String curWord = line.substring(begin, i);
							curWord = curWord.toLowerCase();
							boolean find = false;
							for(int k = 0; k < stat.size(); k++) {
								Pair<String, Integer> t = stat.get(k);
								if(curWord.equals(t.getKey())){
									find = true;
									stat.set(k, new Pair<>(curWord, t.getValue() + 1));
								}
							}
							if(!find) {
								stat.add(new Pair<String, Integer>(curWord, 1));
							}
						}
					}
				}
				writer.write(getSortedResult(stat));
			}finally {
				try {
					reader.close();
				} catch (IOException e) {
					
				}
				try {
					writer.close();
				} catch (IOException e) {
					;
				}
				
			}
		} catch(IOException e) {
			;
		}


    }


    }



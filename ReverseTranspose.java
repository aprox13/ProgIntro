import java.util.ArrayList;
import java.util.Scanner;


public class ReverseTranspose {

    public static void main(String[] args) {
        int n = 0, m = 1;
        List<ArrayList<Integer>> rows = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            List<Integer> line = new ArrayList<>();
            Scanner currentLine = new Scanner(in.nextLine());
            while (currentLine.hasNextInt()) {
                line.add(currentLine.nextInt());
			}
            if(m < line.size()) { 
                m = line.size();
			}
            rows.add(line);
            n++;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(rows.size() > j) {
                    if(rows.get(j).size() > i) {
                        System.out.print(rows.get(j).get(i) + " ");
					}
				}
            }
            System.out.println();
        }
    }
}

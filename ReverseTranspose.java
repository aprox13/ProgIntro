import java.util.ArrayList;
import java.util.Scanner;


public class ReverseTranspose {

    public static void main(String[] args)
    {
        int n = 0, m = 1;

        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            ArrayList<Integer> line = new ArrayList<>();
            Scanner currentLine = new Scanner(in.nextLine());
            while (currentLine.hasNextInt())
                line.add(currentLine.nextInt());
            if(m < line.size())
                m = line.size();
            rows.add(line);
            n++;
        }
       /* n = 2; m = 2;
        rows.clear();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        rows.add(tmp);
        tmp.set(0, 3);
        tmp.remove(tmp.size() - 1);
        */
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(rows.size() > j)
                    if(rows.get(j).size() > i)
                        System.out.print(rows.get(j).get(i) + " ");
            }
            System.out.println();
        }
    }
}

import java.lang.StringBuilder;
import java.util.*;
import java.io.FileWriter;

public class Reverse{	
	public static void main(String[] args){
		ArrayList<String> answer = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		String save = "";
		while(in.hasNextLine())
			answer.add(in.nextLine());
		for(int i = answer.size() - 1; i > -1; i--)
		{
			String[] tmp = answer.get(i).split(" ");
			for(int j = tmp.length - 1; j > -1; j--)
				System.out.print(tmp[j] + " ");
			System.out.println();
			
		}
	}
}
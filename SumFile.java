import java.io.*;
import java.util.Scanner;

/**
 * Created by Роман on 01.10.2017.
 */
public class SumFile {



    public static void main(String[] args) throws IOException {
        String inp = args[0], out = args[1];
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inp), "utf8"));
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), "utf8"));
            try {
                String line = "";
                int sum = 0;
                while ((line = reader.readLine()) != null) {
                    Scanner lineScanner = new Scanner(line);
                    while (lineScanner.hasNextInt())
                        sum += lineScanner.nextInt();
                }
                writer.write(sum);
                writer.flush();
                writer.close();
                reader.close();
            }finally {
                writer.close();
            }
        }finally {
            reader.close();
        }
    }
}

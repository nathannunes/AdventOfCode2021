package day3_2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class P1 {
    public static void main(String[] args) {
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("day3_2022/test.txt"));
			String line = reader.readLine();
			int score = 0;
			while (line != null) {
				ArrayList<Character> seenValues = new ArrayList<Character>();
				char[] rag = line.toCharArray();
				char[] first = Arrays.copyOfRange(rag, 0, (rag.length/2) );
				char[] secnd = Arrays.copyOfRange(rag, (rag.length/2), rag.length );
				for (char ch : first) {
					if(new String(secnd).contains(String.valueOf(ch)) && !seenValues.contains(ch)){
						seenValues.add(ch);
						if(Character.isLowerCase(ch)){
							score += (int)ch - 96;
						}else{
							score += (int)ch- 38;
						}
					}
				}
				// read next line
				line = reader.readLine();
			}
			System.out.println("\n"+score);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

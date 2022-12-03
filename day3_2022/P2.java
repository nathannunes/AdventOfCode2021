package day3_2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class P2 {
    public static void main(String[] args) {
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("day3_2022/p1.txt"));
			String line = reader.readLine();
			String line2 = reader.readLine();
			String line3 = reader.readLine();
			int score = 0;
			while (line != null) {
				ArrayList<Character> seenValues = new ArrayList<Character>();
				char[] rag = line.toCharArray();
				for (char ch : rag) {
					if(line2.contains(String.valueOf(ch)) && line3.contains(String.valueOf(ch)) 
					&& !seenValues.contains(ch)){
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
				line2 = reader.readLine();
				line3 = reader.readLine();
			}
			System.out.println("\n"+score);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

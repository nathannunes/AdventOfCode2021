package day2_2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class P1 {
    public static void main(String[] args) {
		HashMap<String, String[]> pairs = new HashMap<String,String[]>() {{
			put("A", new String[]{"X","Y", "2"});
			put("B", new String[]{"Y","Z", "3"});
			put("C", new String[]{"Z","X", "1"});
		}};
		HashMap<String,Integer> points = new HashMap<>(){{
			put("Y", 2);
			put("Z", 3);
			put("X", 1);
		}};
        BufferedReader reader;
		int score = 0;
		try {
			reader = new BufferedReader(new FileReader("day2_2022/p1.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] input = line.split(" ");
				if(pairs.get(input[0])[1].equals(input[1])){
					score += 6;
				}else if(pairs.get(input[0])[0].equals(input[1])){
					score += 3;
				}
				score += points.get(input[1]);
				// read next line
				line = reader.readLine();
			}
			System.out.println(score);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

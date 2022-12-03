package day2_2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class P2 {
    public static void main(String[] args) {
		HashMap<String, String[]> pairs = new HashMap<String,String[]>() {{
            // Opponent Value : {Draw Value , Win Value , Lose Value}
			put("A", new String[]{"X","Y","Z"});
			put("B", new String[]{"Y","Z","X"});
			put("C", new String[]{"Z","X","Y"});
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
                
                // For the Win/Draw
				if(input[1].equals("Z")){
					score += 6;
                    score += points.get(pairs.get(input[0])[1]);

				}else if(input[1].equals("Y")){
					score += 3;
                    score += points.get(pairs.get(input[0])[0]);
				}else{
                    score += points.get(pairs.get(input[0])[2]);
                }

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

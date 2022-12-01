package day1_2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class P2 {
    public static void main(String[] args) {
        Set<Integer> calorieArr = new TreeSet<>(Comparator.reverseOrder());
        var localCalorie = 0;
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("day1_2022/p1.txt"));
			var line = reader.readLine();
			while (line != null) {
				if(!line.isEmpty()){
					localCalorie += Integer.valueOf(line);
				}else{
					calorieArr.add(localCalorie);
					localCalorie = 0;
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
            var arr = calorieArr.stream().limit(3).mapToInt(Integer :: intValue).sum();
			System.out.println("Max calorie is : " + arr);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}

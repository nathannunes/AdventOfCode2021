package day1_2022;
import java.io.*;

class P1{
    public static void main(String[] args) {
        long maxCalorie = 0, localCalorie = 0;
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("day1_2022/p1.txt"));
			String line = reader.readLine();
			while (line != null) {
				if(!line.isEmpty()){
					localCalorie += Integer.valueOf(line);
				}else{
					maxCalorie = localCalorie > maxCalorie? localCalorie : maxCalorie;
					localCalorie = 0;
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
			System.out.println("Max calorie is : " + maxCalorie);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
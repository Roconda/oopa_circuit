package nl.avans.oopa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 * 
 */
public class App {


	public static void main(String[] args) {

		if(args.length == 1){
			// read text file
			String name = args[0];
			File f = new File (name);
			BufferedReader br = null;

			try {
				FileReader fr = new FileReader(f);
				br = new BufferedReader(fr);
				String output;

				while ( (output = br.readLine()) != null) {
					System.out.println(output);
				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("Unable to read file");
			}

			System.exit(0);
		}else System.out.println("Available arguments: <text file>");

		// Gone wrong
		System.exit(1);

	}
}

package nl.avans.oopa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import nl.avans.oopa.model.Factory;
import nl.avans.oopa.model.Node;

public class App {

	public static void main(String[] args) {
		Node uselessNode = Factory.create("AND"); // hack

		if (args.length == 1) {
			// read text file
			String name = args[0];
			// IO vars
			File f = new File(name);
			BufferedReader br = null;

			try {
				// IO vars
				FileReader fr = new FileReader(f);
				br = new BufferedReader(fr);
				String output;

				while ((output = br.readLine()) != null) {					
					Parser.parse(output);
				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
				System.exit(2);
			} catch (IOException e) {
				System.out.println("Unable to read file");
				System.exit(3);
			}

			System.exit(0);
		} else
			System.out.println("Available arguments: <text file>");

		// Gone wrong
		System.exit(1);

	}

}

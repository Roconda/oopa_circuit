package nl.avans.oopa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import nl.avans.oopa.model.Factory;
import nl.avans.oopa.model.Node;

public class App {


	public static void main(String[] args) {
		Map<String, Node> map = new HashMap<String, Node>();
		boolean isNew = true;

		if(args.length == 1){
			// read text file
			String name = args[0];
			// IO vars
			File f = new File (name);
			BufferedReader br = null;

			try {
				// IO vars
				FileReader fr = new FileReader(f);
				br = new BufferedReader(fr);
				String output;

				while ( (output = br.readLine()) != null) {					
					String[] commands = output.split("\\s+"); // remove spaces
					String identifier = ""; // identifier / variable
					Node linkNode;
					
					for(String command : commands) {
						if(command.contains("#")) break; // ignore comments
						
						// New line
						if(isNew) {
							if(map.get(command) == null) {
								// create node identifier
								identifier = command.replace(":", "");
								isNew = false;
							}else{
								System.out.println("Could not find identifier: " + command.replace(":", ""));
								break;
							}
						}else{
							// link nodes
							// TODO: split on ','
							if(command.contains(";")) {
								// initiate node
								map.put(identifier, Factory.create(command.replace(";", "")));
								System.out.println("+"+command.replace(";", "")+"+");
								isNew = false;
							}
						}
						
						
						System.out.println(command);
					}
				}

			}catch (FileNotFoundException e) {
				System.out.println("File not found");
				System.exit(2);
			}catch (IOException e) {
				System.out.println("Unable to read file");
				System.exit(3);
			}

			System.exit(0);
		}else System.out.println("Available arguments: <text file>");

		// Gone wrong
		System.exit(1);

	}
}

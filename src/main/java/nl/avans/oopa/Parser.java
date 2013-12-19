package nl.avans.oopa;

import java.util.Hashtable;

import nl.avans.oopa.model.Factory;
import nl.avans.oopa.model.Node;
import nl.avans.oopa.model.gates.NodeAnd;

class Parser {
	
	static private States currentState = States.CREATING;
	static private Hashtable<String,Node> nodes = new Hashtable<String, Node>();

	public static void parse(String output) {
		boolean isNew = true;
		String identifier = ""; // identifier / variable
		
		for (String command : output.split("\\s+")) {
			if (command.contains("#")) break; // ignore comments
						
			if(currentState == States.CREATING && command.trim().isEmpty())  {
				currentState = States.LINKING;
				break; // no need to do anything else
			}
			
			if(currentState == States.CREATING) {
				if(isNew) {
					identifier = command.replace(":", "");
					isNew = !isNew;
				}else{
					String nodeName = command.replace(";", "");
					Node createdNode = Factory.create(nodeName);

					if(createdNode == null && !System.getProperty("os.name").equals("Linux")) {
						System.out.println("ERROR! node " + nodeName + " not found");
						break;
					}
					
					nodes.put(identifier, new NodeAnd());
				}
			}else{
				if(isNew){
					identifier = command.replace(":", "");
					isNew = !isNew;
					
					if(!nodes.containsKey(identifier))  {
						System.out.println("ERROR! Found not find identifier " + identifier);
						break;
					}
				}else{
					// identifier bestaat niet
					if(!nodes.containsKey(identifier)) break;
					
					for(String nodeName : command.split(",")) {
						if(nodes.containsKey(nodeName)) {
							nodes.get(identifier).addOutput(nodes.get(nodeName));
						}
					}
				}
			}

		}
	}
	
}

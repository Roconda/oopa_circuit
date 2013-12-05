package nl.avans.oopa.model;
import java.util.Hashtable;
import nl.avans.oopa.model.Node;

public class Factory {
	
	private Hashtable<String,Node> nodes;
	private static Factory instance;

	private Factory(){
		nodes = new Hashtable<String, Node>();
	}
	
	public static Node create(String id){
		return null;
	}
	
	private static Factory instance(){
		if(instance == null){
			instance = new Factory();
		}
		return instance;
	}
	
	public static void assing(String ID, Node node){
		instance().nodes.put(ID, node);
	}

}

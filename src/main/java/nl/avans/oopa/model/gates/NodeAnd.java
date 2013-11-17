package nl.avans.oopa.model.gates;
import nl.avans.oopa.model.Node;

public class NodeAnd extends Node {

	public NodeAnd() {
		super();
	}
	
	@Override
	protected void execute(){
		for(Node n : inputs){
			//if even one input is false, AND returns false.
			if(!n.getResult()){
				result = false;
				return;
			}
		}
		result = true;
	}
}

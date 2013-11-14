package nl.avans.oopa.model.gates;
import nl.avans.oopa.model.Node;

public class NodeAnd extends Node {

	public NodeAnd(int inputs) {
		super(inputs);
	}
	
	@Override
	protected void execute(){
		for(int i = 0; i < inputs.length; i++){
			//if even one input is false, AND returns false.
			if(!inputs[i]){
				result = false;
				return;
			}
		}
		result = true;
	}
}

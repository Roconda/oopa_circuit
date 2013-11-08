package model.gates;
import model.Node;

public class NodeAnd extends Node {

	public NodeAnd(int inputs, int outputs) {
		super(inputs, outputs);
	}
	
	@Override
	protected void execute(){
		for(int i = 0; i < inputs.length; i++){
			//if even one result is false, AND returns false.
			if(!inputs[i]){
				result = false;
				return;
			}
		}
		result = true;
	}
}

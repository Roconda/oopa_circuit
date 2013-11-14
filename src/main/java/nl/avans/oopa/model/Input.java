package nl.avans.oopa.model;

import java.util.Stack;

public class Input {

	private boolean value;
	private Stack<Node> outputs;
	
	public Input(boolean value, int outputs){
		this.value = value;
		this.outputs = new Stack<Node>();
	}
	
	public void addOutput(Node node){
		outputs.push(node);
	}
	
	public void start(){
		while(!outputs.isEmpty()){
			outputs.pop().addInput(value);
		}
	}
}

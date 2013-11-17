package nl.avans.oopa.model;

import java.util.ArrayList;

public class Node {
	
	protected ArrayList<Node> inputs;
	protected ArrayList<Node> outputs;
	protected boolean result = false;
	
	public Node(){
		this.inputs = new ArrayList<Node>();
		this.outputs = new ArrayList<Node>();
	}
	
	public void addInput(Node input){
		inputs.add(input);
		onInputChange();
	}
	
	public void addOutput(Node node){
		outputs.add(node);
		node.addInput(this);
	}
	
	public void onInputChange(){
		execute();
		distributeResult();
	}
	
	protected void execute(){
		//The default node will always return false, just because...
		result = false;
	}
	
	protected void distributeResult(){
		for(Node n : outputs){
			n.onInputChange();
		}
	}
	
	public boolean getResult(){
		return result;
	}
}

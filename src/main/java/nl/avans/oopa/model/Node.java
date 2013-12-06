package nl.avans.oopa.model;

import java.util.ArrayList;

public abstract class Node {
	
	private ArrayList<Node> inputs;
	private ArrayList<Node> outputs;
	private boolean result = false; //false is default output if execute can't be ran.
	private int neededInputs = 2;
	
	public abstract boolean execute(ArrayList<Node> inputs);
	public abstract Node copy();
	
	public Node(){
		this.inputs = new ArrayList<Node>();
		this.outputs = new ArrayList<Node>();
	}
	
	public Node(String id){
		Factory.assing(id, this);
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
		if(inputs.size() >= neededInputs)
		{
			result = execute(inputs);
			distributeResult();
		}
	}
	
	protected void distributeResult(){
		for(Node n : outputs){
			n.onInputChange();
		}
	}
	
	public boolean getResult(){
		return result;
	}
	
	public void setResult(boolean result){ //used to hard set the result, mainly used by Input
		this.result = result;
	}
	
	public void setNeededInputs(int inputs){
		neededInputs = inputs;
	}
}

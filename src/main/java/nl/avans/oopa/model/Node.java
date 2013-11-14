package nl.avans.oopa.model;

import java.util.Stack;

public class Node {
	
	protected boolean[] inputs;
	protected Stack<Node> outputs;
	private int inputCounter = 0;
	protected boolean result = false;
	
	public Node(int inputs){
		this.inputs = new boolean[inputs];
		this.outputs = new Stack<Node>();
	}
	
	public void addInput(boolean input){
		if (inputCounter < inputs.length){
			inputs[inputCounter] = input;
			inputCounter++;
			if(inputCounter == inputs.length){
				execute();
				distributeResult();
			}
		}
	}
	
	public void addOutput(Node node){
		outputs.push(node);
	}
	
	protected void execute(){
		//The default node will always return true, just because...
		result = true;
	}
	
	protected void distributeResult(){
		while(!outputs.isEmpty()){
			outputs.pop().addInput(result);
		}
	}
	
	public boolean getResult(){
		return result;
	}
}

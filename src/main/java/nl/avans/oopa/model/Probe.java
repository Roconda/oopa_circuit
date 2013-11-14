package nl.avans.oopa.model;

public class Probe extends Node {

	public Probe() {
		super(1);
	}
	
	@Override
	public void addInput(boolean input){
		result = input;
	}

}

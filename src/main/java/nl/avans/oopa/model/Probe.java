package nl.avans.oopa.model;

public class Probe extends Node {

	public Probe() {
		super();
	}
	
	@Override
	protected void execute(){
		result = inputs.get(0).getResult();
	}

}

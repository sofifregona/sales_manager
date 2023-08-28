package pps.mng.exception;

public class Excep extends Exception{

	private static final long serialVersionUID = 3941221036411842318L;

	private  String atribute;
	
	public Excep() {
		super();
	}
	public Excep(String message) {
		super(message);
	}
	public Excep(String message, String atribute) {
		super(message);
		this.atribute = atribute;
	}

	public String getAtribute() {
		return atribute;
	}
	public void setAtribute(String atribute) {
		this.atribute = atribute;
	}
}
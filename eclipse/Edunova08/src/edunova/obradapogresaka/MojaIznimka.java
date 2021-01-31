package edunova.obradapogresaka;

public class MojaIznimka extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String poruka;

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}
	
}

package pruebaCCAA.entities;

public class Provincia {
	
//	String id;  // No lo vamos a mostrar en este caso.
	String parentCode;
	String code;
	String label;
	
	
	public Provincia() {
		super();
	}


	
	
//	public String getId() {
//		return id;
//	}
//
//
//	public void setId(String id) {
//		this.id = id;
//	}

	

	public String getParentCode() {
		return parentCode;
	}


	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
	
}

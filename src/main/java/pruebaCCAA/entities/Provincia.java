package pruebaCCAA.entities;

public class Provincia {
	
	String _id;
	String parent_code;
	String code;
	String label;
	
	
	public Provincia() {
		super();
	}


	
	
	public String get_Id() {
		return _id;
	}


	public void set_Id(String _id) {
		this._id = _id;
	}


	public String getParent_code() {
		return parent_code;
	}


	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
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

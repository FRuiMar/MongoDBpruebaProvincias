package pruebaCCAA.controllers;

public class ControladorProvinciasMongo extends SuperControladorMongoDb {

	
	private static ControladorProvinciasMongo instance = null;
	
	public ControladorProvinciasMongo() {
		super("localhost","ComunidadesProvinciasPoblaciones", "provincias");
		
	}

	
	public static ControladorProvinciasMongo getInstance() {
		if(instance == null) {
			instance = new ControladorProvinciasMongo();
		}
		return null;
	}
	
	
	
}

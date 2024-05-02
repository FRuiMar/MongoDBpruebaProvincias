package pruebaCCAA.controllers;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import pruebaCCAA.entities.ComunidadAutonoma;
import pruebaCCAA.entities.Provincia;


public class ControladorProvinciasMongo{

	private String collName = "provincias";  //Nombre de la colección (sería la tabla).
	private MongoCollection<Document> collecDoc = null;
	private String hostName = "localhost";
	private String dBName = "ComunidadesProvinciasPoblaciones"; //Nombre de la base de datos.
	private int port = 27017;

	
	private static ControladorProvinciasMongo instance = null;
	
	
	// lo creo sin super controlador porque ha dicho Rafa que lo hagamos sin superclases, 
	// que para este ejemplo no hace falta. 
	// RECUERDA CUANDO TERMINES REHACERLO CON SUPER CONTROLADOR Y SUPERENTIDAD
//	public ControladorProvinciasMongo() {
//		super("localhost","ComunidadesProvinciasPoblaciones", "provincias");
//		
//	}

	
	public ControladorProvinciasMongo() {
			super();
}
	
	
	
	public static ControladorProvinciasMongo getInstance() {
		if(instance == null) {
			instance = new ControladorProvinciasMongo();
		}
		return instance;
	}
	
	
	
	
	/**
	 * Obtenemos una colección de la base de datos
	 * Viene a ser la lista completa de los objetos de una tabla en jpa.
	 * Cada documento es un objeto.
	 * @return Colección.
	 */
	private MongoCollection<Document> getCollection() {
		if (collecDoc == null) {
			// Mongodb creando la cadena de conexión.
	        String client_url = "mongodb://" + hostName + ":" + port + "/" + dBName;
	        MongoClientURI uri = new MongoClientURI(client_url);
	 
	        // Conectando y obteniendo un cliente.
	        MongoClient mongo_client = new MongoClient(uri);
	 
	        // Obteniendo un enlace a la base de datos.
	        MongoDatabase db = mongo_client.getDatabase(dBName);
	 
	        // Obteniendo la colección de la base de datos
	        return collecDoc = db.getCollection(collName);
		}
		return collecDoc;
	}
	
	
	
	
	
	
	
	
	
	
	
	  /**
     * Obtiene todos los elementos de la colección ccaa.
     * PERO EN ESTE CASO EN UNA LISTA PARAMETRIZADA 
     * CON LA ENTIDAD CORRESPONDIENTE.
     * @return Lista parametrizada Provincias.
     */
    public List<Provincia> getAllProvincias() {
       
    	MongoCollection<Document> collProvincias = getCollection();
    	
    	
        // Performing a read operation on the collection.
        FindIterable<Document> fi = collProvincias.find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Provincia> allProvincias = new ArrayList<Provincia>();
        try {
            while(cursor.hasNext()) {
            	allProvincias.add(documentToProvincia(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        
        return allProvincias;
    }
	
    
    
    /**
     * Creamos objetos CCAA a partir de los documentos (cada documento es un objeto)
     * Rafa lo ha usado para pasar de una colección de documentos
     * a una lista de objetos 
     * @param doc
     * @return
     */
    private static Provincia documentToProvincia(Document doc) {
    	Provincia provincia = new Provincia();
    	provincia.setParentCode(doc.getString("parent_code"));
    	provincia.setCode(doc.getString("code"));
    	provincia.setLabel(doc.getString("label"));
    	return provincia;
    }
    
	
    
    
    /**
	 * Actualizamos el nombre de la comunidad o el parentCode.
	 * @param p
	 */
	public void updateProvincia(Provincia pr) {
		try {
			Document query = new Document()
					.append("code", pr.getCode());
			
			Bson update = Updates.combine(
					Updates.set("label", pr.getLabel()),
					Updates.set("parent_code", pr.getParentCode())
			);
			
			getCollection().updateOne(query, update);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
     
}

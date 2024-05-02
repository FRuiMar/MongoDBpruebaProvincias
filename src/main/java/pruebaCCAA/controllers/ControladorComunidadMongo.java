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
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import pruebaCCAA.entities.ComunidadAutonoma;


public class ControladorComunidadMongo {

	private String collName = "ccaa";  //Nombre de la colección (sería la tabla).
	private MongoCollection<Document> collecDoc = null;
	private String hostName = "localhost";
	private String dBName = "ComunidadesProvinciasPoblaciones";
	private int port = 27017;

	
	private static ControladorComunidadMongo instance = null;
	
	
	//Para el futuro, ha dicho Rafa de no usar superControlador y superEntidad, repetimos codigo
	// Cuando termine hacerlo con supercontrolador también. 
//	public ControladorComunidadMongo() {
//		super("localhost","ComunidadesProvinciasPoblaciones", "ccaa");
//		
//	}

	
	public ControladorComunidadMongo() {
		super();
		
	}
	
	
	public static ControladorComunidadMongo getInstance() {
		if(instance == null) {
			instance = new ControladorComunidadMongo();
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
     * @return Lista parametrizada Comunidades Autónomas.
     */
    public List<ComunidadAutonoma> getAllCcaa() {
    	
    	MongoCollection<Document> collCcaa = getCollection();
    	
        // Performing a read operation on the collection.
        FindIterable<Document> fi = collCcaa.find();
        MongoCursor<Document> cursor = fi.iterator();

        List<ComunidadAutonoma> allCcaa = new ArrayList<ComunidadAutonoma>();
        try {
            while(cursor.hasNext()) {
            	allCcaa.add(documentToCcaa(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        
        return allCcaa;
    }
	
	
	
    /**
     * Creamos objetos Comun. Autónoma a partir de los documentos 
     * (cada documento es un objeto)
     * Rafa lo ha usado para pasar de una colección de documentos
     * a una lista de objetos 
     * @param doc
     * @return
     */
    private static ComunidadAutonoma documentToCcaa(Document doc) {
    	ComunidadAutonoma ccaa = new ComunidadAutonoma();
    	ccaa.setParentCode(doc.getString("parent_code"));
    	ccaa.setCode(doc.getString("code"));
    	ccaa.setLabel(doc.getString("label"));
    	return ccaa;
    }
	


    
    
    /**
	 * Actualizamos el nombre de la comunidad o el parentCode.
	 * @param p
	 */
	public void updateComunidad(ComunidadAutonoma ccaa) {
		try {
			Document query = new Document()
					.append("code", ccaa.getCode());
			
			Bson update = Updates.combine(
					Updates.set("label", ccaa.getLabel()),
					Updates.set("parent_code", ccaa.getParentCode())
			);
			
			getCollection().updateOne(query, update);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    // Al usar las listas, no vamos a usar esto de momento. 
//
//	// Filtrar documentos dentro de una colección.
//    private static void getCcaaByID(MongoCollection<Document> col, String code) {
//    	
//    	System.out.println("Filtrando elementos de una colección");
// 
//        // Performing a read operation on the collection.
//        FindIterable<Document> fi = col.find(Filters.eq("code", code));        
//        MongoCursor<Document> cursor = fi.iterator();
//        try {
//            while(cursor.hasNext()) {
//            	System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }
//    }
    
    
    
    
    
    
    
    
}

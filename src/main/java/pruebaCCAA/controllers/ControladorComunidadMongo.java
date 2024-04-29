package pruebaCCAA.controllers;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import pruebaCCAA.entities.ComunidadAutonoma;


public class ControladorComunidadMongo extends SuperControladorMongoDb{

	
	private static ControladorComunidadMongo instance = null;
	
	public ControladorComunidadMongo() {
		super("localhost","ComunidadesProvinciasPoblaciones", "ccaa");
		
	}

	
	public static ControladorComunidadMongo getInstance() {
		if(instance == null) {
			instance = new ControladorComunidadMongo();
		}
		return null;
	}
	
	

	// Filtrar documentos dentro de una colección.
    private static void getCcaaByID(MongoCollection<Document> col, String code) {
    	
    	System.out.println("Filtrando elementos de una colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find(Filters.eq("code", code));        
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
            	System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }
	
    
    /**
     * Creamos objetos CCAA a partir de los documentos (cada documento es un objeto)
     * Rafa lo ha usado para pasar de una colección de documentos
     * a una lista de objetos 
     * @param doc
     * @return
     */
    private static ComunidadAutonoma documentToCcaa(Document doc) {
    	ComunidadAutonoma ccaa = new ComunidadAutonoma();
    	ccaa.setParent_code(doc.getString("parent_code"));
    	ccaa.setCode(doc.getString("code"));
    	ccaa.setLabel(doc.getString("label"));
    	return ccaa;
    }
	
    
   
	//REVISAR ESTA
    // Obtener todos los documentos de una colección.
    // y los metemos en una lista.  La colección sale del método anterior.
    private static List<ComunidadAutonoma> getAllCcaa(MongoCollection<Document> col) {
        System.out.println("Obteniendo todas las ccaa de la colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
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
 

	
}

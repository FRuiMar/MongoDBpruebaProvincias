package pruebaCCAA.controllers;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import pruebaCCAA.entities.ComunidadAutonoma;
import pruebaCCAA.entities.Provincia;

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
	
	
	
	//REVISAR ESTA
    // Obtener todos los documentos de una colección.
    // y los metemos en una lista.  La colección sale del método anterior.
    public List<Provincia> getAllProvincia(MongoCollection<Document> col) {
        System.out.println("Obteniendo todas las ccaa de la colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
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
    	provincia.setParent_code(doc.getString("parent_code"));
    	provincia.setCode(doc.getString("code"));
    	provincia.setLabel(doc.getString("label"));
    	return provincia;
    }
    
	
}

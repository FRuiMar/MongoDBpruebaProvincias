package pruebaCCAA.controllers;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SuperControladorMongoDb {
	
	//DECLARO E INICIALIZO.
	//Inicializo los parametros que le voy a pasar al controlador
	//algunos no cambian y los dejo ya preestablecidos, otros los pongo
	//vacios, porque se van a recibir del controlador correspondiente
	//según sea la base de datos o el nombre de la colección de objetos.
	int port_no= 27017; // este es por defecto. no lo incluyo en el constructor.
	String host_name = "localhost";
	String db_name = "";  //nombre de base de datos.
	String db_coll_name = "";  //nombre de colección de objetos.
			
	//constructor del supercontrolador
	public SuperControladorMongoDb(String host_name, String db_name, String db_coll_name) {
		this.host_name = host_name;
		this.db_name = db_name;
		this.db_coll_name = db_coll_name;
	}
		
	
	
	/**
     * Método principal que crea la conexión  con los datos del supercontrolador
     * @param args
     */
    public MongoCollection<Document> getCollection() {
        
        // Mongodb creando la cadena de conexión.
    			//se crea un la conexión para el cliente y posteriormente un URI
        String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
        MongoClientURI uri = new MongoClientURI(client_url);
 
        // Conectando y obteniendo un cliente.
        MongoClient mongo_client = new MongoClient(uri);
 
        // Obteniendo un enlace a la base de datos.
        MongoDatabase db = mongo_client.getDatabase(db_name);
 
        // Obteniendo la colección de la base de datos
        MongoCollection<Document> coll = db.getCollection(db_coll_name);
        
		return coll;
    }


}

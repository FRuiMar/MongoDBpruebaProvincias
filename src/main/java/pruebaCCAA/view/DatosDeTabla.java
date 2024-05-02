package pruebaCCAA.view;

import java.util.List;

import pruebaCCAA.controllers.ControladorComunidadMongo;
import pruebaCCAA.controllers.ControladorProvinciasMongo;
import pruebaCCAA.entities.ComunidadAutonoma;
import pruebaCCAA.entities.Provincia;


public class DatosDeTabla {

	private static List<Provincia> provincias = null;
	
	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Nombre Provincia", "Code", "Parent_code" };
	}


	
	
	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las pivincias
		List<Provincia> provincias = ControladorProvinciasMongo.getInstance().getAllProvincias();
		
		// Obtengo todas las pivincias
		List<ComunidadAutonoma> ccaa = ControladorComunidadMongo.getInstance().getAllCcaa();
				
		
		
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[provincias.size()][3];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < provincias.size(); i++) {
			Provincia p = provincias.get(i);
//			datos[i][0] = p.getId();  // no lo vamos a usar de momento
			datos[i][0] = p.getLabel();
			datos[i][1] = p.getCode();
			datos[i][2] = p.getParentCode();
			
			
			//tengo que añadir el nombre de la comunidad, or eso saco la lista de ccaa
			
		}
		
		return datos;
	}
	
	
}

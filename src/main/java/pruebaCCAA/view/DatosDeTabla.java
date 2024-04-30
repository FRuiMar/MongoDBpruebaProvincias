package pruebaCCAA.view;

import java.util.List;

import pruebaCCAA.controllers.ControladorProvinciasMongo;
import pruebaCCAA.entities.Provincia;


public class DatosDeTabla {

	private static List<Provincia> provincias = null;
	
	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Label", "Code", 
				"Parent_code", "CCAA"};
	}

	/**
	 * 
	 * @return
	 */
	public static List<Provincia> getTodasProvincias () {
		if (provincias == null) {
			provincias = (List<Provincia>) ControladorProvinciasMongo
					.getInstance().getAllProvincia(null)
		}
		return provincias;

	}
	
	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Provincia> provincias = get();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[contratos.size()][7];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < contratos.size(); i++) {
			Provincia p = contratos.get(i);
			datos[i][0] = p.getId();
			datos[i][1] = p.getDescripcion();
			datos[i][2] = p.getSaldo();
			datos[i][3] = p.getLimite();
			
		}
		
		return datos;
	}
	
	
}

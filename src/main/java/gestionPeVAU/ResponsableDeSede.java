package gestionPeVAU;

import java.util.*;

//Desarrollador -- Alex
public class ResponsableDeSede {
	
	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";

	private String Nombre;

	public ResponsableDeSede(String n) {
		//Crea la sede y lo inserta en la BD, si ya esta creada no hace nada
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		try {
		miBD.Insert("INSERT INTO ResponsablesDeSede VALUES('" + n + "')");
		} catch (Exception ex) {
			
		}
		this.Nombre = n;
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String n) {
		//Modifica el nombre de la sede en BD
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		Object[] tupla = miBD.Select("SELECT Nombre FROM ResponsablesDeSede WHERE Nombre = '" + n + "'").get(0);
		
		if (tupla[0] == null) {
			// error, ya existe una sede con el mismo nombre
		} else {
			miBD.Update("UPDATE ResponsablesDeSede SET Nombre = '" + n + "' WHERE Nombre = '" + this.Nombre + "'");
			this.Nombre = n;
		}
	}
	
	public static List<ResponsableDeSede> listaResponsables() {
		//Devuelve una lista con todas las sedes en BD
		List<ResponsableDeSede> lista = new ArrayList<ResponsableDeSede>();
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		for(Object[] tupla:miBD.Select("SELECT Nombre FROM ResponsablesDeSede")) {
			lista.add(new ResponsableDeSede((String)tupla[0]));
		}
		return lista;
	}
	
	public String toString()
    {
    	return this.Nombre;
    }


}

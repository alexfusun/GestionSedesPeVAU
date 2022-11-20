package gestionPeVAU;

import java.util.*;

public class Sede {

	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";

	private String Nombre;

	public Sede(String n) {
		//Crea la sede y lo inserta en la BD, si ya esta creada no hace nada
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		
		miBD.Insert("INSERT INTO Sedes VALUES('" + n + "')");
		this.Nombre = n;
	}
	
	public Sede(String n,boolean mostrar) {
		//Ya esta creado, solo quiero cargar de la BD para probar
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		Object[] tupla = miBD.Select("SELECT Nombre FROM Sedes WHERE Nombre = '" + n + "'").get(0);
		this.Nombre = (String)tupla[0];
	}
	

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String n) {
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		Object[] tupla = miBD.Select("SELECT Nombre FROM Sedes WHERE Nombre = '" + this.Nombre + "'").get(0);
		
		if (tupla == null) {
			// error, ya existe una sede con el mismo nombre
		} else {
			miBD.Update("UPDATE Sedes SET Nombre = '" + n + "' WHERE Nombre = '" + this.Nombre + "'");
			this.Nombre = n;
		}
	}
	
	public static List<Sede> listaSedes() {
		//Devuelve una lista con todas las sedes en BD
		List<Sede> lista = new ArrayList<Sede>();
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		for(Object[] tupla:miBD.Select("SELECT Nombre FROM Sedes")) {
			lista.add(new Sede((String)tupla[0],true));
		}
		return lista;
	}
	
	public String toString()
    {
    	return this.Nombre + "\n";
    }

}

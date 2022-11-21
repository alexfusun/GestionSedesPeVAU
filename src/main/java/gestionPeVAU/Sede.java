package gestionPeVAU;

import java.util.*;

public class Sede {

	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";

	private String Nombre;
	private ResponsableDeSede Responsable;

	public Sede(String n) {
		//Crea la sede y lo inserta en la BD, si ya esta creada no hace nada
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		try {
		miBD.Insert("INSERT INTO Sedes VALUES('" + n + "', null)");
		} catch (Exception ex) {
			
		}
		this.Nombre = n;
		this.Responsable = null;
	}
	
	public Sede(String n,boolean mostrar) {
		//Constructor no usado
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		Object[] tupla = miBD.Select("SELECT Nombre FROM Sedes WHERE Nombre = '" + n + "'").get(0);
		this.Nombre = (String)tupla[0];
		this.Responsable = null;
	}
	

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String n) {
		//Modifica el nombre de la sede en BD
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		Object[] tupla = miBD.Select("SELECT Nombre FROM Sedes WHERE Nombre = '" + this.Nombre + "'").get(0);
		
		if (tupla[0] == null) {
			// error, ya existe una sede con el mismo nombre
		} else {
			miBD.Update("UPDATE Sedes SET Nombre = '" + n + "' WHERE Nombre = '" + this.Nombre + "'");
			this.Nombre = n;
		}
	}
	
	public ResponsableDeSede getResponsable() {
		return this.Responsable;
	}
	
	public void setResponsable(ResponsableDeSede r) {
		//Asigna un responsable de sede
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		miBD.Update("UPDATE Sedes SET ResponsableNombre = '" + r.getNombre() + "' WHERE Nombre = '" + this.Nombre + "'");
		
		this.Responsable = r;
	}
	
	public static List<Sede> listaSedes() {
		//Devuelve una lista con todas las sedes en BD
		List<Sede> lista = new ArrayList<Sede>();
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		for(Object[] tupla:miBD.Select("SELECT Nombre FROM Sedes")) {
			lista.add(new Sede((String)tupla[0]));
		}
		return lista;
	}
	
	public String toString()
    {
    	return this.Nombre;
    }

}

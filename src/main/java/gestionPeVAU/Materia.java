package gestionPeVAU;

import java.util.ArrayList;
import java.util.List;

public class Materia {

	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";
	
	private String Nombre;
	
	public static List<Materia> listaMaterias() {
		//Devuelve una lista con todas las sedes en BD
		List<Materia> lista = new ArrayList<Materia>();
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		for(Object[] tupla:miBD.Select("SELECT NombreMateria FROM Materias")) {
			lista.add(new Materia((String)tupla[0]));
		}
		return lista;
	}
	
	public Materia(String n) {
		//Crea la materia y lo inserta en la BD
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		
		try {
			miBD.Insert("INSERT INTO Materias VALUES('" + n + "')");
		}catch(Exception ex) {
			
		}
		
		this.Nombre = n;
	}
	
	public String getNombre() {
		return this.Nombre;
	}
	
	//Setter prohibido
	
	public String toString() {
		return this.Nombre;
	}
}

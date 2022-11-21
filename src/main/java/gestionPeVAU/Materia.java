package gestionPeVAU;

import java.util.ArrayList;
import java.util.List;

public class Materia {

	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";
	
	private int ID;
	private String Nombre;
	
	public static List<Materia> listaMaterias() {
		//Devuelve una lista con todas las sedes en BD
		List<Materia> lista = new ArrayList<Materia>();
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		for(Object[] tupla:miBD.Select("SELECT ID FROM Materias")) {
			lista.add(new Materia((Integer)tupla[0]));
		}
		return lista;
	}
	
	public Materia(int id, String nombre) {
		//Crea la materia y lo inserta en la BD
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		
		try {
			miBD.Insert("INSERT INTO Materias VALUES('" + id + "', '" + nombre + "')");
		}catch(Exception ex) {
			
		}
		
		this.ID = id;
		this.Nombre = nombre;
	}
	
	public Materia(int id) {
		//Ya esta creado, solo quiero cargar de la BD para probar
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		Object[] tupla = miBD.Select("SELECT ID FROM Materias WHERE ID = '" + id + "'").get(0);
		
		this.ID = (Integer)tupla[0];
		this.Nombre = (String)tupla[1];
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getNombre() {
		return this.Nombre;
	}
	
	public String toString() {
		return this.Nombre + "\n";
	}
}

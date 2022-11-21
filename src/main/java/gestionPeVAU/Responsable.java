package gestionPeVAU;

import java.util.ArrayList;
import java.util.List;

public class Responsable {
	
	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";
	
	private int ID;
	private String Nombre;
	
	public static List<Responsable> listaResponsables() {
		//Devuelve una lista con todas las sedes en BD
		List<Responsable> lista = new ArrayList<Responsable>();
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		for(Object[] tupla:miBD.Select("SELECT ID FROM Responsables")) {
			lista.add(new Responsable((Integer)tupla[0]));
		}
		return lista;
	}
	
	public Responsable(int id, String nombre) {
		//Crea la materia y lo inserta en la BD
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		
		try {
			miBD.Insert("INSERT INTO Responsables VALUES('" + id + "', '" + nombre + "')");
		}catch(Exception ex) {
			
		}
		
		this.ID = id;
		this.Nombre = nombre;
	}
	
	public Responsable(int id) {
		//Ya esta creado, solo quiero cargar de la BD para probar
		BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
		Object[] tupla = miBD.Select("SELECT ID FROM Responsables WHERE ID = '" + id + "'").get(0);
		
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

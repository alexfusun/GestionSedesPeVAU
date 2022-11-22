package gestionPeVAU;

import java.util.*;

public class Alumno {
	
	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";
	
	private String NIF;
	private String Centro;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private List<Materia> listaMaterias;
	
	public Alumno(String centro, String nombre, String ap1, String ap2, String nif, List<Materia> lista) {
		this.Centro = centro;
		this.Nombre = nombre;
		this.Apellido1 = ap1;
		this.Apellido2 = ap2;
		this.NIF = nif;
		this.listaMaterias = lista;
	}

	@Override
	public String toString() {
		return "Alumno [NIF=" + NIF + ", Centro=" + Centro + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1
				+ ", Apellido2=" + Apellido2 + ", listaMaterias=" + listaMaterias + "]";
	}
}

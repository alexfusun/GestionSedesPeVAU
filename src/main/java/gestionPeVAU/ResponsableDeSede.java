package gestionPeVAU;
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

}

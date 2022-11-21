package gestionPeVAU;

import java.io.*;
import java.util.*;

public class CargaFicheros {
	
	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";
	
	public CargaFicheros() {
		
	}
	
	public void cargarSedes(String fichero) {
		//fichero es el parametro con el directorio del CSV
		BufferedReader br = null;
		  try {
		   String linea;

		   br = new BufferedReader(new FileReader(fichero));

		   while ((linea = br.readLine()) != null) {
			   Sede s = new Sede(linea);
		   }

		  } catch (IOException e) {

		   e.printStackTrace();

		  } finally {

		   try {
		    if (br != null)
		     br.close();
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
	}
	
	public void cargarResponsables(String fichero) {
		//fichero es el parametro con el directorio del CSV
				BufferedReader br = null;
				  try {
				   String linea;

				   br = new BufferedReader(new FileReader(fichero));

				   while ((linea = br.readLine()) != null) {
					   ResponsableDeSede s = new ResponsableDeSede(linea);
				   }

				  } catch (IOException e) {

				   e.printStackTrace();

				  } finally {

				   try {
				    if (br != null)
				     br.close();
				   } catch (IOException ex) {
				    ex.printStackTrace();
				   }
				  }
	}
	
	public void cargarMaterias() {
		
	}
}

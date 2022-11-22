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
		// fichero es el parametro con el directorio del CSV
		BufferedReader br = null;
		try {
			String linea;

			br = new BufferedReader(new InputStreamReader(new FileInputStream(fichero), "UTF-8"));

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
		// fichero es el parametro con el directorio del CSV
		BufferedReader br = null;
		try {
			String linea;

			br = new BufferedReader(new InputStreamReader(new FileInputStream(fichero), "UTF-8"));

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

	public void cargarMaterias(String fichero) {
		// fichero es el parametro con el directorio del CSV
		BufferedReader br = null;
		try {
			String linea;

			br = new BufferedReader(new InputStreamReader(new FileInputStream(fichero), "UTF-8"));

			while ((linea = br.readLine()) != null) {
				Materia m = new Materia(linea);
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
	
	public void cargarAlumnos(String fichero) {
		Scanner scan = null;
		String centro;
		String nombre;
		String ap1;
		String ap2;
		String nif;
		List<Materia> materia = new ArrayList<Materia>();
		//List<String> materia = new ArrayList<String>();
		
		try {
			scan = new Scanner(new FileInputStream(fichero), "UTF-8");
			
			scan.useDelimiter(";");
			
			while(scan.hasNextLine()) {
				centro = scan.next();
				nombre = scan.next();
				ap1 = scan.next();
				ap2 = scan.next();
				nif = scan.next();
				while(scan.hasNext()) {
					materia.add(new Materia(scan.next()));
					//materia.add(scan.next());
				}
				
				new Alumno(centro, nombre, ap1, ap2, nif, materia);
				/*System.out.println(centro + " " + nombre+ " " + ap1 + " " + ap2 + " " + 
									nif + " " + materia.toString());*/
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			scan.close();
		}
	}
}

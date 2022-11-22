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
		Scanner scanLinea = null;
		String centro = null;
		String nombre = null;
		String ap1 = null;
		String ap2 = null;
		String nif = null;
		String linea = null;
		String m = null;
		List<Materia> materia = new ArrayList<Materia>();
		//List<String> materia = new ArrayList<String>();
		
		try {
			scan = new Scanner(new FileInputStream(fichero), "UTF-8");
			
			while(scan.hasNextLine()) {
				linea = scan.nextLine();
				scanLinea = new Scanner(linea);
				scanLinea.useDelimiter(";");
				
				centro = scanLinea.next();
				nombre = scanLinea.next();
				ap1 = scanLinea.next();
				ap2 = scanLinea.next();
				nif = scanLinea.next();
				m = scanLinea.next();
				
				scanLinea = new Scanner(m);
				scanLinea.useDelimiter(",");
				while(scanLinea.hasNext()) {
					materia.add(new Materia(scan.next()));
					//materia.add(scanLinea.next());
				}
				
				new Alumno(centro, nombre, ap1, ap2, nif, materia);
				/*System.out.println(centro + " " + nombre+ " " + ap1 + " " + ap2 + " " + 
									nif + " " + materia.toString());*/
				//materia = new ArrayList<String>();
				materia = new ArrayList<Materia>();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			scan.close();
		}
	}
}

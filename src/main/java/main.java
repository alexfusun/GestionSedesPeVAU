import gestionPeVAU.*;
public class main {

	public static void main(String[] args) {
		// main usado para testear funciones
		
		//Carga un fichero de sedes, lo sube a la BD e imprime en consola las sedes en BD
		CargaFicheros prueba = new CargaFicheros();
		prueba.cargarSedes("C:\\Users\\Judi\\Desktop\\Uni\\PruebasSede.txt");
		for(Sede s : Sede.listaSedes()) {
			System.out.println(s);
		}
		System.out.println("Fin");
	}

}

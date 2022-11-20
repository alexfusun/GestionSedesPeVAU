import gestionPeVAU.*;
public class main {

	public static void main(String[] args) {
		// Prueba de carga de sedes
		CargaFicheros prueba = new CargaFicheros();
		prueba.cargarSedes("C:\\Users\\Judi\\Desktop\\Uni\\PruebasSede.txt");
		
		
		for(Sede s : Sede.listaSedes()) {
			System.out.println(s);
		}
		
	}

}

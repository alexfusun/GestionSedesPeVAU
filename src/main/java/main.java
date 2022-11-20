import gestionPeVAU.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CargaFicheros prueba = new CargaFicheros();
		prueba.cargarSedes("C:\\Users\\Judi\\Desktop\\Uni\\PruebasSede.txt");
		
		
		for(Sede s : Sede.listaSedes()) {
			System.out.println(s);
		}
		
	}

}

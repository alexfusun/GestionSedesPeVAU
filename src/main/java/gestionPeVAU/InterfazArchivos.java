package gestionPeVAU;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class InterfazArchivos extends JFrame {

	private JPanel contentPane;
	private JTextField textArchivo;
	private CargaFicheros cargaFicheros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazArchivos frame = new InterfazArchivos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazArchivos() {
		cargaFicheros = new CargaFicheros();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArchivo = new JTextField();
		textArchivo.setBounds(156, 194, 410, 29);
		contentPane.add(textArchivo);
		textArchivo.setColumns(10);
		
		JButton btnMaterias = new JButton("Cargar datos de materias");
		btnMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dir = textArchivo.getText();
				cargaFicheros.cargarMaterias(dir);
			}
		});
		btnMaterias.setBounds(614, 282, 201, 40);
		contentPane.add(btnMaterias);
		
		JButton btnUsuario = new JButton("Cargar datos de responsables");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dir = textArchivo.getText();
				cargaFicheros.cargarResponsables(dir);
			}
		});
		btnUsuario.setBounds(614, 188, 201, 40);
		contentPane.add(btnUsuario);
		
		JButton btnSedes = new JButton("Cargar datos de sedes");
		btnSedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dir = textArchivo.getText();
				cargaFicheros.cargarSedes(dir);
			}
		});
		btnSedes.setBounds(614, 107, 201, 40);
		contentPane.add(btnSedes);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazInicio iAInicio = new InterfazInicio();
				iAInicio.setVisible(true);
				close();
			}
		});
		btnInicio.setBounds(10, 450, 118, 40);
		contentPane.add(btnInicio);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 28, 90, 30);
		contentPane.add(lblUsuario);
		
		
	}
	//Para que la funcion close funcione tiene que estar asi la operacion de cierre: setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	private void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlumnos = new JButton("Cargar datos de alumnos");
		btnAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlumnos.setBounds(10, 172, 201, 40);
		contentPane.add(btnAlumnos);
		
		JButton btnUsuario = new JButton("Cargar datos de usuarios");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUsuario.setBounds(10, 102, 201, 40);
		contentPane.add(btnUsuario);
		
		JButton btnSedes = new JButton("Cargar datos de sedes");
		btnSedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSedes.setBounds(10, 236, 201, 40);
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
		
		textArchivo = new JTextField();
		textArchivo.setBounds(275, 113, 410, 29);
		contentPane.add(textArchivo);
		textArchivo.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCargar.setBounds(700, 113, 85, 29);
		contentPane.add(btnCargar);
	}
	//Para que la funcion close funcione tiene que estar asi la operacion de cierre: setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	private void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}

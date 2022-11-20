package gestionPeVAU;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class InterfazInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInicio frame = new InterfazInicio();
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
	public InterfazInicio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 890, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestionSedes = new JButton("Gestionar Sedes");
		btnGestionSedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGestionSedes.setBounds(10, 172, 177, 40);
		contentPane.add(btnGestionSedes);
		
		JButton btnCargar = new JButton("Cargar Ficheros");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazArchivos iA = new InterfazArchivos();
				iA.setVisible(true);
				close();
			}
		});
		btnCargar.setBounds(10, 102, 177, 40);
		contentPane.add(btnCargar);
		
		JButton btnGestionSede = new JButton("Gestionar Sede");
		btnGestionSede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGestionSede.setBounds(10, 236, 177, 40);
		contentPane.add(btnGestionSede);
		
		JButton btnCerrar = new JButton("Cerrar Sesión");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnCerrar.setBounds(10, 450, 139, 40);
		contentPane.add(btnCerrar);
		
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

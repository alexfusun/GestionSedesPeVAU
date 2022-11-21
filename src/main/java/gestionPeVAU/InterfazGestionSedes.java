package gestionPeVAU;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class InterfazGestionSedes extends JFrame {
	
	private static String BD_SERVER = "serverproyectopevau.database.windows.net";
	private static String BD_NAME = "PeVAU Database";
	private static String BD_USER = "azureuser";
	private static String BD_PASSWORD = "Requisitos2022!";

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGestionSedes frame = new InterfazGestionSedes();
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
	public InterfazGestionSedes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 908, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazInicio iAInicio = new InterfazInicio();
				iAInicio.setVisible(true);
				close();
			}
		});
		btnInicio.setBounds(10, 466, 118, 40);
		contentPane.add(btnInicio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 62, 568, 230);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		actualizarTabla();
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBorrar.setBounds(215, 370, 128, 40);
		contentPane.add(btnBorrar);
		
		JButton btnAsignar = new JButton("Asignar Responsable");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazResponsables ia = new InterfazResponsables();
				ia.setVisible(true);
			}
		});
		btnAsignar.setBounds(408, 370, 128, 40);
		contentPane.add(btnAsignar);
		
		JButton btnDesasignar = new JButton("Desasignar responsable");
		btnDesasignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDesasignar.setBounds(600, 370, 151, 40);
		contentPane.add(btnDesasignar);
		
		JLabel lblNewLabel = new JLabel("Sedes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(405, 10, 208, 42);
		contentPane.add(lblNewLabel);
	}
	//Para que la funcion close funcione tiene que estar asi la operacion de cierre: setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		private void close() {
			WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
		}
		private void actualizarTabla() {
			try {
				/*BD miBD = new BD(BD_SERVER, BD_NAME, BD_USER, BD_PASSWORD);
				ArrayList<Sede> lista = new ArrayList<Sede>();
				for(Object[] tupla:miBD.Select("SELECT Nombre FROM Sedes")) {
					lista.add(new Sede((String)tupla[0],true));
				}*/
				List<Sede> lista = Sede.listaSedes();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object fila[] = new Object[2];
				for(int i =0; i<lista.size();i++) {
					fila[0] = lista.get(i).getNombre();
					fila[1] = null;
					model.addRow(fila);
				}
			} catch (BD_Error e) {
				e.printStackTrace();
			}
		}
}

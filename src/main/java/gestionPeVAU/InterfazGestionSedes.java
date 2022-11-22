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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sede", "Responsable"
			}
		));
		scrollPane.setViewportView(table);
		crearTabla();
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sede seleccionada = Sede.listaSedes().get(table.getSelectedRow());
				seleccionada.borrarSede();
				actualizarTabla();
			}
		});
		btnBorrar.setBounds(215, 370, 128, 40);
		contentPane.add(btnBorrar);
		
		JButton btnAsignar = new JButton("Asignar Responsable");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InterfazResponsables ia = new InterfazResponsables(table.getSelectedRow());
					ia.setVisible(true);	
					close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnAsignar.setBounds(408, 370, 128, 40);
		contentPane.add(btnAsignar);
		
		JButton btnDesasignar = new JButton("Desasignar responsable");
		btnDesasignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sede seleccionada = Sede.listaSedes().get(table.getSelectedRow());
				seleccionada.desasignarResponsable();
				actualizarTabla();
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
		private void crearTabla() {
			try {
				List<Sede> lista = Sede.listaSedes();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object columna[] = new Object[2];
				for(int i =0; i<lista.size();i++) {
					columna[0] = lista.get(i).getNombre();
					columna[1] = lista.get(i).getResponsable();
					model.addRow(columna);
				}
			} catch (BD_Error e) {
				e.printStackTrace();
			}
		}
		
		private void actualizarTabla() {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
			
			crearTabla();
		}
		
}

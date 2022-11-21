package gestionPeVAU;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class InterfazResponsables extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public InterfazResponsables(final int x) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 906, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazGestionSedes iaGestionSedes = new InterfazGestionSedes();
				iaGestionSedes.setVisible(true);
				close();
			}
		});
		btnVolver.setBounds(10, 444, 123, 45);
		contentPane.add(btnVolver);
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				ResponsableDeSede seleccionado = ResponsableDeSede.listaResponsables().get(table.getSelectedRow());
				Sede.listaSedes().get(x).setResponsable(seleccionado);
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnAsignar.setBounds(370, 426, 171, 51);
		contentPane.add(btnAsignar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 110, 596, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre"
			}
		));
		scrollPane.setViewportView(table);
		actualizarTabla();
	}
	//Para que la funcion close funcione tiene que estar asi la operacion de cierre: setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	private void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	private void actualizarTabla() {
		try {
			List<ResponsableDeSede> lista = ResponsableDeSede.listaResponsables();
			
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

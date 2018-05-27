package edu.uade.apd.tpo;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uade.apd.tpo.repository.AdministracionDelegate;
import edu.uade.apd.tpo.repository.stub.ClienteStub;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarClientes {

	private JFrame frmListarClientes;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarClientes window = new ListarClientes();
					window.frmListarClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarClientes() {
		initialize();
		loadClientes();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListarClientes = new JFrame();
		frmListarClientes.setTitle("Listar Clientes | Das Verrückte Lagerhaus");
		frmListarClientes.setBounds(100, 100, 660, 440);
		frmListarClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListarClientes.getContentPane().setLayout(null);
		
		JLabel lblListarClientes = new JLabel("Listar clientes");
		lblListarClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblListarClientes.setBounds(6, 20, 648, 30);
		frmListarClientes.getContentPane().add(lblListarClientes);
		
		String[] columnNames = { "ID", "CUIL", "Nombre", "Saldo", "Límite de Cred."};
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, columnNames) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(20);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 62, 648, 300);
		table.setFillsViewportHeight(true);
		frmListarClientes.getContentPane().add(scrollPane);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmListarClientes.dispose();
			}
		});
		btnCerrar.setBounds(537, 374, 117, 29);
		frmListarClientes.getContentPane().add(btnCerrar);
		
	}
	
	private void loadClientes() {
		try {
			List<ClienteStub> clientes = AdministracionDelegate.getInstance().getClientes();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for(ClienteStub c : clientes) {
				String id = c.getId().toString();
				String cuil = c.getCuil().toString();
				String nombre = c.getNombre();
				float saldo = c.getCuentaCorriente().getSaldo();
				float limite = c.getCuentaCorriente().getLimiteCredito();
				model.addRow(new Object[] {id, cuil, nombre, "$"+saldo, "$"+limite});
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

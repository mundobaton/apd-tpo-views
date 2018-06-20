
package edu.uade.apd.tpo;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uade.apd.tpo.repository.AdministracionDelegate;
import edu.uade.apd.tpo.repository.stub.ClienteStub;
import edu.uade.apd.tpo.repository.stub.PedidoStub;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarPedidosPendientes {

	private JFrame frmListarPedidosPendientes;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarPedidosPendientes window = new ListarPedidosPendientes();
					window.frmListarPedidosPendientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
		 * Create the application.
		 */
		public ListarPedidosPendientes() {
			initialize();
			loadPedidos();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListarPedidosPendientes = new JFrame();
		frmListarPedidosPendientes.setTitle("Listar Pedidos pendientes | Das Verrückte Lagerhaus");
		frmListarPedidosPendientes.setBounds(100, 100, 660, 440);
		frmListarPedidosPendientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListarPedidosPendientes.getContentPane().setLayout(null);

	    JMenuBar jmb = new JMenuBar();
	    JMenu jmFile = new JMenu("Menú");
	    JMenuItem crearCliente = new JMenuItem("Crear Cliente");
	    JMenuItem crearUsuario = new JMenuItem("Crear usuario");
	    JMenuItem generarPedido = new JMenuItem("Generar Pedido");
	    JMenuItem listarClientes = new JMenuItem("Listar clientes");
	    JMenuItem jmiExit = new JMenuItem("Exit");
	    jmFile.add(crearCliente);
	    jmFile.add(crearUsuario);
	    jmFile.add(generarPedido);
	    jmFile.add(listarClientes);
	    jmFile.addSeparator();
	    jmFile.add(jmiExit);
	    jmb.add(jmFile);

	   
	    crearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente crearCliente = new CrearCliente();
				crearCliente.setVisible(true);
				frmListarPedidosPendientes.dispose();
			}
	    });
	    
	    crearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario crearUsuario = new CrearUsuario();
				crearUsuario.setVisible(true);
				frmListarPedidosPendientes.dispose();
			}
		});
	    
	    generarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarPedido generarPedido = new GenerarPedido();
				generarPedido.setVisible(true);
				frmListarPedidosPendientes.dispose();
			}
		});
	    
	    
	    listarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientes listarClientes = new ListarClientes();
				listarClientes.setVisible(true);
				frmListarPedidosPendientes.dispose();
			}
		});
	    
	    frmListarPedidosPendientes.setJMenuBar(jmb);
	    frmListarPedidosPendientes.setVisible(true);
		
	    
		JLabel lblListarPedidosPendientes = new JLabel("Listar Pedidos pendientes");
		lblListarPedidosPendientes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblListarPedidosPendientes.setBounds(6, 20, 648, 30);
		frmListarPedidosPendientes.getContentPane().add(lblListarPedidosPendientes);

		String[] columnNames = { "ID", "Fecha de pedido"};
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
		frmListarPedidosPendientes.getContentPane().add(scrollPane);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmListarPedidosPendientes.dispose();
			}
		});
		btnCerrar.setBounds(537, 374, 117, 29);
		frmListarPedidosPendientes.getContentPane().add(btnCerrar);

	}
	
	
	public void setVisible(boolean isVisible) {
		this.frmListarPedidosPendientes.setVisible(isVisible);
	}

	private void loadPedidos() {
		try {
			List<PedidoStub> pedidosPendientes = AdministracionDelegate.getInstance().obtenerPedidosPendientes();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (PedidoStub p : pedidosPendientes) {
				String id = p.getId().toString();
				Date fechaPedido = p.getFechaPedido();
				model.addRow(new Object[] {id, fechaPedido});
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

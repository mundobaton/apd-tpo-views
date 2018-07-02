package edu.uade.apd.tpo;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uade.apd.tpo.repository.delegate.AdministracionDelegate;
import edu.uade.apd.tpo.repository.dto.ClienteDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarClientes {

	private JFrame frmListarClientes;
	private JTable table;
	private Long cuit;

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
		
		frmListarClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar jmb = new JMenuBar();

		JMenu jmFile = new JMenu("Menú");
		JMenuItem listarClientes = new JMenuItem("Listar Clientes");
		JMenuItem crearCliente = new JMenuItem("Crear Cliente");
		JMenuItem crearUsuario = new JMenuItem("Crear Usuario");
		JMenuItem listarPedidosPendientes = new JMenuItem("Listar pedidos pendientes");
		JMenuItem jmiExit = new JMenuItem("Salir");
		jmFile.add(listarClientes);
		jmFile.add(crearCliente);
		jmFile.add(crearUsuario);
		jmFile.add(listarPedidosPendientes);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);

	   
	    crearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente crearCliente = new CrearCliente();
				crearCliente.setVisible(true);
				frmListarClientes.dispose();
			}
	    });
	    
	    crearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario crearUsuario = new CrearUsuario();
				crearUsuario.setVisible(true);
				frmListarClientes.dispose();
			}
		});
	    
	    
	    listarPedidosPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPedidosPendientes listarPedidosPendientes = new ListarPedidosPendientes();
				listarPedidosPendientes.setVisible(true);
				frmListarClientes.dispose();
			}
		});
	    
	    frmListarClientes.setJMenuBar(jmb);
	    frmListarClientes.setVisible(true);
		
		JLabel lblListarClientes = new JLabel("Listar clientes");
		lblListarClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblListarClientes.setBounds(6, 20, 648, 30);
		frmListarClientes.getContentPane().add(lblListarClientes);
		
		String[] columnNames = {"CUIT", "Nombre", "Saldo", "Límite de Cred."};
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
				Home home = new Home();
				home.setVisible(true);
				frmListarClientes.dispose();
			}
		});
		btnCerrar.setBounds(537, 374, 117, 29);
		frmListarClientes.getContentPane().add(btnCerrar);
		
	}
	
	private void loadClientes() {
		try {
			 List<ClienteDTO> clientes = AdministracionDelegate.getInstance().getClientes();
					 
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for(ClienteDTO c : clientes) {
				long cuit = c.getCuit();
				String nombre = c.getNombre();
				float saldo = c.getCuentaCorriente().getSaldo();
				float limite = c.getCuentaCorriente().getCredito();
				model.addRow(new Object[] {cuit, nombre, "$"+saldo, "$"+limite});
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void setVisible(boolean isVisible) {
		this.frmListarClientes.setVisible(isVisible);
	}
} 


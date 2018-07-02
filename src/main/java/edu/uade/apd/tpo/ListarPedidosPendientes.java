
package edu.uade.apd.tpo;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.uade.apd.tpo.repository.delegate.AdministracionDelegate;
import edu.uade.apd.tpo.repository.dto.PedidoDTO;
import edu.uade.apd.tpo.repository.exception.RemoteBusinessException;

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
		inicializarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
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

		String[] columnNames = { "Id", "Cliente", "Estado" };
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, columnNames) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				default:
					return Object.class;
				}
			}
		});
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(20);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 62, 648, 236);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frmListarPedidosPendientes.getContentPane().add(scrollPane);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmListarPedidosPendientes.dispose();
			}
		});
		btnCerrar.setBounds(517, 309, 117, 29);
		frmListarPedidosPendientes.getContentPane().add(btnCerrar);

		JButton btnAprobar = new JButton("Aprobar");
		btnAprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnAprobar.setBounds(6, 309, 117, 29);
		frmListarPedidosPendientes.getContentPane().add(btnAprobar);

	}

	public void setVisible(boolean isVisible) {
		this.frmListarPedidosPendientes.setVisible(isVisible);
	}

	private void actualizarTabla() {
		DefaultTableModel jTable1Model = (DefaultTableModel) table.getModel();
		List<PedidoDTO> pedidosPendientes;
		try {
			pedidosPendientes = AdministracionDelegate.getInstance().obtenerPedidosPendientes();
			if (pedidosPendientes != null) {
				for (PedidoDTO p : pedidosPendientes) {
					long id = p.getId().longValue();
					String cliente = p.getCliente().getNombre();
					String estado = p.getEstado().getName();
					jTable1Model.addRow(new Object[] { id, cliente, estado });
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void inicializarTabla() {
		DefaultTableModel jTable1Model = (DefaultTableModel) table.getModel();
		List<PedidoDTO> pedidosPendientes;
		try {
			pedidosPendientes = AdministracionDelegate.getInstance().obtenerPedidosPendientes();
			if (pedidosPendientes != null) {
				for (PedidoDTO p : pedidosPendientes) {
					String id = p.getId().toString();
					String cliente = p.getCliente().getNombre();
					String estado = p.getEstado().getName();
					jTable1Model.addRow(new Object[] { id, cliente, estado });
				}
			}
			table.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = table.rowAtPoint(evt.getPoint());
					int col = table.columnAtPoint(evt.getPoint());
					if (row >= 0 && col >= 0) {
						PedidoDTO pedido = pedidosPendientes.get(row);
						try {
							Object[] options = {
									"Aprobar",
									"Rechazar",
									"Cancelar"
							};
							int response = JOptionPane.showOptionDialog(null, "¿Desea aprobar el pedido?",
									"Aprobar Pedido", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							if (response == JOptionPane.YES_OPTION) {
								jTable1Model.removeRow(row);
								AdministracionDelegate.getInstance().aprobarPedido(pedido.getId());
							} else if(response == JOptionPane.NO_OPTION) {
								jTable1Model.removeRow(row);
								AdministracionDelegate.getInstance().rechazarPedido(pedido.getId(), "");
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}

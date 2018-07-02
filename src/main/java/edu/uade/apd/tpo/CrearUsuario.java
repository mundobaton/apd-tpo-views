package edu.uade.apd.tpo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.uade.apd.tpo.repository.delegate.AdministracionDelegate;
import edu.uade.apd.tpo.repository.dto.RolDTO;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CrearUsuario {

	private JFrame frmCrearUsuario;
	private JTextField txtEmail;
	private JLabel lblPasswd;
	private JTextField txtPasswd;
	private JComboBox comboRol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario window = new CrearUsuario();
					window.frmCrearUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCrearUsuario = new JFrame();
		frmCrearUsuario.setResizable(true);
		frmCrearUsuario.setTitle("Crear Usuario | Das Verrückte Lagerhaus");
		frmCrearUsuario.setBounds(90, 90, 663, 392);
		frmCrearUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearUsuario.getContentPane().setLayout(null);

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
		
		jmiExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrearUsuario.dispose();
			}
		});

		listarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientes listarClientes = new ListarClientes();
				listarClientes.setVisible(true);
				frmCrearUsuario.dispose();
			}
		});
		
		crearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente crearCliente = new CrearCliente();
				crearCliente.setVisible(true);
				frmCrearUsuario.dispose();
			}
		});
		
		listarPedidosPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPedidosPendientes listarPedidosPendientes = new ListarPedidosPendientes();
				listarPedidosPendientes.setVisible(true);
				frmCrearUsuario.dispose();
			}
		});
		
		frmCrearUsuario.setJMenuBar(jmb);
		frmCrearUsuario.setVisible(true);
		
		JLabel lblLegajo = new JLabel("Legajo:");
		lblLegajo.setBounds(6, 87, 300, 16);
		frmCrearUsuario.getContentPane().add(lblLegajo);

		txtEmail = new JTextField();
		txtEmail.setBounds(6, 115, 300, 26);
		frmCrearUsuario.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		lblPasswd = new JLabel("Contraseña:");
		lblPasswd.setBounds(338, 87, 300, 16);
		frmCrearUsuario.getContentPane().add(lblPasswd);

		txtPasswd = new JPasswordField();
		txtPasswd.setBounds(338, 115, 300, 26);
		frmCrearUsuario.getContentPane().add(txtPasswd);
		txtPasswd.setColumns(10);

		String[] rolString = {"Administracion", "Deposito" , "Despacho" , "Facturacion" , "Compras"};
		comboRol = new JComboBox(rolString);
		comboRol.setBounds(6, 175, 300, 27);
		frmCrearUsuario.getContentPane().add(comboRol);

		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(6, 152, 300, 16);
		frmCrearUsuario.getContentPane().add(lblRol);


		JLabel lblAltaDeUsuario= new JLabel("Alta de Usuario");
		lblAltaDeUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAltaDeUsuario.setBounds(6, 20, 648, 30);
		frmCrearUsuario.getContentPane().add(lblAltaDeUsuario);


		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(521, 174, 117, 29);
		frmCrearUsuario.getContentPane().add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
				popUpId();
				Home home = new Home();
				home.setVisible(true);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(338, 174, 117, 29);
		frmCrearUsuario.getContentPane().add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				frmCrearUsuario.dispose();
			}
		});
	}
	
	private void guardar() {
		try {
			AdministracionDelegate adm = AdministracionDelegate.getInstance();
			String email = txtEmail.getText();
			String password = txtPasswd.getText();
			String rolString = comboRol.getSelectedItem().toString();
			RolDTO rol = RolDTO.valueOf(rolString.toUpperCase());
			adm.crearUsuario(email, password, rol);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void popUpId() {
		final JFrame parent = new JFrame();
	    JOptionPane.showMessageDialog(parent, "El usuario se ha generado con exito");
    }
	   
	public void setVisible(boolean isVisible) {
			this.frmCrearUsuario.setVisible(isVisible);
	}
}

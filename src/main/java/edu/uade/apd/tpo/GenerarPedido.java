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

import edu.uade.apd.tpo.repository.AdministracionDelegate;
import edu.uade.apd.tpo.repository.stub.CondIvaStub;
import edu.uade.apd.tpo.repository.stub.ZonaStub;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GenerarPedido {

	private JFrame frmGenerarPedido;
	private JTextField txtCuil;
	private JLabel lblCalle;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtCodigoPostal;
	private JLabel lblLocalidad;
	private JTextField txtLocalidad;
	private JLabel lblProvincia;
	private JComboBox comboProvincia;
	private JSeparator separator_1;
	private JButton btnCancelar;
	private JComboBox comboZona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarPedido window = new GenerarPedido();
					window.frmGenerarPedido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GenerarPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmGenerarPedido = new JFrame();
		frmGenerarPedido.setResizable(false);
		frmGenerarPedido.setTitle("Generar Pedido | Das Verrückte Lagerhaus");
		frmGenerarPedido.setBounds(100, 100, 660, 640);
		frmGenerarPedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGenerarPedido.getContentPane().setLayout(null);
		
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("Menú");
		JMenuItem listarClientes = new JMenuItem("Listar Clientes");
		JMenuItem crearCliente = new JMenuItem("Crear Cliente");
		JMenuItem crearUsuario = new JMenuItem("Crear Usuario");
		JMenuItem listarPedidosPendientes = new JMenuItem("Listar pedidos pendientes");
		JMenuItem jmiExit = new JMenuItem("Exit");
		jmFile.add(listarClientes);
		jmFile.add(crearCliente);
		jmFile.add(crearUsuario);
		jmFile.add(listarPedidosPendientes);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);

		listarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientes listarClientes = new ListarClientes();
				listarClientes.setVisible(true);
				frmGenerarPedido.dispose();
			}
		});
		
		listarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente crearCliente = new CrearCliente();
				crearCliente.setVisible(true);
				frmGenerarPedido.dispose();
			}
		});
		
		listarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario crearUsuario = new CrearUsuario();
				crearUsuario.setVisible(true);
				frmGenerarPedido.dispose();
			}
		});
		
		listarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPedidosPendientes listarPedidosPendientes = new ListarPedidosPendientes();
				listarPedidosPendientes.setVisible(true);
				frmGenerarPedido.dispose();
			}
		});
		
		frmGenerarPedido.setJMenuBar(jmb);
		frmGenerarPedido.setVisible(true);
		
		JLabel lblgenerarPedido = new JLabel("Generar pedido ");
		lblgenerarPedido.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblgenerarPedido.setBounds(6, 6, 648, 30);
		frmGenerarPedido.getContentPane().add(lblgenerarPedido);
		
		JLabel lblDondeTeEnviamos = new JLabel("¿ Donde te enviamos el pedido ? ");
		lblDondeTeEnviamos.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblDondeTeEnviamos.setBounds(6, 37, 648, 30);
		frmGenerarPedido.getContentPane().add(lblDondeTeEnviamos);

		JLabel lblEmail = new JLabel("Cuil:");
		lblEmail.setBounds(6, 95, 300, 16);
		frmGenerarPedido.getContentPane().add(lblEmail);

		txtCuil = new JTextField();
		txtCuil.setBounds(6, 123, 300, 26);
		frmGenerarPedido.getContentPane().add(txtCuil);
		txtCuil.setColumns(10);


		lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(6, 195, 61, 16);
		frmGenerarPedido.getContentPane().add(lblCalle);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 161, 644, 16);
		frmGenerarPedido.getContentPane().add(separator);

		txtCalle = new JTextField();
		txtCalle.setBounds(6, 210, 300, 26);
		frmGenerarPedido.getContentPane().add(txtCalle);
		txtCalle.setColumns(10);

		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(332, 195, 300, 16);
		frmGenerarPedido.getContentPane().add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(332, 210, 300, 26);
		frmGenerarPedido.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);


		lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(6, 261, 300, 16);
		frmGenerarPedido.getContentPane().add(lblLocalidad);

		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(6, 276, 300, 26);
		frmGenerarPedido.getContentPane().add(txtLocalidad);
		txtLocalidad.setColumns(10);

		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(6, 325, 300, 16);
		frmGenerarPedido.getContentPane().add(lblProvincia);

		String[] comboProvString = { "CABA", "Buenos Aires", "Catamarca", "Chaco", "Chubut", "Córdoba", "Corrientes",
				"Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro",
				"Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierra del Fuego",
				"Tucumán" };
		comboProvincia = new JComboBox(comboProvString);
		comboProvincia.setBounds(6, 342, 300, 27);
		frmGenerarPedido.getContentPane().add(comboProvincia);
		
		JLabel lblCodigoPostal = new JLabel("Código Postal:");
		lblCodigoPostal.setBounds(332, 261, 300, 16);
		frmGenerarPedido.getContentPane().add(lblCodigoPostal);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(332, 276, 300, 26);
		frmGenerarPedido.getContentPane().add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);
		
		String[] zonaString = { "Caba", "Norte", "Sur" , "Oeste" };
		comboZona = new JComboBox(zonaString);
		comboZona.setBounds(332, 342, 300, 27);
		frmGenerarPedido.getContentPane().add(comboZona);

		JLabel lblZona = new JLabel("Zona de envio:");
		lblZona.setBounds(342, 325, 300, 16);
		frmGenerarPedido.getContentPane().add(lblZona);

		separator_1 = new JSeparator();
		separator_1.setBounds(6, 434, 644, 12);
		frmGenerarPedido.getContentPane().add(separator_1);


		JButton btnGuardar = new JButton("Generar Pedido");
		btnGuardar.setBounds(285, 501, 164, 29);
		frmGenerarPedido.getContentPane().add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
				popUpId();
			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(480, 501, 117, 29);
		frmGenerarPedido.getContentPane().add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO fix del flujo de navegacion
				frmGenerarPedido.dispose();
			}
		});
	}

	private void guardar() {
		try {
			AdministracionDelegate adm = AdministracionDelegate.getInstance();
            
			String cuilString = txtCuil.getText();
			long cuil = Long.parseLong(cuilString);
			String calle = txtCalle.getText();
			String numeroString = txtNumero.getText();
			long numero = Long.parseLong(numeroString);
			String codPostal = txtCodigoPostal.getText();
			String localidad = txtLocalidad.getText();
			String provincia = comboProvincia.getSelectedItem().toString();
			String zona = comboZona.getSelectedItem().toString();
			ZonaStub zonaS = ZonaStub.fromString(zona);
			
			adm.crearPedido(cuil, calle, numero, codPostal, localidad, provincia, zonaS);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void setVisible(boolean isVisible) {
		this.frmGenerarPedido.setVisible(isVisible);
	}

		   private void popUpId() {
	        final JFrame parent = new JFrame();
	        //TODO  Agregar numero de pedido
	        JOptionPane.showMessageDialog(parent, "Su numero de pedido es: XXXXX ");

	    }
	}


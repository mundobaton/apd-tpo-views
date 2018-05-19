package edu.uade.apd.tpo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.uade.apd.tpo.repository.AdministracionDelegate;
import edu.uade.apd.tpo.repository.stub.CondIvaStub;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CrearCliente {

	private static final float ZonaEnvioStub = 0;
	private JFrame frmCrearCliente;
	private JTextField txtNombreCompleto;
	private JTextField txtEmail;
	private JLabel lblPasswd;
	private JTextField txtPasswd;
	private JLabel lblCuil;
	private JTextField txtCuil;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblCalle;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtCodigoPostal;
	private JLabel lblLocalidad;
	private JTextField txtLocalidad;
	private JLabel lblProvincia;
	private JComboBox comboProvincia;
	private JComboBox comboCondIVA;
	private JSeparator separator_1;
	private JLabel lblCuentaCorriente;
	private JLabel lblSaldo;
	private JTextField txtSaldo;
	private JLabel lblLmiteDeCrdito;
	private JTextField txtLimiteCredito;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente window = new CrearCliente();
					window.frmCrearCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrearCliente = new JFrame();
		frmCrearCliente.setResizable(false);
		frmCrearCliente.setTitle("Crear Cliente | Das Verrückte Lagerhaus");
		frmCrearCliente.setBounds(100, 100, 660, 640);
		frmCrearCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearCliente.getContentPane().setLayout(null);

		JLabel lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setBounds(6, 62, 300, 16);
		frmCrearCliente.getContentPane().add(lblNombreCompleto);

		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setBounds(6, 82, 300, 26);
		frmCrearCliente.getContentPane().add(txtNombreCompleto);
		txtNombreCompleto.setColumns(10);

		JLabel lblEmail = new JLabel("Correo electrónico:");
		lblEmail.setBounds(6, 120, 300, 16);
		frmCrearCliente.getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(6, 142, 300, 26);
		frmCrearCliente.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		lblPasswd = new JLabel("Contraseña:");
		lblPasswd.setBounds(350, 120, 300, 16);
		frmCrearCliente.getContentPane().add(lblPasswd);

		txtPasswd = new JPasswordField();
		txtPasswd.setBounds(350, 142, 300, 26);
		frmCrearCliente.getContentPane().add(txtPasswd);
		txtPasswd.setColumns(10);

		lblCuil = new JLabel("CUIL:");
		lblCuil.setBounds(350, 62, 61, 16);
		frmCrearCliente.getContentPane().add(lblCuil);

		txtCuil = new JTextField();
		txtCuil.setBounds(350, 82, 300, 26);
		frmCrearCliente.getContentPane().add(txtCuil);
		txtCuil.setColumns(10);

		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(6, 180, 300, 16);
		frmCrearCliente.getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(6, 202, 300, 26);
		frmCrearCliente.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

		String[] condIvaString = { "Responsable Inscripto", "Exento", "Consumidor Final" };
		comboCondIVA = new JComboBox(condIvaString);
		comboCondIVA.setBounds(350, 203, 300, 27);
		frmCrearCliente.getContentPane().add(comboCondIVA);

		JLabel lblCondicinIva = new JLabel("Condición IVA:");
		lblCondicinIva.setBounds(350, 180, 300, 16);
		frmCrearCliente.getContentPane().add(lblCondicinIva);

		lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(6, 257, 61, 16);
		frmCrearCliente.getContentPane().add(lblCalle);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 240, 644, 16);
		frmCrearCliente.getContentPane().add(separator);

		txtCalle = new JTextField();
		txtCalle.setBounds(6, 277, 300, 26);
		frmCrearCliente.getContentPane().add(txtCalle);
		txtCalle.setColumns(10);

		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(350, 257, 300, 16);
		frmCrearCliente.getContentPane().add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(350, 277, 300, 26);
		frmCrearCliente.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblCodigoPostal = new JLabel("Código Postal:");
		lblCodigoPostal.setBounds(6, 315, 300, 16);
		frmCrearCliente.getContentPane().add(lblCodigoPostal);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(6, 337, 300, 26);
		frmCrearCliente.getContentPane().add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);

		JLabel lblAltaDeCliente = new JLabel("Alta de Cliente");
		lblAltaDeCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAltaDeCliente.setBounds(6, 20, 648, 30);
		frmCrearCliente.getContentPane().add(lblAltaDeCliente);

		lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(350, 315, 300, 16);
		frmCrearCliente.getContentPane().add(lblLocalidad);

		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(350, 337, 300, 26);
		frmCrearCliente.getContentPane().add(txtLocalidad);
		txtLocalidad.setColumns(10);

		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(6, 375, 300, 16);
		frmCrearCliente.getContentPane().add(lblProvincia);

		String[] comboProvString = { "CABA", "Buenos Aires", "Catamarca", "Chaco", "Chubut", "Córdoba", "Corrientes",
				"Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro",
				"Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierra del Fuego",
				"Tucumán" };
		comboProvincia = new JComboBox(comboProvString);
		comboProvincia.setBounds(6, 395, 300, 27);
		frmCrearCliente.getContentPane().add(comboProvincia);

		separator_1 = new JSeparator();
		separator_1.setBounds(6, 434, 644, 12);
		frmCrearCliente.getContentPane().add(separator_1);

		lblCuentaCorriente = new JLabel("Cuenta Corriente");
		lblCuentaCorriente.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCuentaCorriente.setBounds(6, 458, 644, 20);
		frmCrearCliente.getContentPane().add(lblCuentaCorriente);

		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(6, 490, 300, 16);
		frmCrearCliente.getContentPane().add(lblSaldo);

		txtSaldo = new JTextField();
		txtSaldo.setBounds(6, 510, 300, 26);
		frmCrearCliente.getContentPane().add(txtSaldo);
		txtSaldo.setColumns(10);

		lblLmiteDeCrdito = new JLabel("Límite de Crédito:");
		lblLmiteDeCrdito.setBounds(350, 490, 300, 16);
		frmCrearCliente.getContentPane().add(lblLmiteDeCrdito);

		txtLimiteCredito = new JTextField();
		txtLimiteCredito.setBounds(350, 510, 300, 26);
		frmCrearCliente.getContentPane().add(txtLimiteCredito);
		txtLimiteCredito.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(537, 570, 117, 29);
		frmCrearCliente.getContentPane().add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(408, 570, 117, 29);
		frmCrearCliente.getContentPane().add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO fix del flujo de navegacion
				frmCrearCliente.dispose();
			}
		});
	}

	private void guardar() {
		try {
			AdministracionDelegate adm = AdministracionDelegate.getInstance();

			String email = txtEmail.getText();
			String password = txtPasswd.getText();
			String nombre = txtNombreCompleto.getText();
			Long cuil = Long.parseLong(txtCuil.getText());
			String telefono = txtTelefono.getText();
			String iva = comboCondIVA.getSelectedItem().toString();
			CondIvaStub condIva = CondIvaStub.getCondIvaFromValue(iva);

			String calle = txtCalle.getText();
			int numero = Integer.parseInt(txtNumero.getText());
			String codPostal = txtCodigoPostal.getText();
			String localidad = txtLocalidad.getText();
			String provincia = comboProvincia.getSelectedItem().toString();
			Float saldo = Float.parseFloat(txtSaldo.getText());
			Float limiteCredito = Float.parseFloat(txtLimiteCredito.getText());

			//TODO Falta agregar la zona a la ventana y pasarsela. Por ahora le mando cualquiera para cerrar la integracion

			adm.crearCliente(email, password, nombre, cuil, telefono, condIva, calle, numero, codPostal, localidad,
					provincia, saldo, limiteCredito);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

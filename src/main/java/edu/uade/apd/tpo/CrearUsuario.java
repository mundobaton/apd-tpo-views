package edu.uade.apd.tpo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.uade.apd.tpo.repository.AdministracionDelegate;
import edu.uade.apd.tpo.repository.stub.RolStub;
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
		frmCrearUsuario.setBounds(90, 90, 660, 640);
		frmCrearUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearUsuario.getContentPane().setLayout(null);

		JLabel lblEmail = new JLabel("Correo electrónico:");
		lblEmail.setBounds(6, 87, 300, 16);
		frmCrearUsuario.getContentPane().add(lblEmail);

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


		String[] rolString = { "Todos", "Administración", "Deposito" , "Despacho" , "Factuación" , "Compras", "Cientes"};
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
		btnGuardar.setBounds(537, 570, 117, 29);
		frmCrearUsuario.getContentPane().add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(408, 570, 117, 29);
		frmCrearUsuario.getContentPane().add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
			RolStub rol = RolStub.getRolFromValue(rolString);

			adm.crearUsuario(email, password, rol);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}


package edu.uade.apd.tpo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.uade.apd.tpo.repository.AdministracionDelegate;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AgregarItem {

	private JFrame frmAgregarItem;
	private JTextField txtIdPedido;
	private JLabel lblidArticulo;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnCancelar;
	private JComboBox comboArticulo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarItem window = new AgregarItem();
					window.frmAgregarItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
		 * Create the application.
		 */
		public AgregarItem() {
			initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarItem = new JFrame();
		frmAgregarItem.setResizable(false);
		frmAgregarItem.setTitle("Agregar Item al pedido | Das Verrückte Lagerhaus");
		frmAgregarItem.setBounds(100, 100, 660, 640);
		frmAgregarItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarItem.getContentPane().setLayout(null);

		JLabel idPedido = new JLabel("Numero de pedido: ");
		idPedido.setBounds(6, 62, 300, 16);
		frmAgregarItem.getContentPane().add(idPedido);

		txtIdPedido = new JTextField();
		txtIdPedido.setBounds(6, 82, 300, 26);
		frmAgregarItem.getContentPane().add(txtIdPedido);
		txtIdPedido.setColumns(10);

		JLabel lblidArticulo = new JLabel("Articulo: ");
		lblidArticulo.setBounds(16, 120, 300, 16);
		frmAgregarItem.getContentPane().add(lblidArticulo);

        //TODO aca van los articulos posta
		String[] articulos = { "Arvejas", "Leche", "yerba" };
		comboArticulo = new JComboBox(articulos);
		comboArticulo.setBounds(6, 148, 300, 27);
		frmAgregarItem.getContentPane().add(comboArticulo);

		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(341, 120, 61, 16);
		frmAgregarItem.getContentPane().add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(341, 147, 300, 26);
		frmAgregarItem.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);


		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(537, 570, 117, 29);
		frmAgregarItem.getContentPane().add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
				
			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(408, 570, 117, 29);
		frmAgregarItem.getContentPane().add(btnCancelar);
		
		JLabel lblAgregarItemA = new JLabel("Agregar item a pedido");
		lblAgregarItemA.setBounds(6, 17, 300, 16);
		frmAgregarItem.getContentPane().add(lblAgregarItemA);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO fix del flujo de navegacion
				frmAgregarItem.dispose();
			}
		});
	}

	private void guardar() {
		try {
			AdministracionDelegate adm = AdministracionDelegate.getInstance();

			String idPedido = txtIdPedido.getText();
			long pedidoId = Long.parseLong(idPedido);
			String idArticulo= comboArticulo.getSelectedItem().toString();
			Long articuloId = Long.parseLong(idArticulo);
			String cant = txtCantidad.getText();
			Integer cantidad = Integer.valueOf(cant);
				
			adm.agregarItemPedido(pedidoId, articuloId, cantidad);


		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

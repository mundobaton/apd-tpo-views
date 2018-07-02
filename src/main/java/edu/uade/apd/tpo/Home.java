package edu.uade.apd.tpo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home {

	private JFrame frmHome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() {

		frmHome = new JFrame();
		frmHome.setResizable(false);
		frmHome.setTitle("Das Verrückte Lagerhaus");
		frmHome.setBounds(100, 100, 660, 500);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);

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
		
		String path = new File("src/main/resources/logo.png").getAbsolutePath();
		JLabel lbl = new JLabel(new ImageIcon(path));
		lbl.setBounds(180, 30, 300, 191);
		frmHome.getContentPane().add(lbl);

		listarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientes listarClientes = new ListarClientes();
				listarClientes.setVisible(true);
				frmHome.dispose();
			}
		});

		crearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente crearCliente = new CrearCliente();
				crearCliente.setVisible(true);
				frmHome.dispose();
			}
		});

		crearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario crearUsuario = new CrearUsuario();
				crearUsuario.setVisible(true);
				frmHome.dispose();
			}
		});

		listarPedidosPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPedidosPendientes listarPedidosPendientes = new ListarPedidosPendientes();
				listarPedidosPendientes.setVisible(true);
				frmHome.dispose();
			}
		});
		
		jmiExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.dispose();
			}
		});
		
		frmHome.setJMenuBar(jmb);
		frmHome.setVisible(true);

	}

	public void setVisible(boolean isVisible) {
		this.frmHome.setVisible(isVisible);
	}

}

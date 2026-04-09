package pasta_alfredo_con_camaron;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame{

	public Ventana() {
		
		//CONFIGURACIONES BÁSICAS 
		this.setSize(1000, 620); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(200,200));
		this.setMaximumSize(new Dimension(1000,800));
		this.setLocationRelativeTo(null);
		this.setTitle("Hola");
		this.setLayout(null); 
		this.getContentPane().setBackground(Color.gray); 

		
		try {
			Image iconImage = ImageIO.read(getClass().getResource("/images/Agumon_Black_X.png"));
	        this.setIconImage(iconImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.menu();
		
		this.router("login");
		
		this.setVisible(true);
		this.repaint();
		
	}
	
	public void router(String target)
	{
		this.getContentPane().removeAll();
		
		if(target.equals("login"))
			this.login();
		
		if(target.equals("registro"))
			this.registro();
		
		if(target.equals("forgot"))
			this.recuperarContrasena();

		if(target.equals("altaUsuario"))
        this.altaUsuario();
    
		if(target.equals("bajaUsuario"))
			this.bajaUsuario();
		
		if(target.equals("consultarUsuario"))
			this.consultarUsuario();
		
		if(target.equals("ayudaCrear"))
			this.ayudaCrearUsuario();
		
		if(target.equals("ayudaAcceso"))
			this.ayudaAccesoSistema();
		
		if(target.equals("ayudaRecuperar"))
        this.ayudaRecuperarContrasena();
		
		this.repaint();
		this.revalidate();
	}
	
	public void login()
	{
		
		JTextField textField;
		JPasswordField passwordField;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255)); 
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600); 
		
		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(36, 186, 353, 81);
		lblNewLabel_8.setBorder(BorderFactory.createTitledBorder("Correo electrónico"));
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBackground(new Color(218, 230, 225));
		textField.setBounds(49, 211, 328, 42);
		panel.add(textField);
		textField.setBorder(new LineBorder(new Color(91, 253, 255), 1, true));
		textField.setBorder(null);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(218, 230, 225));
		passwordField.setBounds(49, 300, 295, 42);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setOpaque(true);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String passText = new String(passwordField.getPassword());
				Boolean flag1 = false, flag2 = false;
				
				
				if( passText.equals("") ) {
					
					passwordField.setBorder(BorderFactory.createLineBorder(Color.red,2));
					
				}else {
					
					passwordField.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag1 = true;
				}
				
				
				if(textField.getText().equals("")) {
					textField.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}else {
					
					textField.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag2 = true;
				}
				
				if(flag1 && flag2) {
					
					if(textField.getText().equals("fake@mail.com") ) {
						if(passText.equals("12345")) {
							
							JOptionPane.showMessageDialog(null, "Bienvenido.");
							
						}else {
							JOptionPane.showMessageDialog(null, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
					}
					
					
				}
				
			}
		});
		btnNewButton.setBounds(36, 413, 341, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Sabiduría como meta, patria como destino ");
		lblNewLabel_1.setBounds(69, 73, 308, 16);
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		
		lblNewLabel_6.setIcon(new ImageIcon(this.getClass().getResource("/images/redd-francisco-9o8YdYGTT64-unsplash.jpg")));
		lblNewLabel_6.setBounds(531, 6, 383, 494);
		lblNewLabel_6.setBorder(BorderFactory.createLineBorder(Color.white,5,true));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ingresa al panel administrador");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_2_1.setBounds(49, 109, 340, 39);
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setBorder(BorderFactory.createTitledBorder("Contraseña"));
		lblNewLabel_8_1.setBounds(36, 279, 353, 81);
		panel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/images/hidden.png")));
		lblNewLabel_2.setBounds(351, 315, 24, 16);
		panel.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar contraseña");
		chckbxNewCheckBox.setBounds(36, 372, 180, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("¿Aún no tienes cuenta?");
		lblNewLabel_3.setBounds(225, 462, 152, 16);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton2 = new JButton("Crea una aquí");
		btnNewButton2.setBackground(new Color(0, 0, 0));
		btnNewButton2.setOpaque(true);
		btnNewButton2.setForeground(new Color(0, 0, 0));
		btnNewButton2.setBounds(205, 490, 200, 20);
		btnNewButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				router("registro");
				
			}});
		
		panel.add(btnNewButton2);
		
		this.add(panel);
	}
	
		public void registro() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);
		panel.setSize(1000,600);

		JLabel titulo = new JLabel("Crear Cuenta");
		titulo.setBounds(0, 40, 1000, 40);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(titulo);

		JLabel subtitulo = new JLabel("Completa el formulario para registrarte");
		subtitulo.setBounds(0, 80, 1000, 20);
		subtitulo.setHorizontalAlignment(JLabel.CENTER);
		panel.add(subtitulo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(300,130,200,20);
		panel.add(lblNombre);

		JTextField nombre = new JTextField();
		nombre.setBounds(300,150,400,35);
		nombre.setBackground(new Color(230,230,230));
		panel.add(nombre);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(300,200,200,20);
		panel.add(lblCorreo);

		JTextField correo = new JTextField();
		correo.setBounds(300,220,400,35);
		correo.setBackground(new Color(230,230,230));
		panel.add(correo);

		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setBounds(300,270,200,20);
		panel.add(lblPass);

		JPasswordField pass = new JPasswordField();
		pass.setBounds(300,290,400,35);
		pass.setBackground(new Color(230,230,230));
		panel.add(pass);

		JLabel lblPass2 = new JLabel("Confirmar contraseña:");
		lblPass2.setBounds(300,340,200,20);
		panel.add(lblPass2);

		JPasswordField pass2 = new JPasswordField();
		pass2.setBounds(300,360,400,35);
		pass2.setBackground(new Color(230,230,230));
		panel.add(pass2);

		JCheckBox aceptar = new JCheckBox("Acepto los términos y condiciones");
		aceptar.setBounds(300,410,300,30);
		panel.add(aceptar);

		JButton registrar = new JButton("Crear cuenta");
		registrar.setBounds(300,450,400,40);
		registrar.setBackground(Color.black);
		registrar.setForeground(Color.white);

		registrar.addActionListener(e -> {

			String nombreTxt = nombre.getText();
			String correoTxt = correo.getText();
			String passTxt = new String(pass.getPassword());
			String pass2Txt = new String(pass2.getPassword());

			boolean ok = true;

			if(nombreTxt.equals("")) {
				nombre.setBorder(BorderFactory.createLineBorder(Color.red,2));
				ok = false;
			} else {
				nombre.setBorder(BorderFactory.createLineBorder(Color.green,2));
			}

			if(correoTxt.equals("")) {
				correo.setBorder(BorderFactory.createLineBorder(Color.red,2));
				ok = false;
			} else {
				correo.setBorder(BorderFactory.createLineBorder(Color.green,2));
			}

			if(passTxt.equals("")) {
				pass.setBorder(BorderFactory.createLineBorder(Color.red,2));
				ok = false;
			} else {
				pass.setBorder(BorderFactory.createLineBorder(Color.green,2));
			}

			if(!passTxt.equals(pass2Txt)) {
				pass2.setBorder(BorderFactory.createLineBorder(Color.red,2));
				ok = false;
			} else {
				pass2.setBorder(BorderFactory.createLineBorder(Color.green,2));
			}

			if(!aceptar.isSelected()) {
				ok = false;
				JOptionPane.showMessageDialog(null, "Debes aceptar los términos");
			}

			if(ok) {
				JOptionPane.showMessageDialog(null, "Cuenta creada correctamente");
				this.router("login");
			}
		});

		panel.add(registrar);

		JButton volver = new JButton("Volver");
		volver.setBounds(20,20,100,30);
		volver.addActionListener(e -> this.router("login"));
		panel.add(volver);

		JButton loginBtn = new JButton("¿Ya tienes cuenta?");
		loginBtn.setBounds(400,500,200,30);
		loginBtn.addActionListener(e -> this.router("login"));
		panel.add(loginBtn);

		this.add(panel);
	}
	
	public void recuperarContrasena() {
		
		JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setSize(1000,600);
    panel.setBackground(Color.white);

    JLabel titulo = new JLabel("Recuperar Contraseña");
    titulo.setBounds(0, 40, 1000, 40);
    titulo.setHorizontalAlignment(JLabel.CENTER);
    titulo.setFont(new Font("Arial", Font.BOLD, 28));
    panel.add(titulo);

    JLabel info = new JLabel("Ingresa tu correo electrónico para recuperar tu contraseña");
    info.setBounds(250, 100, 500, 30);
    info.setHorizontalAlignment(JLabel.CENTER);
    panel.add(info);

    JLabel labelCorreo = new JLabel("Correo electrónico:");
    labelCorreo.setBounds(350, 170, 200, 20);
    panel.add(labelCorreo);

    JTextField correo = new JTextField();
    correo.setBounds(350, 200, 300, 35);
    correo.setBackground(new Color(230,230,230));
    panel.add(correo);

    JButton enviar = new JButton("Enviar enlace");
    enviar.setBounds(350, 260, 300, 40);
    enviar.setBackground(Color.black);
    enviar.setForeground(Color.white);

    enviar.addActionListener(e -> {
        if(correo.getText().equals("")) {
            correo.setBorder(BorderFactory.createLineBorder(Color.red,2));
        } else {
            correo.setBorder(BorderFactory.createLineBorder(Color.green,2));
            JOptionPane.showMessageDialog(null, "Se envió un enlace a tu correo.");
        }
    });

    panel.add(enviar);

    JButton volver = new JButton("Volver");
    volver.setBounds(20,20,100,30);
    volver.addActionListener(e -> this.router("login"));
    panel.add(volver);

    this.add(panel);
	}
	
	public void users()
	{
		JPanel panel_users = new JPanel();
		panel_users.setSize(900, 500);
		panel_users.setLocation(50, 50);
		panel_users.setBackground(Color.decode("#DDDEA6"));
		panel_users.setLayout(null);
		this.add(panel_users);
		
		String [] table_head = {"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"};
		
		Object [][] table_body = {
			    {"20231001","Carlos","Ramírez López","carlos.ramirez@correo.com","3","Ingeniería en Sistemas Computacionales","Editar"},
			    {"20231002","María","González Pérez","maria.gonzalez@correo.com","5","Ingeniería Industrial","Editar"},
			    {"20231003","Luis","Hernández Torres","luis.hernandez@correo.com","1","Licenciatura en Administración","Editar"},
			    {"20231004","Ana","Martínez Ruiz","ana.martinez@correo.com","7","Ingeniería Civil","Editar"},
			    {"20231005","Jorge","Sánchez Morales","jorge.sanchez@correo.com","4","Ingeniería Mecatrónica","Editar"},
			    {"20231006","Fernanda","Castillo Díaz","fernanda.castillo@correo.com","2","Licenciatura en Psicología","Editar"},
			    {"20231007","Diego","Vargas Romero","diego.vargas@correo.com","6","Ingeniería en Tecnologías de la Información","Editar"}
			};
		
		JTable studens = new JTable(table_body,table_head);
		
		JScrollPane final_table = new JScrollPane(studens);
		final_table.setSize(700,150);
		final_table.setLocation(100, 100);
		
		panel_users.add(final_table);
		
		panel_users.repaint();
	}
	
	public void menu()
	{
		JMenuBar barra = new JMenuBar();
		this.setJMenuBar(barra);
		
		JMenu menu1 = new JMenu("Archivo");
		barra.add(menu1);
		
		JMenuItem opt1_mi = new JMenuItem("Abrir");
		menu1.add(opt1_mi);
		
		JMenuItem opt2_mi = new JMenuItem("Nuevo");
		menu1.add(opt2_mi);
		
		JMenuItem opt3_mi = new JMenuItem("Cerrar");
		menu1.add(opt3_mi);
		
		menu1.addSeparator();
		
		JMenu menu2 = new JMenu("Guardar");
		menu1.add(menu2);
		
		JMenuItem opt4_mi = new JMenuItem("Guardar");
		menu2.add(opt4_mi);
		
		JMenuItem opt5_mi = new JMenuItem("Guardar como");
		menu2.add(opt5_mi);
		
		JMenu menu3 = new JMenu("Cuenta");
		barra.add(menu3);
		
		JMenuItem opt_access = new JMenuItem("Acceder");
		opt_access.addActionListener(e ->{
			this.router("login");
		});
		menu3.add(opt_access);
		
		JMenuItem opt_register = new JMenuItem("Registro");
		opt_register.addActionListener(e ->{
			this.router("registro");
		});
		menu3.add(opt_register);
		
		JMenuItem opt_forgot = new JMenuItem("Recuperar");
		opt_forgot.addActionListener(e ->{
			this.router("forgot");
		});
		menu3.add(opt_forgot);

			// USUARIOS
		JMenu menu4 = new JMenu("Usuarios");
		barra.add(menu4);

		JMenuItem opt_alta = new JMenuItem("Alta");
		opt_alta.addActionListener(e -> this.router("altaUsuario"));
		menu4.add(opt_alta);

		JMenuItem opt_baja = new JMenuItem("Baja");
		opt_baja.addActionListener(e -> this.router("bajaUsuario"));
		menu4.add(opt_baja);

		JMenuItem opt_consultar = new JMenuItem("Consultar");
		opt_consultar.addActionListener(e -> this.router("consultarUsuario"));
		menu4.add(opt_consultar);

		// AYUDA
		JMenu menu5 = new JMenu("Ayuda");
		barra.add(menu5);

		JMenuItem opt_crear = new JMenuItem("Crear Usuario");
		opt_crear.addActionListener(e -> this.router("ayudaCrear"));
		menu5.add(opt_crear);

		JMenuItem opt_acceso = new JMenuItem("Acceso Sistema");
		opt_acceso.addActionListener(e -> this.router("ayudaAcceso"));
		menu5.add(opt_acceso);

		JMenuItem opt_recuperar = new JMenuItem("Recuperar Contraseña");
		opt_recuperar.addActionListener(e -> this.router("ayudaRecuperar"));
		menu5.add(opt_recuperar);
		
	}
		
		public void altaUsuario()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1000,600);
		panel.setBackground(Color.white);

		JLabel titulo = new JLabel("Alta de Usuario");
		titulo.setBounds(0, 50, 1000, 40);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(titulo);

		JTextField nombre = new JTextField();
		nombre.setBounds(350,150,300,30);
		panel.add(nombre);

		JTextField correo = new JTextField();
		correo.setBounds(350,200,300,30);
		panel.add(correo);

		JButton guardar = new JButton("Guardar");
		guardar.setBounds(350,260,140,40);
		panel.add(guardar);

		JButton volver = new JButton("Volver");
		volver.setBounds(20,20,100,30);
		volver.addActionListener(e -> {
			this.router("login");
		});
		panel.add(volver);

		this.add(panel);
	}

	public void bajaUsuario()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1000,600);
		panel.setBackground(Color.white);

		JLabel titulo = new JLabel("Baja de Usuario");
		titulo.setBounds(0, 50, 1000, 40);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(titulo);

		JTextField id = new JTextField();
		id.setBounds(350,180,300,30);
		panel.add(id);

		JButton eliminar = new JButton("Eliminar");
		eliminar.setBounds(350,230,140,40);
		panel.add(eliminar);

		JButton volver = new JButton("Volver");
		volver.setBounds(20,20,100,30);
		volver.addActionListener(e -> {
			this.router("login");
		});
		panel.add(volver);

		this.add(panel);
	}

	public void consultarUsuario()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1000,600);
		panel.setBackground(Color.white);

		JLabel titulo = new JLabel("Consultar Usuario");
		titulo.setBounds(0, 50, 1000, 40);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(titulo);

		String[] columnas = {"ID","Nombre","Correo"};
		Object[][] datos = {
			{"1","Juan","juan@mail.com"},
			{"2","Ana","ana@mail.com"}
		};

		JTable tabla = new JTable(datos, columnas);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(200,150,600,200);
		panel.add(scroll);

		JButton volver = new JButton("Volver");
		volver.setBounds(20,20,100,30);
		volver.addActionListener(e -> {
			this.router("login");
		});
		panel.add(volver);

		this.add(panel);
	}

		public void ayudaCrearUsuario()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1000,600);
		panel.setBackground(Color.white);

		JLabel titulo = new JLabel("Ayuda - Crear Usuario");
		titulo.setBounds(0, 40, 1000, 40);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(titulo);

		JTextArea texto = new JTextArea(
			"- Llena todos los campos obligatorios\n" +
			"- Usa un correo válido\n" +
			"- Acepta los términos y condiciones\n" +
			"- Presiona 'Crear cuenta'"
		);
		texto.setBounds(250,150,500,200);
		texto.setEditable(false);
		texto.setBackground(new Color(245,245,245));
		texto.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.add(texto);

		JButton volver = new JButton("Volver");
		volver.setBounds(20,20,100,30);
		volver.addActionListener(e -> this.router("login"));
		panel.add(volver);

		this.add(panel);
	}

		public void ayudaAccesoSistema()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1000,600);
		panel.setBackground(Color.white);

		JLabel titulo = new JLabel("Ayuda - Acceso al Sistema");
		titulo.setBounds(0, 40, 1000, 40);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(titulo);

		JTextArea texto = new JTextArea(
			"- Ingresa tu correo registrado\n" +
			"- Escribe tu contraseña\n" +
			"- Verifica que no haya errores\n" +
			"- Presiona 'Acceder'"
		);
		texto.setBounds(250,150,500,200);
		texto.setEditable(false);
		texto.setBackground(new Color(245,245,245));
		texto.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.add(texto);

		JButton volver = new JButton("Volver");
		volver.setBounds(20,20,100,30);
		volver.addActionListener(e -> this.router("login"));
		panel.add(volver);

		this.add(panel);
	}

	public void ayudaRecuperarContrasena()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1000,600);
		panel.setBackground(Color.white);

		JLabel titulo = new JLabel("Ayuda - Recuperar Contraseña");
		titulo.setBounds(0, 50, 1000, 40);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		panel.add(titulo);

		JTextArea texto = new JTextArea("Usa tu correo para recuperar tu contraseña.");
		texto.setBounds(200,150,600,200);
		panel.add(texto);

		JButton volver = new JButton("Volver");
		volver.setBounds(20,20,100,30);
		volver.addActionListener(e -> {
			this.router("login");
		});
		panel.add(volver);

		this.add(panel);
		}


}














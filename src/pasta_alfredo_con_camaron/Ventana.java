package pasta_alfredo_con_camaron;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	public Ventana() {
		
		//CONFIGURACIONES BÁSICAS
		this.setVisible(true);
		this.setSize(1000, 800);
		//this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(200,200));
		this.setMaximumSize(new Dimension(1000,800));
		this.setLocationRelativeTo(null);
		this.setTitle("Hola");
		this.setLayout(null);
		//this.setBackground(Color.red);
		//this.setOpacity(1);
		this.getContentPane().setBackground(Color.black);
		//this.setBounds(200,200,500,500);
		
		
		try {
			Image iconImage	= ImageIO.read(getClass().getResource("/images/Agumon_Black_X.png"));
			this.setIconImage(iconImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JMenuBar barra = new JMenuBar();
		
		this.setJMenuBar(barra);
		
		JMenu menu1 = new JMenu("Archivo");
		barra.add(menu1);
		
		
		JMenuItem opt1_mi = new JMenuItem("Abrir");
		menu1.add(opt1_mi);
		JMenuItem opt2_mi = new JMenuItem("Cerrar");
		menu1.add(opt2_mi);
		JMenuItem opt3_mi = new JMenuItem("Nuevo");
		menu1.add(opt3_mi);
		
		JMenu menu2 = new JMenu("Guardar");
		menu1.add(menu2);
		
		JMenuItem opt4_mi = new JMenuItem("Guardar");
		menu2.add(opt4_mi);
		JMenuItem opt5_mi = new JMenuItem("Guardar como");
		menu2.add(opt5_mi);
		
		menu1.addSeparator();
		
		//this.login();
		//this.registro();
		//this.users();
		this.calculadora();
		this.setVisible(true);
		this.repaint();
		
	}
	
	public void login()
	{
		JPanel login_container = new JPanel();
		login_container.setSize(400, 400);
		login_container.setLocation(50, 50);
		login_container.setBackground(Color.decode("#B979E8"));
		login_container.setLayout(null);
		this.add(login_container);
		
		//AÑADIENDO ELEMENTOS
		JLabel tag_title = new JLabel();
		tag_title.setText("Bienvenido");
		tag_title.setSize(150, 30);
		tag_title.setLocation(125,20);
		tag_title.setBackground(Color.white);
		tag_title.setOpaque(true);
		tag_title.setFont(new Font("Arial",Font.PLAIN,22));
		tag_title.setVerticalAlignment(JLabel.CENTER);
		tag_title.setHorizontalAlignment(JLabel.CENTER);
		login_container.add(tag_title);
		
		JLabel tag_email = new JLabel("Correo electrónico");
		tag_email.setBounds(61,120,150, 30); 
		tag_email.setBackground(Color.white);
		tag_email.setOpaque(true);
		login_container.add(tag_email);
		
		JTextField email_input = new JTextField();
		email_input.setSize(280, 40);
		email_input.setLocation(60, 150);
		login_container.add(email_input);
		
		JLabel tag_password = new JLabel("Contraseña");
		tag_password.setBounds(61,200,150, 30); 
		tag_password.setBackground(Color.white);
		tag_password.setOpaque(true);
		login_container.add(tag_password);
		
		JPasswordField password = new JPasswordField();
		password.setSize(280, 40);
		password.setLocation(60, 230);
		login_container.add(password);
		
		JCheckBox rememberme = new JCheckBox("Hola");
		rememberme.setSize(140, 40);
		rememberme.setLocation(60, 300); 
		//rememberme.setOpaque(false); 
		login_container.add(rememberme);
		
		JButton access_btn = new JButton();
		access_btn.setText("Acceder"); 
		access_btn.setBounds(100, 350, 200, 40);
		access_btn.setFont(new Font("Arial",Font.ITALIC,18));
		login_container.add(access_btn);
	}
	
	public void registro() {
		
		JPanel rgs_container = new JPanel();
		rgs_container.setBounds(500, 50, 400, 400);
		rgs_container.setOpaque(true);
		rgs_container.setBackground(Color.green);
		rgs_container.setLayout(null);
		this.add(rgs_container);
		
		//titulo 
		
		//label name
		//input name
		
		JLabel bio_tag = new JLabel("BIO");
		bio_tag.setBounds(50,50,300,40);
		bio_tag.setHorizontalAlignment(JLabel.CENTER);
		bio_tag.setOpaque(true);
		rgs_container.add(bio_tag);
		
		JTextArea bio_text = new JTextArea();
		bio_text.setLocation(50, 100);
		bio_text.setSize(300,80);
		rgs_container.add(bio_text);
		
		//label preferences
		
		JCheckBox opt_sweet = new JCheckBox("Dulce");
		opt_sweet.setBounds(50, 200, 100, 40);
		opt_sweet.setOpaque(true);
		opt_sweet.setForeground(Color.red);
		rgs_container.add(opt_sweet);
		
		JCheckBox opt_salty = new JCheckBox("Salado");
		opt_salty.setBounds(150, 200, 100, 40);
		rgs_container.add(opt_salty);
		
		JCheckBox opt_healty = new JCheckBox("Saludable");
		opt_healty.setBounds(250, 200, 100, 40);
		rgs_container.add(opt_healty);
		
		
		//label terms 
		JRadioButton accept_terms = new JRadioButton("Acepto los términos");
		accept_terms.setBounds(50, 260, 180, 40);
		rgs_container.add(accept_terms);
		
		JRadioButton reject_terms = new JRadioButton("Rechazo los términos");
		reject_terms.setBounds(220, 260, 200, 40);
		rgs_container.add(reject_terms);
		
		ButtonGroup terms = new ButtonGroup();
		terms.add(accept_terms);
		terms.add(reject_terms); 
		
		//combo 
		String [] colonias = {"Camino real","Arcoiris","Villas del encanto","8 de octubre"};
		
		JComboBox colonias_combo = new JComboBox(colonias);
		colonias_combo.setBounds(50, 300, 300, 50);
		
		rgs_container.add(colonias_combo); 
		
		JButton register_btn = new JButton("Crear cuenta");
		register_btn.setBounds(50, 340, 300, 60);
		rgs_container.add(register_btn);
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
	
	public void calculadora() {
		JPanel panel_users = new JPanel();
		panel_users.setBounds(250, 50, 500, 900);
		panel_users.setBackground(Color.decode("#847fff"));
		panel_users.setLayout(null);
		this.add(panel_users);
		
		JLabel field = new JLabel("180.00");
		field.setBounds(10,10,480,40);
		field.setOpaque(true);
		field.setBackground(Color.white);
		field.setFont(new Font("Arial",Font.BOLD,22));
		field.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		panel_users.add(field);
		
		int cor_x = 30,cor_y = 60;
		String [] botones= {"CE","","","","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		
		for(int i = 0;i<20;i++)
		{
			JButton ce = new JButton(botones[i]);
			ce.setSize(100,100);
			ce.setLocation(cor_x,cor_y);
			
			cor_x +=110;
			panel_users.add(ce);
			
			if(cor_x>=420) {
				cor_x=30;
				cor_y+=110;
			}
		}
	}
	
}

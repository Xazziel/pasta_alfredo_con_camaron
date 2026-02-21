package pasta_alfredo_con_camaron;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	public Ventana() {
		
		//configuracion basica
		this.setVisible(true);
		this.setSize(800,500);
		//this.setLocation(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension (500,300));
		this.setMaximumSize(new Dimension (1200,1000));
		this.setLocationRelativeTo(null);
		this.setTitle("Hola soy goku");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		//this.setBounds(200, 200, 500, 500);
		
		
		JPanel login_container = new JPanel();
		login_container.setSize(360,340);
		login_container.setLocation(200,80);
		login_container.setBackground(Color.yellow);
		login_container.setLayout(null);
		this.add(login_container);
		
		//añadir elementos
		JLabel tag_title = new JLabel();
		tag_title.setText("Bienvenido");
		tag_title.setSize(360,50);
		tag_title.setLocation(0,0);
		tag_title.setBackground(Color.white);
		tag_title.setOpaque(true);
		tag_title.setFont(new Font("Arial",Font.ITALIC,30));
		tag_title.setHorizontalAlignment(JLabel.CENTER);
		tag_title.setLayout(null);
		login_container.add(tag_title);
		
		JLabel label1 = new JLabel();
		label1.setText("Correo");
		label1.setSize(300,20);
		label1.setLocation(30,80);		
		label1.setLayout(null);
		login_container.add(label1);
		
		JTextField email_input = new JTextField();
		email_input.setSize(300,20);
		email_input.setLocation(30,100);
		email_input.setBackground(Color.white);
		login_container.add(email_input);
		
		JLabel label2 = new JLabel();
		label2.setText("Contraseña");
		label2.setSize(300,20);
		label2.setLocation(30,150);
		label2.setLayout(null);
		login_container.add(label2);
		
		JTextField email_input2 = new JTextField();
		email_input2.setSize(300,20);
		email_input2.setLocation(30,170);
		email_input2.setBackground(Color.white);
		login_container.add(email_input2);
		
		
		JCheckBox rememberme = new JCheckBox("recordar contraseña");
		rememberme.setSize(200,10);
		rememberme.setLocation(40,230);
		
		login_container.add(rememberme);
		rememberme.setOpaque(false);
		
		
		
		JButton pressme = new JButton();
		pressme.setSize(200,40);
		pressme.setLocation(80,260);
		pressme.setText("Acceder");
		pressme.setFont(new Font("Arial",Font.ITALIC,18));
		login_container.add(pressme);
		
		this.repaint();
		
	
	}
	
}

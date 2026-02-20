package pasta_alfredo_con_camaron;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame{

	public Ventana() {
		
		//configuracion basica
		this.setVisible(true);
		this.setSize(800,500);
		//this.setLocation(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension (500,300));
		this.setMinimumSize(new Dimension (1200,1000));
		this.setLocationRelativeTo(null);
		this.setTitle("Hola soy goku");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		//this.setBounds(200, 200, 500, 500);
		
		//añadir elementos
		JLabel tag_title = new JLabel();
		tag_title.setText("Welcome~");
		tag_title.setSize(1200,50);
		tag_title.setLocation(0,0);
		tag_title.setBackground(Color.white);
		tag_title.setOpaque(true);
		tag_title.setFont(new Font("Arial",Font.ITALIC,30));
		tag_title.setHorizontalAlignment(JLabel.CENTER);
		this.add(tag_title);
		
	}
	
}

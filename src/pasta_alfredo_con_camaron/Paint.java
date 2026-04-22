package pasta_alfredo_con_camaron;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Paint extends JFrame {

    private DrawPanel drawPanel;
    private JSlider sliderGrosor;

    public Paint() {
        setTitle("Mini Paint Pro");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

     
        
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        toolbar.setBackground(new Color(45, 45, 45));
        toolbar.setBorder(new EmptyBorder(5, 10, 5, 10));

        JLabel lbl = new JLabel("Grosor");
        lbl.setForeground(Color.WHITE);

        sliderGrosor = new JSlider(1, 30, 5);
        sliderGrosor.setPreferredSize(new Dimension(120, 40));
        sliderGrosor.addChangeListener(e -> drawPanel.setGrosor(sliderGrosor.getValue()));

        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(e -> {
            Color nuevo = JColorChooser.showDialog(this, "Selecciona color", drawPanel.getColor());
            if (nuevo != null) {
                drawPanel.setColor(nuevo);
            }
        });

        JButton btnBrocha = new JButton("Brocha");
        btnBrocha.addActionListener(e -> drawPanel.setModoBorrador(false));

        JButton btnBorrador = new JButton("Borrador");
        btnBorrador.addActionListener(e -> drawPanel.setModoBorrador(true));

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBackground(new Color(220, 80, 80));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.addActionListener(e -> drawPanel.limpiar());

        toolbar.add(lbl);
        toolbar.add(sliderGrosor);
        toolbar.add(btnColor);
        toolbar.add(btnBrocha);
        toolbar.add(btnBorrador);
        toolbar.add(btnLimpiar);

        add(toolbar, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Paint().setVisible(true));
    }
}

class DrawPanel extends JPanel {

    private ArrayList<Linea> lineas = new ArrayList<>();
    private Point puntoAnterior;
    private int grosor = 5;
    private Color color = Color.BLACK;
    private boolean borrador = false;

    public DrawPanel() {
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                puntoAnterior = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point actual = e.getPoint();

                Color colorActual = borrador ? getBackground() : color;

                lineas.add(new Linea(puntoAnterior, actual, grosor, colorActual));
                puntoAnterior = actual;

                repaint();
            }
        });
    }

    public void setGrosor(int g) {
        grosor = g;
    }

    public void setColor(Color c) {
        color = c;
        borrador = false;
    }

    public Color getColor() {
        return color;
    }

    public void setModoBorrador(boolean estado) {
        borrador = estado;
    }

    public void limpiar() {
        lineas.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Linea l : lineas) {
            g2.setColor(l.color);
            g2.setStroke(new BasicStroke(l.grosor, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawLine(l.inicio.x, l.inicio.y, l.fin.x, l.fin.y);
        }
    }
}

class Linea {

    Point inicio;
    Point fin;
    int grosor;
    Color color;

    public Linea(Point i, Point f, int g, Color c) {
        inicio = i;
        fin = f;
        grosor = g;
        color = c;
    }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Color;

public class Ejercicio1 extends JFrame {
    Color click = Color.BLUE;
    Color click2 = Color.RED;
    JButton boton, boton2;
    JLabel etq;

    class Adaptador extends MouseAdapter implements MouseInputListener, KeyListener, ActionListener {
        @Override
        public void mouseExited(MouseEvent e) {
            setTitle("Control de Ratón");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            setTitle(String.format("Control de Ratón - (X: %d, Y: %d)", e.getXOnScreen(), e.getYOnScreen()));
        }

        @Override
        public void mousePressed(MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                boton.setBackground(click);
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                boton2.setBackground(click2);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                boton.setBackground(null);
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                boton2.setBackground(null);
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            etq.setText(String.format("<html>letra: %c<br>Código: %d<html>", e.getKeyChar(), e.getKeyCode()));
            if (e.isControlDown() && e.getKeyCode() == 67) {
                Formulario fr = new Formulario(Ejercicio1.this);
                fr.pack();
                fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                fr.setVisible(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    public Ejercicio1() {

        super("Control de Ratón");
        Adaptador adap = new Adaptador();
        this.getContentPane().addMouseMotionListener(adap);
        this.addKeyListener(adap);
        setLayout(new FlowLayout());

        etq = new JLabel("Teclas");
        etq.addKeyListener(adap);
        add(etq);

        boton = new JButton();
        boton.addMouseMotionListener(adap);
        boton.addKeyListener(adap);
        add(boton);

        boton2 = new JButton();
        boton2.addMouseMotionListener(adap);
        boton2.addKeyListener(adap);
        add(boton2);

        getContentPane().addMouseMotionListener(adap);
        getContentPane().addMouseListener(adap);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "¿cerrar el programa?", "Cerrar",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

    }
}

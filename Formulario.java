import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Formulario extends JDialog implements ItemListener, ActionListener {
    Ejercicio1 ejer1 = (Ejercicio1) this.getOwner();
    JTextField titulo;
    JComboBox colores;
    String[] color = { "naranja", "verde", "rosa", "negro" };
    Color[] colorFondo = { Color.orange, Color.GREEN, Color.pink, Color.BLACK };

    Formulario(Ejercicio1 ejer1) {
        super(ejer1, true);
        this.setLayout(new FlowLayout());

        titulo = new JTextField(10);
        add(titulo);
        titulo.addActionListener(this);

        colores = new JComboBox<String>(color);
        add(colores);
        colores.setMaximumRowCount(4);
        colores.addItemListener(this);

    }

    @Override

    public void itemStateChanged(ItemEvent e) {
        ejer1.click = colorFondo[colores.getSelectedIndex()];

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ejer1.setTitle(titulo.getText());

    }

}
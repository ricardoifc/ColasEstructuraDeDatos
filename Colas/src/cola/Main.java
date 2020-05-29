package cola;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JButton encolarButton;
    private JButton desencolarButton;
    private JButton tamañoButton;
    private JButton frenteButton;
    private JList elementos2;
    private JPanel panelMain;

    public static void main(String[] args) {


        JFrame ventana = new JFrame("Cola");
        ventana.setContentPane(new Main().panelMain);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    public Main() {
        Cola cola = new Cola();

        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Object valor = JOptionPane.showInputDialog("Ingresa el valor");
                    if(valor == null)return;
                    cola.encolar(valor);
                    elementos2.setListData(cola.getElementos());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al encolar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tamañoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El tamaño de la cola es: "+cola.size());
            }
        });
        frenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cola.size()==0){
                    JOptionPane.showMessageDialog(null, "La cola esta vacia");
                    return;
                }
                try{
                    Object dato = cola.frente();
                    JOptionPane.showMessageDialog(null, "Elemento: "+dato.toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al tomar el dato", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cola.size()==0){
                    JOptionPane.showMessageDialog(null, "La cola esta vacia");
                    return;
                }
                try{
                    Object dato = cola.desencolar();
                    elementos2.setListData(cola.getElementos());
                    JOptionPane.showMessageDialog(null, "Elemento desencolado: "+dato.toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al desencolar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

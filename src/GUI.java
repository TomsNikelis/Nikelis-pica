import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel MainPlane;
    private JPanel panel1;
    private JTextField pasutijumsField;
    private JTextField cenaField;
    private JPanel panel2;
    private JPanel panel4;
    private JPanel panel5;
    private JTextField vardsField;
    private JTextField numursField;
    private JTextField adreseField;
    private JButton bezAtlaides;
    private JList list1;
    private JPanel panel3;
    private JTextField pasutijumaNrField;
    private JButton arAtlaidi;
    private JButton nonemt;


    private String pievienotPasutijumu() {
        return null;
    }
    public GUI() {
        bezAtlaides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        arAtlaidi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nonemt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().MainPlane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

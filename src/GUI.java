import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
    private ArrayList<String> pasutijumi = new ArrayList<String>();


    private String pievienotPasutijumu() {
        String pasutijums = pasutijumsField.getText();
        String vards = vardsField.getText();
        String numurs = numursField.getText();
        String adrese = adreseField.getText();

        String galaPasutijums = pasutijums + " | " + vards + " | " + numurs + " | " + adrese + " | ";
        return galaPasutijums;
    }
    private void notiritField() {
        pasutijumsField.setText("");
        cenaField.setText("");
        vardsField.setText("");
        numursField.setText("");
        adreseField.setText("");
        pasutijumaNrField.setText("");
    }
    public GUI() {
        DefaultListModel DLM = new DefaultListModel();
        list1.setModel(DLM);
        bezAtlaides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DLM.removeAllElements();
                double cena;
                if(cenaField.getText().equals("")) {
                    cena = 0;
                } else {
                    cena = Double.parseDouble(cenaField.getText());
                }

                String pasutijums = pievienotPasutijumu();
                pasutijumi.add(pasutijums + " | " + cena + "$");

                for (int i = 0; i<pasutijumi.size(); i++) {
                    DLM.addElement((i+1) + ". " + pasutijumi.get(i));
                }
                notiritField();
            }
        });
        arAtlaidi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DLM.removeAllElements();
                double cena;
                if(cenaField.getText().equals("")) {
                    cena = 0;
                } else {
                    cena = Double.parseDouble(cenaField.getText());
                    cena = cena / 100;
                    cena = cena * 85;
                }
                String pasutijums = pievienotPasutijumu();

                DecimalFormat df = new DecimalFormat("#.##");
                String pilnaCena = df.format(cena);

                pasutijumi.add(pasutijums + " | " + pilnaCena + "$");

                for (int i = 0; i<pasutijumi.size(); i++) {
                    DLM.addElement((i+1) + ". " + pasutijumi.get(i));
                }
                notiritField();
            }
        });
        nonemt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DLM.removeAllElements();
                int pasutijumaNr;
                if(pasutijumaNrField.getText().equals("")) {
                    pasutijumaNr = 0;
                } else {
                    pasutijumaNr = Integer.parseInt(pasutijumaNrField.getText())-1;
                    if(pasutijumaNr+1 > pasutijumi.size() || pasutijumaNr < 0) {

                    } else {
                        pasutijumi.remove(pasutijumaNr);
                    }
                }

                for (int i = 0; i<pasutijumi.size(); i++) {
                    DLM.addElement((i+1) + ". " + pasutijumi.get(i));
                }
                notiritField();
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

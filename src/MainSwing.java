import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

// Application running under Java version 11 ++
public class MainSwing extends JFrame implements ActionListener {
    private String connectionstring = "." + "\\\\" + "filedata" + ".dat";
    JTextField tf1;
    JTextField tf2;
    JLabel feldName, feldNummer;
    String cols[] = new String[] { "ID", "Name", "Telefonnummer" };
    String[][] rec = { {} };

    TableModel tableModel = new DefaultTableModel(rec, cols);
    JTable tableTankstelle = new JTable();
    JScrollPane bp = new JScrollPane();
    JPanel soll = new JPanel();
    JPanel neu = new JPanel();

    public MainSwing() {

        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tf1 = new JTextField();

        tf2 = new JTextField();
        GridLayout experimentLayout = new GridLayout(3, 2);
        feldName = new JLabel("Name Neu:");
        feldNummer = new JLabel("Nummer:");
        JButton Anlegen = new JButton("Anlegen");
        JLabel dummy = new JLabel();
        JButton Updaten = new JButton("Updaten");
        neu = new JPanel();
        neu.setLayout(experimentLayout); // CATCH ALL KEYS
        tf1.setSize(120, 12);// TFT
        tf2.setSize(120, 12);

        neu.add(feldName);
        neu.add(tf1);
        neu.add(feldNummer);
        neu.add(tf2);
        Updaten.setMargin(new Insets(5, 5, 5, 5));
        Anlegen.setMargin(new Insets(5, 5, 5, 5));
        neu.add(Updaten);
        neu.add(Anlegen);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent vw) {
                System.out.println("Wird beim Speichern aufgerufen");
                try (var out = new BufferedWriter(new FileWriter(airport))) {
                    System.out.println("Oeffne Datei filedata.dat in src Ordner");
                    int j = 0;
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        j++;
                        for (var X = 0; X < tableModel.getColumnCount(); X++)

                        {
                            if (tableModel.getValueAt(i, X) != null) {
                                // zusammenpuzzeln
                                out.write(tableModel.getValueAt(i, X).toString());
                            } else
                                out.write("");
                            out.newLine();
                        }
                    }
                    System.out.println("Try schleife wird beendet ");
                    System.out.println("Row Count @= " + j);
                } catch (Exception iuo) {
                    {

                    }
                    iuo.printStackTrace();
                }
            }

            @Override
            public void windowOpened(WindowEvent vw) {
                // same with opening of Swing Window
                System.out.println("Wiederoeffnen des Fensters (Aktion?)");

                var datei = new File(airport);
                if (!datei.exists()) {
                    System.out.println("Die Datei wurde gefunden");
                    try {
                        datei.createNewFile(); // OnDisk
                    }

                    catch (IOException a) {
                        a.printStackTrace();
                    }
                    // Datei ist def. da

                }

                try (var in = new BufferedReader(new FileReader(airport))) {
                    for (var i = 0; i < tableModel.getRowCount(); i++) {
                        for (var j = 0; j < tableModel.getColumnCount(); j++) {
                            var eintragspant = in.readLine();
                            tableModel.setValueAt(eintragspant, i, j);
                        }
                    }
                } catch (Exception b) {

                    b.printStackTrace();
                }

            }

        });

        Anlegen.addActionListener(new ActionListener()

        {
            // FAST KEY SERIES
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.out.println("Fange Event");

                int neuzeilen = tableTankstelle.getModel().getRowCount() + 1;
                var model = (DefaultTableModel) tableTankstelle.getModel();
                System.out.println(neuzeilen);
                model.addRow(new String[] { String.valueOf(neuzeilen) });
                neu.revalidate();
            }
        });
        Updaten.addActionListener(new ActionListener()

        {
            // FAST KEY SERIES
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.out.println("Fange Event");
            }
        });
        this.setSize(540, 370);
        this.setLocation(300, 100);

        // tableTankstelle.setModel(tableModel);
        this.setLayout(new BorderLayout());
        JTable table = new JTable(tableModel);
        soll.add(new JScrollPane(table));

        this.add(soll, BorderLayout.CENTER);
        this.add(neu, BorderLayout.SOUTH);
        this.setResizable(false);
        // After
        this.setVisible(true);
    }

    public static void main(String[] args) {

        MainSwing obj = new MainSwing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}

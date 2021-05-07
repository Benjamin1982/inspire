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

public class MainSwing extends JFrame implements ActionListener {
    JTextField tf1;
    JTextField tf2;
    JLabel feldName, feldNummer;
    String cols[] = new String[] { "ID", "Name", "Telefonnummer" };
    String[][] rec = { { "1", "Steve", "0711-OnClassPath" }, { "2", "Virat", "0712-OnClassPath" },
            { "3", "Kane", "0778-OnClassPath" }, { "4", "David", "252552" }, { "5", "Ben", "626116" },
            { "6", "Eion", "080ß1423" },

            { "1", "Steve", "0711-OnClassPath" }, { "2", "Virat", "0712-OnClassPath" },
            { "3", "Kane", "0778-OnClassPath" }, { "4", "David", "252552" }, { "5", "Ben", "626116" },
            { "6", "Eion", "080ß1423" }, };

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
        Anlegen.addActionListener(new ActionListener()

        {
            // FAST KEY SERIES
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.out.println("Fange Event");
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

}

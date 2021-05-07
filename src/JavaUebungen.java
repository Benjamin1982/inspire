import javax.swing.JOptionPane;

public class JavaUebungen {
    // ----------------------------------------//#endregion
    private static String scandal = "SCANDAL";
    private static int master = -119;

    // ---------------------------------------- ALT GR + 8 /9
    public static void main(String[] args)

    {
        System.out.println("definitely my comupter");
        WhileLoopBook();
    }

    static void WhileLoopBook()

    {
        int roaming = 0;
        roaming = roaming + 1;
        System.out.println("definitely my comupter: " + roaming);
        while (master < 128) {
            master = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Geben Sie eine Zahl kleiner 128 im Dialog ein "));
            // 14 Shades Error
            if (master == -128)
                break;
            System.out.println("Zahl jetzt: " + master);
        }
    }
}
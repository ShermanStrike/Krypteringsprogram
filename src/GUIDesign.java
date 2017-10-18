import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Exempel på lösning till Sprint 2
 * Created by magnus on 2017-10-04.
 */
public class GUIDesign extends JFrame {
    private JLabel inputFileLabel = new JLabel("Input file");
    private JTextField inputFile = new JTextField(10);
    private JLabel keyFileLabel = new JLabel("Key file");
    private JTextField keyFile = new JTextField(10);
    private JLabel outputFileLabel = new JLabel("Output file");
    private JTextField outputFile = new JTextField(10);
    private JButton goButton = new JButton("Go");
    JRadioButton encryptButton = new JRadioButton("Encrypt");
    JRadioButton decryptButton = new JRadioButton("Decrypt");
    ButtonGroup group = new ButtonGroup();

    GUIDesign() {
        // Sets up the view and adds the components
        JPanel guiPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        guiPanel.add(inputFileLabel);
        guiPanel.add(inputFile);
        guiPanel.add(keyFileLabel);
        guiPanel.add(keyFile);
        guiPanel.add(outputFileLabel);
        guiPanel.add(outputFile);

        encryptButton.setMnemonic(KeyEvent.VK_E);
        encryptButton.setSelected(true);
        decryptButton.setMnemonic(KeyEvent.VK_D);
        group.add(encryptButton);
        group.add(decryptButton);
        guiPanel.add(encryptButton);
        guiPanel.add(decryptButton);
        guiPanel.add(goButton);

        this.add(guiPanel);
        this.pack();
        // End of setting up the components --------
    }

    public static void main(String[] args) {
        GUIDesign gui = new GUIDesign();
        gui.setVisible(true);
    }
}
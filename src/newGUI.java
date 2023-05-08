import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class newGUI extends JFrame {
    private JButton inputButton;
    private JButton outputButton;
    private JButton confirmButton;
    private JTextField inputField;
    private JTextField outputField;

    private File inputDirectory;
    private File outputDirectory;

    public newGUI() {
        super("Excel Importer");

        inputButton = new JButton("Choose Input Directory");
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(newGUI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    inputDirectory = fileChooser.getSelectedFile();
                    inputField.setText(inputDirectory.getAbsolutePath());
                }
            }
        });

        outputButton = new JButton("Choose Output Directory");
        outputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(newGUI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    outputDirectory = fileChooser.getSelectedFile();
                    outputField.setText(outputDirectory.getAbsolutePath());
                }
            }
        });

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputDirectory != null && outputDirectory != null) {
                    // Do something with the directories
                } else {
                    JOptionPane.showMessageDialog(newGUI.this, "Please choose both input and output directories.");
                }
            }
        });

        inputField = new JTextField();
        inputField.setEditable(false);

        outputField = new JTextField();
        outputField.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(inputButton);
        panel.add(inputField);
        panel.add(outputButton);
        panel.add(outputField);
        panel.add(confirmButton);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public File chooseInputDirectory() {
        inputButton.doClick();
        return inputDirectory;
    }

    public File chooseOutputDirectory() {
        outputButton.doClick();
        return outputDirectory;
    }
}
import javax.swing.*;

public class ExcelImporterGUI extends JFrame {
    private JButton inputButton;
    private JButton outputButton;
    private String inputFolderPath;
    private String outputFolderPath;

    public ExcelImporterGUI() {
        // Настройки окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Excel Importer");
        setSize(500, 200);
        setLayout(null);

        // Создание кнопки выбора входной директории
        inputButton = new JButton("Выберите входную директорию");
        inputButton.setBounds(50, 50, 200, 30);
        add(inputButton);

        // Создание кнопки выбора выходной директории
        outputButton = new JButton("Выберите выходную директорию");
        outputButton.setBounds(250, 50, 200, 30);
        add(outputButton);

        // Назначение обработчиков событий на кнопки
        inputButton.addActionListener(e -> {
            chooseInputDirectory();
        });
        outputButton.addActionListener(e -> {
            chooseOutputDirectory();
        });
    }

    private void chooseInputDirectory() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    inputFolderPath = fileChooser.getSelectedFile().getAbsolutePath();
                }
            }
        });
    }

    private void chooseOutputDirectory() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    outputFolderPath = fileChooser.getSelectedFile().getAbsolutePath();
                }
            }
        });
    }

    public String getInputFolderPath() {
        return inputFolderPath;
    }

    public String getOutputFolderPath() {
        return outputFolderPath;
    }
}

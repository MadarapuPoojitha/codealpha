import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class word extends JFrame {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public word() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        textArea = new JTextArea(10, 30);
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word count: 0");

        // Add components to the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        // Add action listener for the count button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                String[] words = text.split("\\s+");
                int wordCount = words.length;
                resultLabel.setText("Word count: " + wordCount);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                word app = new word();
                app.setVisible(true);
            }
        });
    }
}
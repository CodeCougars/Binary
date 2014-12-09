package io.github.codecougars.slzr;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by as on 09/12/14.
 */
public class BinGUIFrame extends JFrame {
    JPanel inputGroup;
    JLabel inputLabel;
    JTextField input;

    JPanel outputGroup;
    JLabel outputLabel;
    JTextField output;

    public void init() {
        setSize(420, 180);
        setName("Binary Tool");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center in the screen. http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-the-monitor-resolution

        Container window = getContentPane();
        window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));

        inputGroup = new JPanel();
        inputGroup.add(inputLabel = new JLabel());
        inputGroup.add(input = new JTextField());

        outputGroup = new JPanel();
        outputGroup.add(outputLabel = new JLabel());
        outputGroup.add(output = new JTextField());

        // Bigger font.
        Font labelFont = new Font("sans-serif", Font.BOLD, 18);
        inputLabel.setFont(labelFont);
        outputLabel.setFont(labelFont);

        // Remove borders cause they're ugly
        input.setBorder(BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        output.setBorder(BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        //inputGroup.setOpaque(true);
        //outputGroup.setOpaque(true);
        inputGroup.setBackground(new Color(82, 177, 216));
        outputGroup.setBackground(new Color(69, 193, 107));

        window.add(inputGroup);
        window.add(outputGroup);

        input.setPreferredSize(new Dimension(380, 26));
        output.setPreferredSize(new Dimension(380, 26));

        inputLabel.setText("binary input");
        outputLabel.setText("decimal output");

        input.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                onInputChange();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                onInputChange();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                onInputChange();
            }
        });

        input.setText("00110010");
    }

    private void onInputChange() {
        String inputText = input.getText();
        if (!inputText.equals("") && Binary.isValid(inputText)) {
            Binary binary = new DynamicBinary(inputText);
            output.setText(binary.toLong() + "");
        }
    }
}
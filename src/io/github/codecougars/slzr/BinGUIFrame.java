package io.github.codecougars.slzr;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by as on 09/12/14.
 */
public class BinGUIFrame extends JFrame {
    static int WINDOW_WITH = 420;
    static int WINDOW_HEIGHT = 180;
    JPanel inputGroup;
    JLabel inputLabel;
    JTextField input;

    JPanel outputGroup;
    JLabel outputLabel;
    JTextField output;

    JPanel mainPanel;
    JPanel toolsPanel;

    JButton toggleButton;

    private enum GUIState {
        BIN_TO_DEC,
        DEC_TO_BIN
    }

    Image binaryImg;
    Image decimalImg;
    ImageIcon binaryIcon;
    ImageIcon decimalIcon;

    GUIState state;

    public void init() {
        setSize(WINDOW_WITH, WINDOW_HEIGHT);
        setName("Binary Tool");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center in the screen. http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-the-monitor-resolution

        Container window = getContentPane();
        window.setLayout(new BoxLayout(window, BoxLayout.X_AXIS));
        window.setBackground(new Color(94, 120, 140));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        toolsPanel = new JPanel();
        toolsPanel.setLayout(new BoxLayout(toolsPanel, BoxLayout.Y_AXIS));

        inputGroup = new JPanel();
        inputGroup.add(inputLabel = new JLabel());
        inputGroup.add(input = new JTextField());

        outputGroup = new JPanel();
        outputGroup.add(outputLabel = new JLabel());
        outputGroup.add(output = new JTextField());

        toggleButton = new JButton();

        // Load images
        try {
            binaryImg = ImageIO.read(getClass().getResource("resources/bin.png"));
            decimalImg = ImageIO.read(getClass().getResource("resources/dec.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        binaryIcon = new ImageIcon(binaryImg.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        decimalIcon = new ImageIcon(decimalImg.getScaledInstance(32, 32, Image.SCALE_SMOOTH));

        // Bigger font.
        Font labelFont = new Font("sans-serif", Font.BOLD, 18);
        inputLabel.setFont(labelFont);
        outputLabel.setFont(labelFont);

        // Remove borders cause they're ugly
        input.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        output.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        toggleButton.setBorder(BorderFactory.createLineBorder(new Color(48, 59, 69), 1));

        toggleButton.setBackground(new Color(255, 255, 255));
        toggleButton.setSize(new Dimension(32, 32));

        // margin
        toolsPanel.setBorder(BorderFactory.createLineBorder(new Color(94, 120, 140), 3));

        mainPanel.add(inputGroup);
        mainPanel.add(outputGroup);
        toolsPanel.add(toggleButton);

        window.add(mainPanel);
        window.add(toolsPanel);

        input.setPreferredSize(new Dimension(380, 26));
        output.setPreferredSize(new Dimension(380, 26));

        setGUIState(GUIState.BIN_TO_DEC);

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

        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toggleGUIState();
            }
        });

        input.setText("00110010");
    }

    void toggleGUIState() {
        System.out.println("toggle");
        if (state == GUIState.BIN_TO_DEC) {
            setGUIState(GUIState.DEC_TO_BIN);
        }
        else {
            setGUIState(GUIState.BIN_TO_DEC);
        }
    }

    void setGUIState(GUIState s) {
        state = s;

        Color binaryColor = new Color(82, 177, 216);
        Color decimalColor = new Color(69, 193, 107);

        String inputText = input.getText();
        String outputText = output.getText();

        if (state == GUIState.BIN_TO_DEC) {
            System.out.println("to dec");
            inputLabel.setText("binary input");
            outputLabel.setText("decimal output");
            inputGroup.setBackground(binaryColor);
            outputGroup.setBackground(decimalColor);

            toggleButton.setIcon(decimalIcon);

            // Output was a Binary. Input becomes the binary.
            if (Binary.isValid(outputText))
                input.setText(new CompactBinary(outputText).toString());
            // will trigger output refresh

            System.out.println(output.getText());
        }
        else if (state == GUIState.DEC_TO_BIN) {
            System.out.println(output.getText());
            System.out.println("to bin");
            inputLabel.setText("decimal input");
            outputLabel.setText("binary output");
            inputGroup.setBackground(decimalColor);
            outputGroup.setBackground(binaryColor);

            toggleButton.setIcon(binaryIcon);

            System.out.println(new CompactBinary(Integer.parseInt(output.getText())));

            // Output was an integer, now input becomes the integer.
            if (outputText.matches("\\d+"))
                input.setText(new CompactBinary(Integer.parseInt(outputText)).toInt() + "");
        }

        inputLabel.grabFocus();
        inputLabel.requestFocus();
        inputLabel.requestFocusInWindow();
    }
    private void onInputChange() {
        if (state == GUIState.BIN_TO_DEC) {
            String inputText = input.getText();
            if (!inputText.equals("") && Binary.isValid(inputText)) {
                Binary binary = new CompactBinary(inputText);
                output.setText(binary.toLong() + "");
            }
        }
        else if (state == GUIState.DEC_TO_BIN) {
            if (input.getText().matches("\\d+")) {
                int inputInt = Integer.parseInt(input.getText());

                Binary binary = new CompactBinary(inputInt);
                output.setText(binary.toString());
            }
        }
    }
}
package ch.smartlink;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by chuong on 06/04/2016.
 */
public class Screen extends Component {
    private JPanel panel1;
    private JTextField txtKey;
    private JTextField txtValue;
    private JButton resetButton;
    private JButton encryptButton;
    private JButton decryptButton;
    private JTextArea txtOut;


    public Screen() {
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtKey.setText("");
                txtValue.setText("");
                txtOut.setText("");
            }
        });


        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decrypt();
            }
        });
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                encrypt();
            }
        });
    }

    private void decrypt() {
        txtOut.setText("");
        StringBuilder out = new StringBuilder();
        String[] values = txtValue.getText().trim().split(";");

        for (String value : values) {
            out.append(Encryptor.decrypt(value, txtKey.getText().trim())).append("\n");
        }
        txtOut.setText(out.toString());
    }
    private void encrypt() {
        txtOut.setText("");
        StringBuilder out = new StringBuilder();
        String[] values = txtValue.getText().trim().split(";");

        for (String value : values) {
            out.append(Encryptor.encrypt(value, txtKey.getText().trim())).append("\n");
        }
        txtOut.setText(out.toString());

    }
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Screen");

        frame.setContentPane(new Screen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(400, 600));
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}

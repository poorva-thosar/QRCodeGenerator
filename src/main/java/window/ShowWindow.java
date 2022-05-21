package window;

import javax.swing.*;
import java.awt.*;

public class ShowWindow {
    JFrame frame;

    public void createJFrame() {
        this.frame = new JFrame();
    }

    public void disposeJFrame() {
        frame.dispose();
    }

    public void displayQRCode(String path, String givenUrl, String shortenedUrl) throws InterruptedException {
        ImageIcon icon = new ImageIcon(path);

        JLabel label = new JLabel(icon);
        label.setIcon(icon);

        JLabel textLabel = new JLabel();
        textLabel.setText("Given URL is - " + givenUrl);

        JLabel textLabel1 = new JLabel();
        textLabel1.setText("Shortened URL is - " + shortenedUrl);

        JPanel topPanel = new JPanel(new GridLayout(2, 0));
        topPanel.add(textLabel);
        topPanel.add(textLabel1);

        JPanel centerPanel = new JPanel(new GridLayout(1, 0));
        centerPanel.add(label);
        //centerPanel.add(textLabel);

        //f = new JFrame();
        //JButton b1 = new JButton("First");
        // b3 = new JButton("Second");
        frame.add(topPanel,BorderLayout.NORTH);
//        frame.add(textLabel1,BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        //frame.add(b3,BorderLayout.SOUTH);

        //frame.add(textLabel);
        //frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

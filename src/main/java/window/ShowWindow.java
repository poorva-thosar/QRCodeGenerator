package window;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ShowWindow {
    public void displayQRCode(String path) {
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon(path);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

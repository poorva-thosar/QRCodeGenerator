package window;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ShowWindow {
    JFrame frame;

    public void createJFrame() {
        this.frame = new JFrame();
    }

    public void disposeJFrame() {
        frame.dispose();
    }

    public void displayQRCode(String path) throws InterruptedException {
        ImageIcon icon = new ImageIcon(path);
        JLabel label = new JLabel(icon);
        label.setIcon(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

package window;

import javax.swing.*;
import java.awt.*;


import java.awt.*;
import javax.swing.JFrame;

public class MyCanvas extends Canvas {

    public void paint(Graphics g) {

        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("C:\\Users\\Poorva\\Desktop\\QRDemo\\URLSpecific\\Quote.png");
        g.drawImage(i, 120,100,this);

    }
    public static void main(String[] args) {
        MyCanvas m=new MyCanvas();
        JFrame f=new JFrame();
        f.add(m);
        //f.setSize(400,400);
        f.pack();
        f.setVisible(true);
    }

}

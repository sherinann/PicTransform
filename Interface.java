import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener {
    private JButton Pic;
    private JFrame frame1;
    private Interface() {
        frame1 = new JFrame();
        frame1.setTitle("PicTransform");
        frame1.setLayout(new FlowLayout());
        frame1.setSize(400, 400);

        Pic= new JButton("Load Pic");
        Pic.addActionListener(this);

        frame1.add(Pic);

        frame1.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Pic){
            final JFileChooser fc=new JFileChooser();
            int returnVal= fc.showOpenDialog(this);
            fc.setVisible(true);
        }

    }




    public static void main(String args[]){
        Interface i = new Interface();
    }

}

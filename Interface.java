
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;


public class Interface extends JFrame implements ActionListener {
    private JButton Pic;
    private JFrame frame1;
    private File f;
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
            this.ImageSelect();
            frame1.setVisible(false);

        }

    }

    private void ImageSelect(){
        JFrame frame2=new JFrame("image");
        final JFileChooser fc=new JFileChooser();
        int returnVal= fc.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION)
            f= fc.getSelectedFile();
        try{
            BufferedImage im;
            im= ImageIO.read(new File(f.getAbsolutePath()));
            ImageIcon ic = new ImageIcon(im);
            JLabel jb= new JLabel();
            jb.setIcon(ic);
            frame2.getContentPane().add(jb,BorderLayout.CENTER);
            frame2.pack();
            jb.setVisible(true);
            fc.setVisible(true);
            frame2.setVisible(true);
        }
        catch(IOException ie){
            ie.getStackTrace();
        }
    }


    public static void main(String args[]){
        Interface i = new Interface();
    }

}

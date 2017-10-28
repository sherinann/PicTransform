
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


public class Interface1 extends JFrame implements ActionListener  {
    private JButton Pic;
    private JFrame frame1;
    private File f;
    private BufferedImage im;
    private JFrame  frame2;
    private JLabel jb;

    private Interface1() {
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

    private void display(BufferedImage img2){
        JFrame frame3=new JFrame("image");
        frame3.setSize(600,600);
        ImageIcon ic = new ImageIcon(im);
        jb= new JLabel();
        jb.setSize(400,400);
        jb.setIcon(ic);
        frame3.getContentPane().add(jb,BorderLayout.CENTER);
        frame3.pack();
        frame3.setVisible(true);
        jb.setVisible(true);
    }


    private void ImageSelect(){
        final JFileChooser fc=new JFileChooser();
        int returnVal= fc.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION)
            f= fc.getSelectedFile();
        try{
            im= ImageIO.read(new File(f.getAbsolutePath()));
            BufferedImage im5=im;
            BufferedImage im6=im;

           /* JButton jNeg=new JButton("Negative");
            add(jNeg);
            jNeg.setVisible(true);
            jNeg.addActionListener(this);
            JButton jGrey=new JButton("GreyScale");
            add(jGrey);
            jGrey.setVisible(true);
            jGrey.addActionListener(this);
            jb.setVisible(true);
            fc.setVisible(true);
            frame2.setVisible(true);
            GrayScale g= new GrayScale();
            BufferedImage img2=g.ConvertGrayScale(im5);
            this.display(img2);
            this.display(im);*/
            Negative n= new Negative();
            BufferedImage img3=n.ConvertNegative(im6);
            this.display(img3);




        }
        catch(IOException ie){
            ie.getStackTrace();
        }
    }
    protected BufferedImage getImage(){
        return im;
    }


    public static void main(String[] args){
        Interface1 i=new Interface1();

    }




}


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
    private JButton Nega;
    private JButton Gray;
    private BufferedImage imNew;

    private Interface1() {
        frame1 = new JFrame();
        frame1.setTitle("PicTransform");
        frame1.setLayout(new FlowLayout());
        frame1.setSize(400, 400);

         Nega= new JButton("Negative");
        Nega.addActionListener(this);

        frame1.add(Nega);
        Gray= new JButton("GrayScale");
        Gray.addActionListener(this);

        frame1.add(Gray);

        frame1.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Nega){
            BufferedImage imNew=this.ImageSelect();
            this.FindNegative(imNew);


        }
        else {

            BufferedImage imNew=this.ImageSelect();
            this.FindGray(imNew);
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


    public void FindNegative(BufferedImage imNew){
        Negative n= new Negative();
        BufferedImage img3=n.ConvertNegative(imNew);
        this.display(img3);


    }
    public void FindGray(BufferedImage ImNew){
        GrayScale g= new GrayScale();
        BufferedImage img2=g.ConvertGrayScale(ImNew);
        this.display(img2);
    }



    private BufferedImage ImageSelect(){
        final JFileChooser fc=new JFileChooser();
        int returnVal= fc.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION)
            f= fc.getSelectedFile();
        try{
            im= ImageIO.read(new File(f.getAbsolutePath()));
        }
        catch(IOException ie){
            ie.getStackTrace();
        }
        return im;
    }
    protected BufferedImage getImage(){
        return im;
    }


    public static void main(String[] args){
        Interface1 i=new Interface1();

    }




}

import java.awt.image.BufferedImage;

class Negative   {


    public BufferedImage ConvertNegative(BufferedImage img){
        int width = img.getWidth();
        int height=img.getHeight();
        int i,j;
        for(i=0;i< width;i++){
            for(j=0;j<height;j++) {
                int p=img.getRGB(i,j);
                int a=(p>>>24)&0xff;
                int r=(p>>>16)&0xff;
                int g=(p>>>8)&0xff;
                int b=p&0xff;
                r=255-r;
                g=255-g;
                b=255-b;
                p=(a<<24)|(r<<16)|(g<<8)|b;
                img.setRGB(i,j,p);
            }
        }

        return img;
    }


}

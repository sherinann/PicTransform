import java.awt.image.BufferedImage;

class GrayScale{

    public BufferedImage ConvertGrayScale(BufferedImage img){
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
                int avg=(r+b+g)/3;
                p=(a<<24)|(avg<<16)|(avg<<8)|avg;
                img.setRGB(i,j,p);
            }
        }
    return img;
    }

}

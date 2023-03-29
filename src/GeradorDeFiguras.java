import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.BasicStroke;

import javax.imageio.ImageIO;

public class GeradorDeFiguras {
    
    public void cria(InputStream inputStream, int qntStars, String nomeArquivo) throws Exception{

        
        BufferedImage imgOrigin = ImageIO.read(inputStream);

        int largura = imgOrigin.getWidth();
        int altura = imgOrigin.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //Copia a imagem Original em nova Imagem (Em Memória)
        Graphics2D graphics = (Graphics2D) novaImg.getGraphics();
        graphics.drawImage(imgOrigin, 0, 0, null);

        //Configurar fonte texto
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        var outlineStroke = new BasicStroke(largura * 0.004f);
        graphics.setStroke(outlineStroke);

        //Escreve uma frase na nova IMAGEM
        int divisorStar = largura / qntStars;
        int proximaStar = 0;
        for(int i = 0; i < qntStars; i++){
            graphics.drawString("⭐",  proximaStar, novaAltura - 100);
            proximaStar = proximaStar + divisorStar;
        }
       

        ImageIO.write(novaImg, "png", new File("saida/" + nomeArquivo));

    }

}

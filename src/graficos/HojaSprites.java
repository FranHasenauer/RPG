package graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class HojaSprites {
    private int ancho;
    private int alto;
    public final int[] pixeles;
    //Coleccion de hojas de sprites
    public static HojaSprites desierto;

    static {
        try {
            desierto = new HojaSprites("/texturas/desierto.png", 320   , 320);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //Fin de la coleccion

    public HojaSprites(final String ruta, final int ancho, final int alto) throws IOException {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho * alto];


        BufferedImage imagen;
        try {
            imagen = ImageIO.read(Objects.requireNonNull(HojaSprites.class.getResource(ruta)));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int obtenAncho() {
        return ancho;
    }
}

package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ImageReader {
    ImageReader() {}
    public static BufferedImage readImage(String path) throws IOException { // read the image
        // A képfájlt az osztályútvonalon keresztül olvassuk be
        URL resource = Main.class.getClassLoader().getResource(path);
        if (resource == null) {
            throw new IOException("Nem sikerült elérni a fájlt: " + path);
        }
        try {
            // Az getResource().toURI() hozzáadása a fájlkezeléshez, ha az alkalmazás futtatható JAR-ként
            return ImageIO.read(resource.toURI().toURL());
        } catch (URISyntaxException e) {
            throw new IOException("Hibás URI: " + e.getMessage());
        }
    }
}

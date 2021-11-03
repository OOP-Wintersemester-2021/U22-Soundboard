import de.ur.mi.oop.audio.AudioClip;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.GraphicsObject;
import de.ur.mi.oop.graphics.Image;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class SoundBoardElement extends GraphicsObject {

    // Bestandteile eines SoundboardElements:
    private Rectangle background;
    private Image icon;
    private Label text;
    private String name;
    private AudioClip sound;

    public SoundBoardElement(String name, String imagePath, String audioPath, float width, float height) {
        this(name, imagePath, audioPath, 0, 0, width, height);
    }

    public SoundBoardElement(String name, String imagePath, String audioPath, float x, float y, float width, float height) {
        super(x, y, width, height, Colors.GREY);
        // width und height sowie x und y werden leicht verkleinert, um weiße Ränder zwischen den Elementen zu erzeugen:
        width = width-2;
        height = height - 2;
        x = x + 2;
        y = y + 2;

        initializeParts(name, imagePath, x, y, width, height);
        sound = new AudioClip(audioPath);
    }

    /*
        In der initializeParts-Methode werden die Grafik-Objekte initialisiert, die zusammen das Soundboard-Element
        bilden.
     */
    private void initializeParts(String name, String imagePath, float x, float y, float width, float height) {
        this.background = new Rectangle(x, y, width, height, Colors.GREY);
        this.name = name;
        this.text = new Label(0, height -5, name, Colors.WHITE);
        // Der Text wird ungefähr in die Mitte des Elements verschoben.
        text.setXPos(width / 2 - 25);
        this.icon = new Image(x, y, imagePath);
        // Das Bild nimmt 9/10 der gesamten Karte ein und wird entsprechend skaliert.
        icon.setHeight((height / 10) * 9, true);
        icon.setWidth((width / 10) * 9, true);
        // Das Bild wird in die Mitte des Bereichs oberhalb des Textes verschoben.
        icon.setXPos((width - icon.getWidth()) / 2);
        icon.setYPos(((height - text.getHeightEstimate()) - icon.getHeight()) / 2);
    }

    @Override
    public void draw() {
        background.draw();
        icon.draw();
        text.draw();
    }

    // Falls mouseX und mouseY innerhalb der der Spalte und der Reihe des Elements sind wird true zurückgegeben.
    @Override
    public boolean hitTest(float mouseX, float mouseY) {
        if(checkXCollision(mouseX) && checkYCollision(mouseY)) {
            return true;
        }
        return false;
    }

    @Override
    public void setPosition(float x, float y) {
        setXPos(x);
        setYPos(y);
    }

    /*
        Die x-Position wird gesetzt in dem die Veränderung der x-Position berechnet wird und die Elemente dann
        dieser Differenz entsprechend bewegt werden.
        So bleiben die relativen Positionen der Teile zu einander erhalten.
     */
    @Override
    public void setXPos(float x) {
        float dx = x - this.getXPos();
        super.setXPos(x);
        background.move(dx, 0);
        icon.move(dx, 0);
        text.move(dx, 0);
    }

    /*
        Die y-Position wird gesetzt in dem die Veränderung der y-Position berechnet wird und die Elemente dann
        dieser Differenz entsprechend bewegt werden.
        So bleiben die relativen Positionen der Teile zu einander erhalten.
     */
    @Override
    public void setYPos(float y) {
        float dy = y - this.getYPos();
        super.setYPos(y);
        background.move(0, dy);
        icon.move(0, dy);
        text.move(0, dy);
    }

    /*
        checkYCollision gibt true zurück, wenn sich der übergebene y-Positionswert in dem Korridor befindet der von
        der oberen und unteren Kante des Elements aufgespannt wird.
        Dieser Korridor ergibt sich aus der y-Position des Elements (obere Kante) und der y-Position + der Höhe (untere
        Kante).
        Das entspricht: true, falls der übergeben Wert in der gleichen Reihe wie das Element ist, sonst false.
     */
    private boolean checkYCollision(float mouseY) {
        if(mouseY >= this.getYPos() && mouseY <= this.getYPos() + this.getHeight()) {
            return true;
        }
        return false;
    }

    /*
        checkXCollision gibt true zurück wenn sich der übergebene x-Positionswert in dem Korridor befindet, der von der
        linken und rechten Kante des Elements aufgespannt wird.
        Der linke Rand ergibt sich aus der x-Position des Elements, der rechte Rand aus der x-Position + der Breite des
        Elements.
        Das entspricht: true falls der übergebene Wert in der gleichen Spalte ist wie das Element, sonst false.
     */
    private boolean checkXCollision(float mouseX) {
        if(mouseX >= this.getXPos() && mouseX <= this.getXPos() + this.getWidth()) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void playSound()  {
        sound.play();
    }
}

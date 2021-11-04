import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class SoundboardApp extends GraphicsApp {
    // Private Konstanten
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 30;

    // Das Soundboard-Objekt übernimmt die Darstellung des und Interaktion mit dem Soundboard.
    private Soundboard soundboard;


    /*
        Die initialize-Methode wird einmalig zum Start der Anwendung ausgeführt.
        Hier wird die GraphicsApp-Umgebung angepasst und das Soundboard initialisiert.
     */
    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        setFrameRate(FRAME_RATE);
        soundboard = new Soundboard(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    // Die draw-Methode wird 30 mal in der Sekunde aufgerufen.
    @Override
    public void draw() {
        soundboard.draw();
    }

    /*
        Die onKeyPressed-Methode wird aufgerufen, wenn ein Knopf auf der Tastatur gedrückt wird.
        Dann wird der mit dem Knopf korrespondierende Character an die playSoundForKeyChar-Methode des Soundboards
        übergeben.
     */
    @Override
    public void onKeyPressed(KeyPressedEvent keyPressedEvent) {
        char keyChar = keyPressedEvent.getKeyChar();
        soundboard.playSoundForKeyChar(keyChar);
    }

    /*
        Die onMousePressed-Methode wird aufgerufen, wenn in den Canvas geklickt wird.
        Die x- und y-Position des Klicks wird dann an das Soundboard übergeben, wo das angeklickte Element ermittelt
        wird.
     */
    @Override
    public void onMousePressed(MousePressedEvent mousePressedEvent) {
        float mouseX = mousePressedEvent.getXPos();
        float mouseY = mousePressedEvent.getYPos();
        soundboard.onSoundboardClicked(mouseX, mouseY);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}

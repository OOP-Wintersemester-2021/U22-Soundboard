import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class SoundboardApp extends GraphicsApp {
    // Private Konstanten
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 30;

    // Die initialize-Methode wird einmalig zum Start der Anwendung ausgeführt.
    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        setFrameRate(FRAME_RATE);
    }

    // Die draw-Methode wird 30 mal in der Sekunde aufgerufen.
    @Override
    public void draw() {

    }

    // Die onKeyPressed-Methode wird aufgerufen, wenn ein Knopf auf der Tastatur gedrückt wird.
    @Override
    public void onKeyPressed(KeyPressedEvent keyPressedEvent) {
        // React to KeyPressedEvent
    }

    // Die onMousePressed-Methode wird aufgerufen, wenn in den Canvas geklickt wird.
    @Override
    public void onMousePressed(MousePressedEvent mousePressedEvent) {
        // React to mousePressedEvent
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}

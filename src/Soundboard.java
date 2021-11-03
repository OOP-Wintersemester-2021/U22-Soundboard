import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class Soundboard extends GraphicsApp implements Config{
    // Private statische Konstanten
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 30;

    private static final int ELEMENTS_PER_ROW = 3;
    private static final int ELEMENTS_PER_COLUMN = 3;
    private static final float ELEMENT_WIDTH = CANVAS_WIDTH/ELEMENTS_PER_ROW;
    private static final float ELEMENT_HEIGHT = CANVAS_HEIGHT/ELEMENTS_PER_COLUMN;

    // In diesem zweidimensionalen Array werden die Elemente, die gezeichnet werden sollen abgelegt.
    private SoundBoardElement[][] elements;

    /*
        Die initialize-Methode wird einmalig zum Start der Anwendung ausgeführt.
        Hier wird die GraphicsApp-Umgebung angepasst und das zweidimensionale Array initialisiert.
     */
    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        setFrameRate(FRAME_RATE);
        elements = new SoundBoardElement[ELEMENTS_PER_ROW][ELEMENTS_PER_COLUMN];

        initializeElements();
        setElementPositions();
    }

    /*
        In der initializeElements-Methode werden die Instanzen der SoundBoardElement-Klasse erzeugt.
        Dabei werden neben Breite und Höhe auch der anzuzeigende Text und der Pfad zum Bild sowie der Pfad zum
        dazu gehörigen Sound übergeben.
        Die Elemente werden alle erstmal an der Position 0, 0 erzeugt.
     */
    private void initializeElements() {
        elements[0][0] = new SoundBoardElement("Hund", DOG_IMAGE_PATH, DOG_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[0][1] = new SoundBoardElement("Katze", CAT_IMAGE_PATH, CAT_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[0][2] = new SoundBoardElement("Bär", BEAR_IMAGE_PATH, BEAR_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[1][0] = new SoundBoardElement("Löwe", LION_IMAGE_PATH, LION_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[1][1] = new SoundBoardElement("Grille", CRICKET_IMAGE_PATH, CRICKET_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[1][2] = new SoundBoardElement("Vogel", BIRD_IMAGE_PATH, BIRD_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[2][0] = new SoundBoardElement("Pferd", HORSE_IMAGE_PATH, HORSE_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[2][1] = new SoundBoardElement("Schwein", PIG_IMAGE_PATH, PIG_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[2][2] = new SoundBoardElement("Elefant", ELEFANT_IMAGE_PATH, ELEPHANT_SOUND_PATH, ELEMENT_WIDTH, ELEMENT_HEIGHT);
    }

    /*
        In der setElementPositions-Methode werden die Elemente an die richtige Stelle verschoben.
        Dazu wird in einer verschachtelten for-Schleife jedes Element entsprechend seiner Position im Array richtig auf
        dem Canvas positioniert.
        So landet das Element an Position [0][1] an der y-Position 0*ELEMENT_HEIGHT = 0 und x-Position 1*ELEMENT_WIDTH
        beziehungsweise das Element an der Array-Position [2][2] an der y-Position 2*ELEMENT_HEIGHT und x-Position
        2*ELEMENT_WIDTH, dadurch überlappen sich die Elemente nicht.
     */
    private void setElementPositions() {
        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                float xPos = j * ELEMENT_WIDTH;
                float yPos = i * ELEMENT_HEIGHT;
                elements[i][j].setPosition(xPos, yPos);
            }
        }
    }

    /*
        Die draw-Methode wird 60 mal in der Sekunde aufgerufen.
        Hier wird jedes Element im Array einmal gezeichnet indem mit einer doppelten for-Schleife, jedes Element im
        2D-Array einmal besucht wird.
     */
    @Override
    public void draw() {
        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                elements[i][j].draw();
            }
        }
    }

    /*
        Die onMousePressed-Methode wird aufgerufen, wenn in den Canvas geklickt wird.
        Dann wird überprüft, welches Element sich an der x- und y-Position des Klicks befindet und von dem entsprechenden
        Element die playSound-Mehtode aufgerufen.
        Dazu wird jedes Element im 2D-Array einmal besucht und mit hitTest überprüft, ob es getroffen wurde.
        Wurde ein passendes Element gefunden, müssen die restlichen nicht meher besucht werden. Die Methode wird mit
        return verlassen.
     */
    @Override
    public void onMousePressed(MousePressedEvent mousePressedEvent) {
        float mouseX = mousePressedEvent.getXPos();
        float mouseY = mousePressedEvent.getYPos();
        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                if(elements[i][j].hitTest(mouseX, mouseY)){
                    elements[i][j].playSound();
                    return;
                }
            }
        }
    }

    /*
        Die onKeyPressed-Methode wird aufgerufen, wenn ein Knopf auf der Tastatur gedrückt wird.
        Dann wird der mit dem Knopf korrespondierende Character an die playSoundForKeyChar-Methode übergeben.
     */
    @Override
    public void onKeyPressed(KeyPressedEvent keyPressedEvent) {
        char keyChar = keyPressedEvent.getKeyChar();
        playSoundForKeyChar(keyChar);
    }

    /*
        Diese Methode überprüft, ob es ein SoundboardElement gibt, dessen Name mit dem übergebenen Buchstaben beginnt.
        Falls ja wird der Sound, der in diesem Element steckt abgespielt.
        Dazu wird durch Character.toLowerCase(<>) sichergestellt, dass beide Buchstaben Kleinbuchstaben sind, da nur so
        eine Überprüfung auf Gleichheit möglich ist.
        Das 2D-Array wird durchlaufen und der Name jedes Elements in currName zwischengespeichert. Dann wird der erste
        Buchstabe dieses Strings durch currName.charAt(0) extrahiert und in einen Kleinbuchstaben umgewandelt. Dieser
        wird dann mit dem übergebenen Buchstaben verglichen und bei Gleichheit der Sound abgespielt.
        Wurde ein passendes Element gefunden, muss nicht weiter gesucht werden und die Methode kann per return verlassen
        werden.
     */
    private void playSoundForKeyChar(char keyChar) {
        keyChar = Character.toLowerCase(keyChar);
        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                String currName = elements[i][j].getName();
                char currChar = currName.charAt(0);
                currChar = Character.toLowerCase(currChar);
                if(currChar == keyChar) {
                    elements[i][j].playSound();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }

}

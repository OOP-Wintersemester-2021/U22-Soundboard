import java.net.Socket;

public class Soundboard {
    // Private statische Konstanten
    private static final int ELEMENTS_PER_ROW = 3;
    private static final int ELEMENTS_PER_COLUMN = 3;

    // Das SoudboardView-Objekt kümmert sich um die Darstellung des Soundboards.
    private SoundboardView view;

    // In diesem zweidimensionalen Array werden die Elemente, die gezeichnet werden sollen abgelegt.
    private SoundBoardElement[][] elements;

    public Soundboard(int canvasWidth, int canvasHeight) {
        initialize(canvasWidth, canvasHeight);
    }

    /*
        Die initialize-Methode wird einmalig zum Start der Anwendung ausgeführt.
        Hier wird das zweidimensionale Array initialisiert und das View Objekt mit allen notwendigen Daten zur
        Darstellung erzeugt.
     */
    private void initialize(int canvasWidth, int canvasHeight) {
        elements = new SoundBoardElement[ELEMENTS_PER_ROW][ELEMENTS_PER_COLUMN];
        view = new SoundboardView(elements, canvasWidth, canvasHeight, ELEMENTS_PER_ROW, ELEMENTS_PER_COLUMN);
    }

   public void draw() {
        view.draw();
   }

    /*
        Es wird überprüft welches Element sich an der x- und y-Position des Klicks befindet und von dem entsprechenden
        Element die playSound-Mehtode aufgerufen.
        Dazu wird jedes Element im 2D-Array einmal besucht und mit hitTest überprüft, ob es getroffen wurde.
        Wurde ein passendes Element gefunden, müssen die restlichen nicht meher besucht werden. Die Methode wird mit
        return verlassen.
     */
    public void onSoundboardClicked(float mouseX, float mouseY) {
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
    public void playSoundForKeyChar(char keyChar) {
        keyChar = Character.toLowerCase(keyChar);
        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                char currChar = getCurrChar(elements[i][j]);
                if(currChar == keyChar) {
                    elements[i][j].playSound();
                    return;
                }
            }
        }
    }

    // Die getCurrChar-Methode gibt den ersten Buchstaben des Namens des übergebenen Elements als Kleinbuchstaben zurück.
    private char getCurrChar(SoundBoardElement soundBoardElement) {
        if(soundBoardElement == null) {
            return '\0';
        }
        String currName = soundBoardElement.getName();
        char currChar = currName.charAt(0);
        currChar = Character.toLowerCase(currChar);
        return currChar;
    }

}

public class SoundboardView {

    // In diesem 2D-Array werden, die zu zeichnenden Elemente abgelegt.
    private SoundBoardElement[][] elements;

    private int elementsPerRow;
    private int elementsPerColumn;

    /*
        Bei der Erzeugung eines SoundboardView-Objekts wird ein leeres Elements Array übergeben, dass dann befüllt wird.
        Da Arrays Referenz-Datentypen sind, sind das Array in der Soundboard-Klasse und das Array in der SoundboardView-
        Klasse das gleiche Array (und keine Kopie).
     */
    public SoundboardView(SoundBoardElement[][] elements, float canvasWidth, float canvasHeight, int elementsPerRow, int elementsPerColumn) {
        this.elements = elements;
        this.elementsPerColumn = elementsPerColumn;
        this.elementsPerRow = elementsPerRow;
        initializeElements(canvasWidth, canvasHeight);
    }

    /*
        In der initializeElements-Methode werden die Instanzen der SoundBoardElement-Klasse erzeugt.
        Dabei werden neben Breite und Höhe auch der anzuzeigende Text und der Pfad zum Bild sowie der Pfad zum
        dazu gehörigen Sound übergeben.
        Die Elemente werden alle erstmal an der Position 0, 0 erzeugt.
        Die Breite und Höhe der Elemente wird aus der Zahl der Elemente pro Reihe/Spalte und der Breite/Höhe der
        Zeichenfläche berechnet.
     */
    private void initializeElements(float canvasWidth, float canvasHeight) {
        float elementWidth = canvasWidth/elementsPerRow;
        float elementHeight = canvasHeight/elementsPerColumn;
        elements[0][0] = new SoundBoardElement("Hund", Constants.DOG_IMAGE_PATH, Constants.DOG_SOUND_PATH, elementWidth, elementHeight);
        elements[0][1] = new SoundBoardElement("Katze", Constants.CAT_IMAGE_PATH, Constants.CAT_SOUND_PATH, elementWidth, elementHeight);
        elements[0][2] = new SoundBoardElement("Bär", Constants.BEAR_IMAGE_PATH, Constants.BEAR_SOUND_PATH, elementWidth, elementHeight);
        elements[1][0] = new SoundBoardElement("Löwe", Constants.LION_IMAGE_PATH, Constants.LION_SOUND_PATH, elementWidth, elementHeight);
        elements[1][1] = new SoundBoardElement("Grille", Constants.CRICKET_IMAGE_PATH, Constants.CRICKET_SOUND_PATH, elementWidth, elementHeight);
        elements[1][2] = new SoundBoardElement("Vogel", Constants.BIRD_IMAGE_PATH, Constants.BIRD_SOUND_PATH, elementWidth, elementHeight);
        elements[2][0] = new SoundBoardElement("Pferd", Constants.HORSE_IMAGE_PATH, Constants.HORSE_SOUND_PATH, elementWidth, elementHeight);
        elements[2][1] = new SoundBoardElement("Schwein", Constants.PIG_IMAGE_PATH, Constants.PIG_SOUND_PATH, elementWidth, elementHeight);
        elements[2][2] = new SoundBoardElement("Elefant", Constants.ELEFANT_IMAGE_PATH, Constants.ELEPHANT_SOUND_PATH, elementWidth, elementHeight);
        setElementPositions(elementWidth, elementHeight);
    }

    /*
        In der setElementPositions-Methode werden die Elemente an die richtige Stelle verschoben.
        Dazu wird in einer verschachtelten for-Schleife jedes Element entsprechend seiner Position im Array richtig auf
        dem Canvas positioniert.
        So landet das Element an Position [0][1] an der y-Position 0*ELEMENT_HEIGHT = 0 und x-Position 1*ELEMENT_WIDTH
        beziehungsweise das Element an der Array-Position [2][2] an der y-Position 2*ELEMENT_HEIGHT und x-Position
        2*ELEMENT_WIDTH, dadurch überlappen sich die Elemente nicht.
     */
    private void setElementPositions(float elementWidth, float elementHeight) {
        for (int i = 0; i < elementsPerColumn; i++) {
            for (int j = 0; j < elementsPerRow; j++) {
                float xPos = j * elementWidth;
                float yPos = i * elementHeight;
                elements[i][j].setPosition(xPos, yPos);
            }
        }
    }

    /*
       Hier wird jedes Element im Array einmal gezeichnet indem mit einer doppelten for-Schleife, jedes Element im
       2D-Array einmal besucht wird.
    */
    public void draw() {
        for (int i = 0; i < elementsPerColumn; i++) {
            for (int j = 0; j < elementsPerRow; j++) {
                elements[i][j].draw();
            }
        }
    }

}

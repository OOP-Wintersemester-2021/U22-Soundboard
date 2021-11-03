import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class Soundboard extends GraphicsApp {
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 30;
    private static final int ELEMENTS_PER_ROW = 3;
    private static final int ELEMENTS_PER_COLUMN = 3;
    private static final float ELEMENT_WIDTH = CANVAS_WIDTH/ELEMENTS_PER_ROW;
    private static final float ELEMENT_HEIGHT = CANVAS_HEIGHT/ELEMENTS_PER_COLUMN;

    // Foto von Pexels, Pixabay, Pixabay License.
    private static final String BEAR_IMAGE_PATH = "src/img/bear.jpg";
    // Foto von JillWellington, Pixabay, Pixabay License.
    private static final String BIRD_IMAGE_PATH = "src/img/bird.jpg";
    // Foto von susannp4, Pixabay, Pixabay License.
    private static final String CAT_IMAGE_PATH = "src/img/cat.jpg";
    // Foto von Richard655, Pixabay, Pixabay License.
    private static final String CRICKET_IMAGE_PATH = "src/img/cricket.jpg";
    // Foto von Chiemsee2016, Pixabay, Pixabay License.
    private static final String DOG_IMAGE_PATH = "src/img/dog.jpg";
    // Foto von ajoheyho, Pixabay, Pixabay License.
    private static final String ELEFANT_IMAGE_PATH = "src/img/elefant.jpg";
    // Foto von Chiemsee2016, Pixabay, Pixabay License.
    private static final String HORSE_IMAGE_PATH = "src/img/horse.jpg";
    // Foto von Robertgreene674, Pixabay, Pixabay License.
    private static final String LION_IMAGE_PATH = "src/img/lion.jpg";
    // Foto von PublicDomainImages, Pixabay, Pixabay License.
    private static final String PIG_IMAGE_PATH = "src/img/pig.jpg";

    private static final String BEAR_SOUND_PATH = "src/audio/bear_growl.wav";
    private static final String BIRD_SOUND_PATH = "src/audio/bird_whisteling.wav";
    private static final String CAT_SOUND_PATH = "src/audio/cat_meow.wav";
    private static final String CRICKET_SOUND_PATH = "src/audio/cricket_chirping.wav";
    private static final String DOG_SOUND_PATH = "src/audio/dog_bark.wav";
    private static final String ELEPHANT_SOUND_PATH = "src/audio/elephant_voice.wav";
    private static final String HORSE_SOUND_PATH = "src/audio/horse_whinny.wav";
    private static final String LION_SOUND_PATH = "src/audio/lion_breathing.wav";
    private static final String PIG_SOUND_PATH = "src/audio/pig_snorring.wav";

    private SoundBoardElement[][] elements;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        setFrameRate(FRAME_RATE);
        elements = new SoundBoardElement[ELEMENTS_PER_ROW][ELEMENTS_PER_COLUMN];

        elements[0][0] = new SoundBoardElement("Hund", DOG_IMAGE_PATH, DOG_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[0][1] = new SoundBoardElement("Katze", CAT_IMAGE_PATH, CAT_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[0][2] = new SoundBoardElement("Bär", BEAR_IMAGE_PATH, BEAR_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[1][0] = new SoundBoardElement("Löwe", LION_IMAGE_PATH, LION_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[1][1] = new SoundBoardElement("Grille", CRICKET_IMAGE_PATH, CRICKET_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[1][2] = new SoundBoardElement("Vogel", BIRD_IMAGE_PATH, BIRD_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[2][0] = new SoundBoardElement("Pferd", HORSE_IMAGE_PATH, HORSE_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[2][1] = new SoundBoardElement("Schwein", PIG_IMAGE_PATH, PIG_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        elements[2][2] = new SoundBoardElement("Elefant", ELEFANT_IMAGE_PATH, ELEPHANT_SOUND_PATH, 0, 0, ELEMENT_WIDTH, ELEMENT_HEIGHT);

        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                float xPos = j * ELEMENT_WIDTH;
                float yPos = i * ELEMENT_HEIGHT;
                elements[i][j].setXPos(xPos);
                elements[i][j].setYPos(yPos);
            }
        }
    }

    @Override
    public void draw() {
        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                elements[i][j].draw();
            }
        }
    }

    @Override
    public void onMousePressed(MousePressedEvent mousePressedEvent) {
        float mouseX = mousePressedEvent.getXPos();
        float mouseY = mousePressedEvent.getYPos();
        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                if(elements[i][j].hitTest(mouseX, mouseY)){
                    elements[i][j].playSound();
                }
            }
        }
    }

    @Override
    public void onKeyPressed(KeyPressedEvent keyPressedEvent) {
        char keyChar = keyPressedEvent.getKeyChar();
        playSoungForKeyChar(keyChar);
        System.out.println(keyChar);
    }

    private void playSoungForKeyChar(char keyChar) {
        keyChar = Character.toLowerCase(keyChar);
        for (int i = 0; i < ELEMENTS_PER_COLUMN; i++) {
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                String currName = elements[i][j].getName();
                char currChar = currName.charAt(0);
                currChar = Character.toLowerCase(currChar);
                System.out.println(currChar);
                if(currChar == keyChar) {
                    elements[i][j].playSound();
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }

}

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class Soundboard extends GraphicsApp {
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 30;

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

    SoundBoardElement testElement;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        setFrameRate(FRAME_RATE);
        testElement = new SoundBoardElement("Hund", DOG_IMAGE_PATH, 0, 0, CANVAS_WIDTH/3, CANVAS_HEIGHT/3, Colors.GREY);
    }

    @Override
    public void draw() {
        testElement.draw();
    }

    @Override
    public void onMousePressed(MousePressedEvent mousePressedEvent) {
        float mouseX = mousePressedEvent.getXPos();
        float mouseY = mousePressedEvent.getYPos();
        if(testElement.hitTest(mouseX, mouseY)) {
            playSoundForKeyCode(KeyPressedEvent.VK_H);
        }
    }

    @Override
    public void onKeyPressed(KeyPressedEvent keyPressedEvent) {
        int keyCode = keyPressedEvent.getKeyCode();
        playSoundForKeyCode(keyCode);
    }

    private void playSoundForKeyCode(int keyCode) {
        switch (keyCode) {
            case KeyPressedEvent.VK_H:
                SoundsPlayer.playDog();
                break;
            case KeyPressedEvent.VK_K:
                SoundsPlayer.playCat();
                break;
            case KeyPressedEvent.VK_B:
                SoundsPlayer.playBear();
                break;
            case KeyPressedEvent.VK_L:
                SoundsPlayer.playLion();
                break;
            case KeyPressedEvent.VK_G:
                SoundsPlayer.playCricket();
                break;
            case KeyPressedEvent.VK_V:
                SoundsPlayer.playBird();
                break;
            case KeyPressedEvent.VK_P:
                SoundsPlayer.playHorse();
                break;
            case KeyPressedEvent.VK_S:
                SoundsPlayer.playPig();
                break;
            case KeyPressedEvent.VK_E:
                SoundsPlayer.playElephant();
                break;
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }

}

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class Soundboard extends GraphicsApp {
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 30;

    SoundBoardElement testElement;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        setFrameRate(FRAME_RATE);
        testElement = new SoundBoardElement(0, 0, 20, 20, Colors.GREY);
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

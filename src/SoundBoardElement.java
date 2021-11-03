import de.ur.mi.oop.audio.AudioClip;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.GraphicsObject;
import de.ur.mi.oop.graphics.Image;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class SoundBoardElement extends GraphicsObject {

    private Rectangle background;
    private Image icon;
    private Label text;
    private String name;
    private AudioClip sound;

    public SoundBoardElement(String name, String imagePath, String audioPath, float x, float y, float width, float height) {
        super(x, y, width, height, Colors.GREY);
        width = width-2;
        height = height - 2;
        x = x + 2;
        y = y + 2;
        this.background = new Rectangle(x, y, width, height, Colors.GREY);
        this.name = name;
        this.text = new Label(0, height-5, name, Colors.WHITE);
        text.setXPos(width/2 - 25);
        this.icon = new Image(x, y, imagePath);
        icon.setHeight((height/10)*9, true);
        icon.setWidth((width/10)*9, true);
        icon.setXPos((width-icon.getWidth())/2);
        icon.setYPos(((height - text.getHeightEstimate()) - icon.getHeight()) / 2);
        sound = new AudioClip(audioPath);
    }

    @Override
    public void draw() {
        background.draw();
        icon.draw();
        text.draw();
    }

    @Override
    public boolean hitTest(float mouseX, float mouseY) {
        if(checkXCollision(mouseX) && checkYCollision(mouseY)) {
            return true;
        }
        return false;
    }

    @Override
    public void setXPos(float x) {
        float dx = x - this.getXPos();
        super.setXPos(x);
        background.move(dx, 0);
        icon.move(dx, 0);
        text.move(dx, 0);
    }

    @Override
    public void setYPos(float y) {
        float dy = y - this.getYPos();
        super.setYPos(y);
        background.move(0, dy);
        icon.move(0, dy);
        text.move(0, dy);
    }

    private boolean checkYCollision(float mouseY) {
        if(mouseY >= this.getYPos() && mouseY <= this.getYPos() + this.getHeight()) {
            return true;
        }
        return false;
    }

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

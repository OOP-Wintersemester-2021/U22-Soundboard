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

    public SoundBoardElement(String name, String filePath, float x, float y, float width, float height, Color color) {
        super(x, y, width, height, color);
        width = width-2;
        height = height - 2;
        x = x + 2;
        y = y + 2;
        this.background = new Rectangle(x, y, width, height, color);
        this.name = name;
        this.text = new Label(0, height-5, name, Colors.WHITE);
        text.setXPos(width/2 - 25);
        this.icon = new Image(x, y, filePath);
        icon.setHeight((height/10)*9, true);
        icon.setWidth((width/10)*9, true);
        icon.setXPos((width-icon.getWidth())/2);
        icon.setYPos(((height - text.getHeightEstimate()) - icon.getHeight()) / 2);
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
}

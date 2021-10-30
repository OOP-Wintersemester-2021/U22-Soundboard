import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.GraphicsObject;
import de.ur.mi.oop.graphics.Rectangle;

public class SoundBoardElement extends GraphicsObject {

    Rectangle background;

    public SoundBoardElement(float x, float y, float width, float height, Color color) {
        super(x, y, width, height, color);
        background = new Rectangle(x, y, width, height, color);
    }

    @Override
    public void draw() {
        background.draw();
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

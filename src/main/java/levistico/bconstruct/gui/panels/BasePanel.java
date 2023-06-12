package levistico.bconstruct.gui.panels;

import levistico.bconstruct.gui.BGuiButton;
import levistico.bconstruct.gui.GUIUtils;
import levistico.bconstruct.gui.containers.GUIContainerWithPanels;
import org.lwjgl.opengl.GL11;

import java.util.List;

public abstract class BasePanel implements IPanel {
    public int width;
    public int height;
    public int textureU = 0;
    public int textureV = 0;
    public int centerOffsetX;
    public int centerOffsetY;
    public float zLevel;
    public GUIContainerWithPanels guiContainer;
    public BasePanel(GUIContainerWithPanels guiContainer, int width, int height, float zLevel) {
        this.guiContainer = guiContainer;
        this.width = width;
        this.height = height;
        this.zLevel = zLevel;
    }

    abstract void drawForegroundLayer();

    void wind(int topX, int topY) {
        GL11.glPushMatrix();
        GL11.glTranslatef(topX, topY, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GUIUtils.GL_BLOCK_ITEM_MAGIC_NUMBER);
    }
    void unwind() {
        GL11.glDisable(GUIUtils.GL_BLOCK_ITEM_MAGIC_NUMBER);
        drawForegroundLayer();
        GL11.glPopMatrix();
    }

    int getTopX(int screenWidth) {
        return (screenWidth - width)/2 + centerOffsetX;
    }
    int getTopY(int screenHeight) {
        return (screenHeight - height)/2 + centerOffsetY;
    }
    int getInternalMouseX(int screenWidth, int mouseX) {
        return mouseX - getTopX(screenWidth);
    }
    int getInternalMouseY(int screenHeight, int mouseY) {
        return mouseY - getTopY(screenHeight);
    }
}
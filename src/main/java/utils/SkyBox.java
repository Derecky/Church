package utils;

import static org.lwjgl.opengl.GL11.*;

public class SkyBox {

    Texture texture;

    public SkyBox(Texture texture){
        this.texture = texture;
    }

    public void drawSky() {
        texture.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0,1);
        glVertex3f(-100, -10, -150);
        glTexCoord2f(1,1);
        glVertex3f(100, -10, -150 );
        glTexCoord2f(1,0);
        glVertex3f(100, 100, -150);
        glTexCoord2f(0,0);
        glVertex3f(-100, 100, -150);
        glEnd();
    }
}

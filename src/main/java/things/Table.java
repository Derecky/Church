package things;

import utils.Texture;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Table {

    private float thickness = 0.15f;
    private List<Texture> textures;

    public Table(List<Texture> textures){
        this.textures = textures;
    }

    public void createTable(){
        tampo();
        pe();
    }

    private void tampo(){

        glColor3f(0.2f,0.2f,0.1f);
        textures.get(0).bind();
        glBegin(GL_QUAD_STRIP);
        glNormal3f(0,-1,0);
        glTexCoord2f(0, 0.f);
        glVertex3f(-4.5f, 3-thickness,-80);
        glTexCoord2f(1, 0.f);
        glVertex3f(4.5f, 3-thickness,-80);

        glNormal3f(0,0,-1);
        glTexCoord2f(0, 0.25f);
        glVertex3f(-4.5f, 3-thickness,-83);
        glTexCoord2f(1, 0.25f);
        glVertex3f(4.5f, 3-thickness,-83);

        glNormal3f(0,1,0);
        glTexCoord2f(0, 0.5f);
        glVertex3f(-4.5f, 3 +thickness,-83);
        glTexCoord2f(1, 0.5f);
        glVertex3f(4.5f, 3+thickness,-83);

        glNormal3f(0,0,1);
        glTexCoord2f(0, 0.75f);
        glVertex3f(-4.5f, 3 +thickness,-80);
        glTexCoord2f(1, 0.75f);
        glVertex3f(4.5f, 3+thickness,-80);
        glTexCoord2f(0, 1.f);
        glVertex3f(-4.5f, 3-thickness,-80);
        glTexCoord2f(1, 1.f);
        glVertex3f(4.5f, 3-thickness,-80);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(-1,0,0);
        glTexCoord2f(0, 0f);
        glVertex3f(-4.5f, 3-thickness,-80);
        glTexCoord2f(0, 1f);
        glVertex3f(-4.5f, 3-thickness,-83);
        glTexCoord2f(1, 1f);
        glVertex3f(-4.5f, 3 +thickness,-83);
        glTexCoord2f(1, 0f);
        glVertex3f(-4.5f, 3 +thickness,-80);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(1,0,0);
        glTexCoord2f(0, 0f);
        glVertex3f(4.5f, 3-thickness,-80);
        glTexCoord2f(0, 1f);
        glVertex3f(4.5f, 3-thickness,-83);
        glTexCoord2f(1, 1.f);
        glVertex3f(4.5f, 3+thickness,-83);
        glTexCoord2f(1, 0.5f);
        glVertex3f(4.5f, 3+thickness,-80);
        glEnd();
    }

    private void pe(){

        glBegin(GL_QUAD_STRIP);
        glNormal3f(0,-1,0);
        glTexCoord2f(0, 0.f);
        glVertex3f(-1.5f, 0,-80.5f);
        glTexCoord2f(1, 0.f);
        glVertex3f(1.5f, 0,-80.5f);

        glNormal3f(0,0,-1);
        glTexCoord2f(0, 0.25f);
        glVertex3f(-1.5f, 0,-82.5f);
        glTexCoord2f(1, 0.25f);
        glVertex3f(1.5f, 0,-82.5f);

        glNormal3f(0,1,0);
        glTexCoord2f(0, 0.5f);
        glVertex3f(-1.5f, 3 -thickness,-82.5f);
        glTexCoord2f(1, 0.5f);
        glVertex3f(1.5f, 3 - thickness,-82.5f);

        glNormal3f(0,0,1);
        glTexCoord2f(0, 0.75f);
        glVertex3f(-1.5f, 3 - thickness,-80.5f);
        glTexCoord2f(1, 0.75f);
        glVertex3f(1.5f, 3 - thickness,-80.5f);
        glTexCoord2f(0, 1.f);
        glVertex3f(-1.5f, 0,-80.5f);
        glTexCoord2f(1, 01.f);
        glVertex3f(1.5f, 0,-80.5f);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(-1,0,0);
        glTexCoord2f(0, 0f);
        glVertex3f(-1.5f, 0,-80.5f);
        glTexCoord2f(0, 1f);
        glVertex3f(-1.5f, 0,-82.5f);
        glTexCoord2f(1, 1f);
        glVertex3f(-1.5f, 3 -thickness,-82.5f);
        glTexCoord2f(1, 0.f);
        glVertex3f(-1.5f, 3 - thickness,-80.5f);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(1,0,0);
        glTexCoord2f(0, 0.5f);
        glVertex3f(1.5f, 0,-80.5f);
        glTexCoord2f(1, 0.5f);
        glVertex3f(1.5f, 0,-82.5f);
        glTexCoord2f(1, 1f);
        glVertex3f(1.5f, 3 - thickness,-82.5f);
        glTexCoord2f(0, 1f);
        glVertex3f(1.5f, 3 - thickness,-80.5f);
        glEnd();
    }
}

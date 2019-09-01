package things;

import utils.Texture;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Pulpit {

    List<Texture> textures;
    float thickness = 0.15f;

    public Pulpit(List<Texture> textures){
        this.textures = textures;
    }

    public void createPulpit(){
        glPushMatrix();
        glColor3f(0.3f, 0.3f, 0.2f);
        textures.get(0).bind();
        glBegin(GL_QUAD_STRIP);

        glNormal3f(0,-1,0);
        glTexCoord2f(0,0.f);
        glVertex3f(-8.8f, 0.7f,-79.5f);
        glTexCoord2f(1,0.f);
        glVertex3f(-7.5f, 0.7f,-79.5f);

        glNormal3f(0,0,-1);
        glTexCoord2f(0,0.25f);
        glVertex3f(-8.8f, 0.7f,-81.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(-7.5f, 0.7f,-81.5f);

        glNormal3f(0,1,0);
        glTexCoord2f(0,0.5f);
        glVertex3f(-8.8f, 3.7f -thickness,-81.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(-7.5F, 3.7f - thickness,-81.5f);

        glNormal3f(0,0,1);
        glTexCoord2f(0,0.75f);
        glVertex3f(-8.8f, 3.7f - thickness,-79.5f);
        glTexCoord2f(1,0.75f);
        glVertex3f(-7.5f, 3.7f - thickness,-79.5f);
        glTexCoord2f(0,1.f);
        glVertex3f(-8.8f, 0.7f,-79.5f);
        glTexCoord2f(1,1.f);
        glVertex3f(-7.5f, 0.7f,-79.5f);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(-1,0,0);
        glTexCoord2f(0,0);
        glVertex3f(-8.8f, 0.7f,-79.5f);
        glTexCoord2f(0,1);
        glVertex3f(-8.8f, 0.7f,-81.5f);
        glTexCoord2f(1,1);
        glVertex3f(-8.8f, 3.7f -thickness,-81.5f);
        glTexCoord2f(1,0);
        glVertex3f(-8.8f, 3.7f - thickness,-79.5f);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(1,0,0);
        glTexCoord2f(0,0);
        glVertex3f(-7.5f, 0.7f,-79.5f);
        glTexCoord2f(0,1);
        glVertex3f(-7.5f, 0.7f,-81.5f);
        glTexCoord2f(1,1);
        glVertex3f(-7.5f, 3.7f - thickness,-81.5f);
        glTexCoord2f(1,0);
        glVertex3f(-7.5f, 3.7f - thickness,-79.5f);
        glEnd();
        glPopMatrix();
    }
}

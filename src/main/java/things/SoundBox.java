package things;

import utils.Texture;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class SoundBox {

    List<Texture> textures;

    public SoundBox(List<Texture> textures){
        this.textures = textures;
    }
    public void putSoundBoxes(){
        createbox(-30);
        createbox(-66);
    }

    private void createbox(float z){

        glColor4f(0.2f,0.2f,0.2f,0.2f);
        textures.get(15).bind();
        glBegin(GL_QUAD_STRIP);
        glNormal3f(1,0,0);
        glTexCoord2f(0,0);
        glVertex3f(20, 8.5f, z-0.25f);
        glTexCoord2f(1,0);
        glVertex3f(20, 8.5f, z+0.25f);

        glNormal3f(0,-1,0);
        glTexCoord2f(0,0.25f);
        glVertex3f(20, 7.5f, z-0.25f);
        glTexCoord2f(1,0.25f);
        glVertex3f(20, 7.5f, z+0.25f);

        glNormal3f(-1,0,0);
        glTexCoord2f(0,0.5f);
        glVertex3f(20-0.5f, 7.5f, z-0.25f);
        glTexCoord2f(1,0.5f);
        glVertex3f(20-0.5f, 7.5f, z+0.25f);

        glNormal3f(0,1,0);
        glTexCoord2f(0,0.75f);
        glVertex3f(20-0.5f, 8.5f, z-0.25f);
        glTexCoord2f(1,0.75f);
        glVertex3f(20-0.5f, 8.5f, z+0.25f);
        glTexCoord2f(0,1.f);
        glVertex3f(20, 8.5f, z-0.25f);
        glTexCoord2f(1,1.0f);
        glVertex3f(20, 8.5f, z+0.25f);

        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(0,0,-1);
        glTexCoord2f(0,0.f);
        glVertex3f(20, 8.5f, z-0.25f);
        glTexCoord2f(1,0.f);
        glVertex3f(20, 7.5f, z-0.25f);
        glTexCoord2f(1,1.f);
        glVertex3f(20-0.5f, 7.5f, z-0.25f);
        glTexCoord2f(0,1.f);
        glVertex3f(20-0.5f, 8.5f, z-0.25f);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(0,0,1);
        glTexCoord2f(0,0.f);
        glVertex3f(20, 8.5f, z+0.25f);
        glTexCoord2f(1,0.f);
        glVertex3f(20, 7.5f, z+0.25f);
        glTexCoord2f(0,1.f);
        glVertex3f(20-0.5f, 7.5f, z+0.25f);
        glTexCoord2f(1,1.f);
        glVertex3f(20-0.5f, 8.5f, z+0.25f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glNormal3f(1,0,0);
        glTexCoord2f(0,0.f);
        glVertex3f(-20, 8.5f, z-0.25f);
        glTexCoord2f(1,0.f);
        glVertex3f(-20, 8.5f, z+0.25f);

        glNormal3f(0,-1,0);
        glTexCoord2f(0,0.25f);
        glVertex3f(-20, 7.5f, z-0.25f);
        glTexCoord2f(1,0.25f);
        glVertex3f(-20, 7.5f, z+0.25f);

        glNormal3f(-1,0,0);
        glTexCoord2f(0,0.5f);
        glVertex3f(-20+0.5f, 7.5f, z-0.25f);
        glTexCoord2f(1,0.5f);
        glVertex3f(-20+0.5f,7.5f, z+0.25f);

        glNormal3f(0,1,0);
        glTexCoord2f(0,.75f);
        glVertex3f(-20+0.5f, 8.5f, z-0.25f);
        glTexCoord2f(1,.75f);
        glVertex3f(-20+0.5f, 8.5f, z+0.25f);
        glTexCoord2f(0,1.f);
        glVertex3f(-20, 8.5f, z-0.25f);
        glTexCoord2f(1,1.f);
        glVertex3f(-20, 8.5f, z+0.25f);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(0,0, -1);
        glTexCoord2f(0,0.f);
        glVertex3f(-20, 8.5f, z-0.25f);
        glTexCoord2f(1,0.f);
        glVertex3f(-20, 7.5f, z-0.25f);
        glTexCoord2f(0,1.f);
        glVertex3f(-20+0.5f, 7.5f, z-0.25f);
        glTexCoord2f(1,1.f);
        glVertex3f(-20+0.5f, 8.5f, z-0.25f);
        glEnd();

        glBegin(GL_QUADS);
        glNormal3f(0,0,1);
        glTexCoord2f(0,0.f);
        glVertex3f(-20, 8.5f, z+0.25f);
        glTexCoord2f(1,0.f);
        glVertex3f(-20, 7.5f, z+0.25f);
        glTexCoord2f(0,1.f);
        glVertex3f(-20+0.5f, 7.5f, z+0.25f);
        glTexCoord2f(1,1.f);
        glVertex3f(-20+0.5f, 8.5f, z+0.25f);
        glEnd();
    }
}

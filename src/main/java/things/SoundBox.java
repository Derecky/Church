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

        glColor3f(0,0,0);

        glBegin(GL_QUAD_STRIP);
        glVertex3f(20, 8.5f, z-0.25f);
        glVertex3f(20, 8.5f, z+0.25f);
        glVertex3f(20, 7.5f, z-0.25f);
        glVertex3f(20, 7.5f, z+0.25f);
        glVertex3f(20-0.5f, 7.5f, z-0.25f);
        glVertex3f(20-0.5f, 7.5f, z+0.25f);
        glVertex3f(20-0.5f, 8.5f, z-0.25f);
        glVertex3f(20-0.5f, 8.5f, z+0.25f);
        glEnd();

        glBegin(GL_QUADS);
        glVertex3f(20, 8.5f, z-0.25f);
        glVertex3f(20, 7.5f, z-0.25f);
        glVertex3f(20-0.5f, 7.5f, z-0.25f);
        glVertex3f(20-0.5f, 8.5f, z-0.25f);
        glEnd();

        glBegin(GL_QUADS);
        glVertex3f(20, 8.5f, z+0.25f);
        glVertex3f(20, 7.5f, z+0.25f);
        glVertex3f(20-0.5f, 7.5f, z+0.25f);
        glVertex3f(20-0.5f, 8.5f, z+0.25f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glVertex3f(-20, 8.5f, z-0.25f);
        glVertex3f(-20, 8.5f, z+0.25f);
        glVertex3f(-20, 7.5f, z-0.25f);
        glVertex3f(-20, 7.5f, z+0.25f);
        glVertex3f(-20+0.5f, 7.5f, z-0.25f);
        glVertex3f(-20+0.5f, 7.5f, z+0.25f);
        glVertex3f(-20+0.5f, 8.5f, z-0.25f);
        glVertex3f(-20+0.5f, 8.5f, z+0.25f);
        glEnd();

        glBegin(GL_QUADS);
        glVertex3f(-20, 8.5f, z-0.25f);
        glVertex3f(-20, 7.5f, z-0.25f);
        glVertex3f(-20+0.5f, 7.5f, z-0.25f);
        glVertex3f(-20+0.5f, 8.5f, z-0.25f);
        glEnd();

        glBegin(GL_QUADS);
        glVertex3f(-20, 8.5f, z+0.25f);
        glVertex3f(-20, 7.5f, z+0.25f);
        glVertex3f(-20+0.5f, 7.5f, z+0.25f);
        glVertex3f(-20+0.5f, 8.5f, z+0.25f);
        glEnd();
    }
}

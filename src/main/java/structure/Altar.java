package structure;

import utils.Texture;

import java.util.List;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;
import static org.lwjgl.opengl.GL11.*;

public class Altar {

    List<Texture> textures;

    private final float XSIZE = 20; //25
    private final float YSIZE = 10; //10
    private final float ZSIZE = 30; //30
    private final float thickness = 0.025f;

    public Altar(List<Texture> textures){
        this.textures = textures;
    }

    public void createAltar() {
        createAltarGround();
        createAltarStair();
    }

    private void createAltarStair() {
        /* Primeiro degrau */
        glColor3f(0.5f, 0.5f, 0.5f);
        textures.get(9).bind();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0, 0f);
        glVertex3f(XSIZE - 8, 0, -3.5f * ZSIZE + 17 + thickness);
        glTexCoord2f(0, 1f);
        glVertex3f(XSIZE - 8, 0.5f, -3.5f * ZSIZE + 17 + thickness);
        glTexCoord2f(0.16f, 0.f);
        glVertex3f(XSIZE - 8, 0, -3.5f * ZSIZE + 25);
        glTexCoord2f(0.16f, 1.f);
        glVertex3f(XSIZE - 8, 0.5f, -3.5f * ZSIZE + 25);
        glTexCoord2f(0.32f, 0.f);
        glVertex3f(XSIZE - 13, 0, -3.5f * ZSIZE + 28);
        glTexCoord2f(0.32f, 1.f);
        glVertex3f(XSIZE - 13, 0.5f, -3.5f * ZSIZE + 28);
        glTexCoord2f(0.48f, 0.f);
        glVertex3f(-XSIZE + 13, 0, -3.5f * ZSIZE + 28);
        glTexCoord2f(0.48f, 1.f);
        glVertex3f(-XSIZE + 13, 0.5f, -3.5f * ZSIZE + 28);
        glTexCoord2f(0.64f, 0.f);
        glVertex3f(-XSIZE + 8, 0, -3.5f * ZSIZE + 25);
        glTexCoord2f(0.64f, 1.f);
        glVertex3f(-XSIZE + 8, 0.5f, -3.5f * ZSIZE + 25);
        glTexCoord2f(0.8f, 0.f);
        glVertex3f(-XSIZE + 8, 0, -3.5f * ZSIZE + 17 + thickness);
        glTexCoord2f(0.8f, 1.f);
        glVertex3f(-XSIZE + 8, 0.5f, -3.5f * ZSIZE + 17 + thickness);
        glEnd();

        /* Segundo degrau */
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0.f, 0.f);
        glVertex3f(XSIZE - 9, 0.5f, -3.5f * ZSIZE + 17 + thickness);
        glTexCoord2f(0.f, 1.f);
        glVertex3f(XSIZE - 9, 1, -3.5f * ZSIZE + 17 + thickness);
        glTexCoord2f(0.16f, 0.f);
        glVertex3f(XSIZE - 9, 0.5f, -3.5f * ZSIZE + 24);
        glTexCoord2f(0.16f, 1.f);
        glVertex3f(XSIZE - 9, 1, -3.5f * ZSIZE + 24);
        glTexCoord2f(0.32f, 0.f);
        glVertex3f(XSIZE - 13, 0.5f, -3.5f * ZSIZE + 27);
        glTexCoord2f(0.32f, 1.f);
        glVertex3f(XSIZE - 13, 1, -3.5f * ZSIZE + 27);
        glTexCoord2f(0.48f, 0.f);
        glVertex3f(-XSIZE + 13, 0.5f, -3.5f * ZSIZE + 27);
        glTexCoord2f(0.48f, 1.f);
        glVertex3f(-XSIZE + 13, 1, -3.5f * ZSIZE + 27);
        glTexCoord2f(0.64f, 0.f);
        glVertex3f(-XSIZE + 9, 0.5f, -3.5f * ZSIZE + 24);
        glTexCoord2f(0.64f, 1.f);
        glVertex3f(-XSIZE + 9, 1, -3.5f * ZSIZE + 24);
        glTexCoord2f(0.8f, 0.f);
        glVertex3f(-XSIZE + 9, 0.5f, -3.5f * ZSIZE + 17 + thickness);
        glTexCoord2f(0.8f, 1.f);
        glVertex3f(-XSIZE + 9, 1, -3.5f * ZSIZE + 17 + thickness);
        glEnd();
    }

    private void createAltarGround(){
        glColor4f(1.f, 1.f, 1.f, 1);
        textures.get(16).bind();
        /* Tampo degrau 1*/
        glBegin(GL_TRIANGLE_FAN);
        glTexCoord2f(0.5f, 1.f);
        glVertex3f(0, 0.5f, -3.5f*ZSIZE +17 + thickness);
        glTexCoord2f(0.165f, 0.85f);
        glVertex3f(XSIZE - 8, 0.5f, -3.5f*ZSIZE +17 + thickness);
        glTexCoord2f(0.33f, 0.7f);
        glVertex3f(XSIZE - 8, 0.5f, -3.5f*ZSIZE +25);
        glTexCoord2f(0.5f, 0.55f);
        glVertex3f(XSIZE - 13, 0.5f, -3.5f*ZSIZE +28);
        glTexCoord2f(0.665f, 0.4f);
        glVertex3f(-XSIZE + 13, 0.5f, -3.5f*ZSIZE +28);
        glTexCoord2f(0.83f, 0.25f);
        glVertex3f(-XSIZE + 8, 0.5f, -3.5f*ZSIZE +25);
        glTexCoord2f(0.9f, 0.1f);
        glVertex3f(-XSIZE + 8, 0.5f, -3.5f*ZSIZE +17 + thickness);
        glEnd();

        /* Tampo degrau 2*/
        glBegin(GL_TRIANGLE_FAN);
        glTexCoord2f(0.5f, 1);
        glVertex3f(0, 1f, -3.5f*ZSIZE +17 -5* thickness);
        glTexCoord2f(0.0f, 1f);
        glVertex3f(XSIZE - 9, 1, -3.5f*ZSIZE +17 -5* thickness);
        glTexCoord2f(0.33f, 0.85f);
        glVertex3f(XSIZE - 9, 1, -3.5f*ZSIZE +24);
        glTexCoord2f(0.5f, 0.7f);
        glVertex3f(XSIZE - 13, 1, -3.5f*ZSIZE +27);
        glTexCoord2f(0.665f, 0.55f);
        glVertex3f(-XSIZE + 13, 1, -3.5f*ZSIZE +27);
        glTexCoord2f(0.73f, 0.4f);
        glVertex3f(-XSIZE + 9, 1, -3.5f*ZSIZE +24);
        glTexCoord2f(1.f, 0.15f);
        glVertex3f(-XSIZE + 9, 1f, -3.5f*ZSIZE +17 - 5*thickness);
        glEnd();


        /* Tampo semicirculo*/
        glBegin(GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            float angle = (float) (2*Math.PI*i/360);
            if(-cos(angle)*ZSIZE/2 - 2.5f*ZSIZE - 4.5f >= -3f*ZSIZE +10 && sin(angle)*ZSIZE/2 >= -13 && sin(angle)*ZSIZE/2 <= 13 ){
                glTexCoord2f( 0.2f + ((float)cos(angle)+1)/3.25f,0.5f + 0.35f*(float)sin(angle));
                glVertex3f((float)sin(angle)*ZSIZE/3f, 1 , (float)cos(angle)*ZSIZE/3f- 3.5f*ZSIZE +3*ZSIZE/4 -0.5f);
            }
        }
        glEnd();
    }

}


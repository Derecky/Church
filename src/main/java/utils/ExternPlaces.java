package utils;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class ExternPlaces {

    List<Texture> textures;
    private final float XSIZE = 20; //25
    private final float YSIZE = 10; //10
    private final float ZSIZE = 30; //30

    public ExternPlaces(List<Texture> textures){
        this.textures = textures;
    }

    public void makeExternalArea(){
        drawSuperiorGround();
        drawGround();
    }

    private void drawSuperiorGround(){

        /* Piso, parte superior*/
        textures.get(12).bind();
        glColor3f(0.75f,0.75f,0.75f);
        /* Piso lado fora */
        glPushMatrix();
        for(int i= (int) -XSIZE-2; i< XSIZE+2; i+=4 ){
            for(int j = 10; j>=(int) -3.5*ZSIZE -10  ; j-=5){
                glBegin(GL_QUADS);
                glTexCoord2f(0,1);
                glVertex3f(i, -0.01f, j);
                glTexCoord2f(1,1);
                glVertex3f(i+4,-0.01f,j);
                glTexCoord2f(1,0);
                glVertex3f(i+4,-0.01f,j-5);
                glTexCoord2f(0,0);
                glVertex3f(i,-0.01f,j-5);
                glEnd();
            }
        }
        glPopMatrix();

        glPushMatrix();
        for(int i= 10; i>= -3.5*ZSIZE + 5; i-=5){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(XSIZE+2, -0.01f, i);
            glTexCoord2f(0,1);
            glVertex3f(XSIZE+2, -3.f, i);
            glTexCoord2f(1,1);
            glVertex3f(XSIZE+2, -3.0f, i-5);
            glTexCoord2f(1,0);
            glVertex3f(XSIZE+2, -0.01f, i-5);
            glEnd();
        }

        for(int i= 10; i>= -3.5*ZSIZE + 5; i-=5){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(-XSIZE-2, -0.01f, i);
            glTexCoord2f(0,1);
            glVertex3f(-XSIZE-2, -3.f, i);
            glTexCoord2f(1,1);
            glVertex3f(-XSIZE-2, -3.0f, i-5);
            glTexCoord2f(1,0);
            glVertex3f(-XSIZE-2, -0.01f, i-5);
            glEnd();
        }

        for(int i=(int) -XSIZE-2; i< XSIZE+2; i+=4){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(i, -0.01f, 10);
            glTexCoord2f(0,1);
            glVertex3f(i, -3.f, 10);
            glTexCoord2f(1,1);
            glVertex3f(i+4, -3.0f, 10);
            glTexCoord2f(1,0);
            glVertex3f(i+4, -0.01f, 10);
            glEnd();
        }

        for(int i=(int) -XSIZE-2; i< XSIZE+2; i+=4){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(i, -0.01f, -3.5f*ZSIZE );
            glTexCoord2f(0,1);
            glVertex3f(i, -3.f, -3.5f*ZSIZE );
            glTexCoord2f(1,1);
            glVertex3f(i+4, -3.0f, -3.5f*ZSIZE );
            glTexCoord2f(1,0);
            glVertex3f(i+4, -0.01f, -3.5f*ZSIZE );
            glEnd();
        }
        glPopMatrix();

        /* Inicia degrau 1 (mais alto) */
        glPushMatrix();
        for(int i= (int) -XSIZE-2; i< XSIZE+2; i+=4 ){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(i, -.5f, 10);
            glTexCoord2f(0,1);
            glVertex3f(i,-.5f,11.f);
            glTexCoord2f(1,1);
            glVertex3f(i+4,-.5f,11.f);
            glTexCoord2f(1,0);
            glVertex3f(i+4,-.5f,10);
            glEnd();
        }
        glPopMatrix();
        glPopMatrix();
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(XSIZE+2, -0.5f, 11.f);
            glTexCoord2f(0,1);
            glVertex3f(XSIZE+2, -3.f, 11.f);
            glTexCoord2f(1,1);
            glVertex3f(XSIZE+2, -3.0f, 10);
            glTexCoord2f(1,0);
            glVertex3f(XSIZE+2, -0.5f, 10);
            glEnd();
        glPopMatrix();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-XSIZE-2, -0.5f, 11);
        glTexCoord2f(0,1);
        glVertex3f(-XSIZE-2, -3.f, 11);
        glTexCoord2f(1,1);
        glVertex3f(-XSIZE-2, -3.0f, 10);
        glTexCoord2f(1,0);
        glVertex3f(-XSIZE-2, -0.5f, 10);
        glEnd();

        for(int i=(int) -XSIZE-2; i< XSIZE+2; i+=4){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(i, -0.5f, 11);
            glTexCoord2f(0,1);
            glVertex3f(i, -3.f, 11);
            glTexCoord2f(1,1);
            glVertex3f(i+4, -3.0f, 11);
            glTexCoord2f(1,0);
            glVertex3f(i+4, -0.5f, 11);
            glEnd();
        }

        /* Inicia degrau 2 */
        glPushMatrix();
        for(int i= (int) -XSIZE-2; i< XSIZE+2; i+=4 ){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(i, -1.f, 11);
            glTexCoord2f(0,1);
            glVertex3f(i,-1.f,12.f);
            glTexCoord2f(1,1);
            glVertex3f(i+4,-1.f,12.f);
            glTexCoord2f(1,0);
            glVertex3f(i+4,-1.f,11);
            glEnd();
        }
        glPopMatrix();
        glPopMatrix();
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(XSIZE+2, -1.f, 12.f);
        glTexCoord2f(0,1);
        glVertex3f(XSIZE+2, -3.f, 12.f);
        glTexCoord2f(1,1);
        glVertex3f(XSIZE+2, -3.0f, 11);
        glTexCoord2f(1,0);
        glVertex3f(XSIZE+2, -1.f, 11);
        glEnd();
        glPopMatrix();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-XSIZE-2, -1.f, 12);
        glTexCoord2f(0,1);
        glVertex3f(-XSIZE-2, -3.f, 12);
        glTexCoord2f(1,1);
        glVertex3f(-XSIZE-2, -3.0f, 11);
        glTexCoord2f(1,0);
        glVertex3f(-XSIZE-2, -1.f, 11);
        glEnd();

        for(int i=(int) -XSIZE-2; i< XSIZE+2; i+=4){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(i, -1.f, 12);
            glTexCoord2f(0,1);
            glVertex3f(i, -3.f, 12);
            glTexCoord2f(1,1);
            glVertex3f(i+4, -3.0f, 12);
            glTexCoord2f(1,0);
            glVertex3f(i+4, -1.f, 12);
            glEnd();
        }

        /* Inicia degrau 3 */
        glPushMatrix();
        for(int i= (int) -XSIZE-2; i< XSIZE+2; i+=4 ){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(i, -1.5f, 12);
            glTexCoord2f(0,1);
            glVertex3f(i,-1.5f,13.f);
            glTexCoord2f(1,1);
            glVertex3f(i+4,-1.5f,13.f);
            glTexCoord2f(1,0);
            glVertex3f(i+4,-1.5f,12);
            glEnd();
        }
        glPopMatrix();
        glPopMatrix();
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(XSIZE+2, -1.5f, 13.f);
        glTexCoord2f(0,1);
        glVertex3f(XSIZE+2, -3.f, 13.f);
        glTexCoord2f(1,1);
        glVertex3f(XSIZE+2, -3.0f, 12);
        glTexCoord2f(1,0);
        glVertex3f(XSIZE+2, -1.5f, 12);
        glEnd();
        glPopMatrix();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-XSIZE-2, -1.5f, 13);
        glTexCoord2f(0,1);
        glVertex3f(-XSIZE-2, -3.f, 13);
        glTexCoord2f(1,1);
        glVertex3f(-XSIZE-2, -3.0f, 12);
        glTexCoord2f(1,0);
        glVertex3f(-XSIZE-2, -1.5f, 12);
        glEnd();

        for(int i=(int) -XSIZE-2; i< XSIZE+2; i+=4){
            glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex3f(i, -1.5f, 13);
            glTexCoord2f(0,1);
            glVertex3f(i, -3.f, 13);
            glTexCoord2f(1,1);
            glVertex3f(i+4, -3.0f, 13);
            glTexCoord2f(1,0);
            glVertex3f(i+4, -1.5f, 13);
            glEnd();
        }
    }

    private void drawGround(){
        glColor3f(.2f, .4f, .3f);
        textures.get(13).bind();

        for(int i= -60; i< 60; i+=4 ) {
            for (int j = 80; j >= -150; j -= 5) {
                glBegin(GL_QUADS);
                glTexCoord2f(0, 0);
                glVertex3f(i, -2.f, j-5);
                glTexCoord2f(0, 1);
                glVertex3f(i, -2.f, j);
                glTexCoord2f(1, 1);
                glVertex3f(i+4, -2.0f, j);
                glTexCoord2f(1, 0);
                glVertex3f(i+4, -2.f, j-5);
                glEnd();
            }
        }
    }
}

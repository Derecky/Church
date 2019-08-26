package structure;

import utils.Texture;

import java.util.List;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;
import static org.lwjgl.opengl.GL11.*;

public class Facade {

    private final float XSIZE = 20; //25
    private final float YSIZE = 10; //10
    private final float ZSIZE = 30; //30

    private final float thickness = 0.025f;
    private List<Texture> textures;

    public Facade(List<Texture> textures){
        this.textures = textures;
    }

    public void criarFachada(){

        criarVitral();
        criarCrucifixo();

        glColor4f(0.5f, 0.5f, 0.4f,1);
        criarAreaPortasLaterais();
        criarAreaPortaCentral();

        glColor4f(0.25f, 0.25f, 0.2f,1);
        criarPilaresLaterais(XSIZE,YSIZE,1.5f);
        criarPilaresLaterais(XSIZE-3.5f, YSIZE + 3, 2 );
        criarPilaresLaterais(XSIZE-10f,YSIZE+4.5f,2);
        criarPilaresLaterais(5f, YSIZE+9, 3);
    }

    private void criarAreaPortasLaterais(){

        glPushMatrix();
        /* Lado direito */
        textures.get(1).bind();
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0);
        glVertex3f(5f, 0, 0.01f);
        glTexCoord2f(1,0);
        glVertex3f(5f, YSIZE + 3.75f +2, 0.01f);
        glTexCoord2f(0,0.2f);
        glVertex3f(5f, 0,0.5f);
        glTexCoord2f(1,0.2f);
        glVertex3f(5f, YSIZE + 3.75f +2, 0.5f);
        glTexCoord2f(0,0.4f);
        glVertex3f(10f, 0,0.5f);
        glTexCoord2f(1,0.4f);
        glVertex3f(10f, YSIZE + 2.5f +2, 0.5f);
        glTexCoord2f(0,0.6f);
        glVertex3f(10f, 0, 0.01f);
        glTexCoord2f(1,0.6f);
        glVertex3f(10f, YSIZE + 2.5f +2, 0.01f);
        glTexCoord2f(0,0.8f);
        glVertex3f(5f, 0, 0.01f);
        glTexCoord2f(1,0.8f);
        glVertex3f(5f, YSIZE + 3.75f +2, 0.01f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0);
        glVertex3f(10f, 5.5f,0.01f);
        glTexCoord2f(1,0);
        glVertex3f(15f, 5.5f,0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(10f, 5.5f,0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(15f, 5.5f,0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(10f, YSIZE + 2.5f +2,0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(15f, YSIZE+ 1.375f +2,0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(10f, YSIZE + 2.5f +2,0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(15f, YSIZE+ 1.375f +2,0.01f);
        glTexCoord2f(0,1);
        glVertex3f(10f, 5.5f,0.01f);
        glTexCoord2f(1,1);
        glVertex3f(15f, 5.5f,0.01f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(15f, 0f,0.01f);
        glTexCoord2f(1,0.f);
        glVertex3f(16.5f, 0f,0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(15f, 0f,0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(16.5f, 0f,0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(15f, YSIZE + 1.375f +2,0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(16.5f, YSIZE+ 1f +2,0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(15f, YSIZE + 1.375f +2,0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(16.5f, YSIZE+ 1f +2,0.01f);
        glTexCoord2f(0,1);
        glVertex3f(15f, 0f,0.01f);
        glTexCoord2f(1,1);
        glVertex3f(16.5f, 0f,0.01f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(16.5f, 0f, 0.01f);
        glTexCoord2f(1,0.f);
        glVertex3f(XSIZE, 0f, 0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(16.5f, 0f, 0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(XSIZE, 0f, 0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(16.5f, YSIZE + 0.875f, 0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(XSIZE, YSIZE, 0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(16.5f, YSIZE + 0.875f, 0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(XSIZE, YSIZE, 0.01f);
        glEnd();

        /* Lado esquerdo*/
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(-5f, 0, 0.01f);
        glTexCoord2f(1,0.f);
        glVertex3f(-5f, YSIZE + 3.75f +2, 0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(-5f, 0,0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(-5f, YSIZE + 3.75f +2, 0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-10f, 0,0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(-10f, YSIZE + 2.5f +2, 0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(-10f, 0, 0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(-10f, YSIZE + 2.5f +2, 0.01f);
        glTexCoord2f(0,1f);
        glVertex3f(-5f, 0, 0.01f);
        glTexCoord2f(1,1.f);
        glVertex3f(-5f, YSIZE + 3.75f +2, 0.01f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(-10f, 5.5f,0.01f);
        glTexCoord2f(1,0.f);
        glVertex3f(-15f, 5.5f,0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(-10f, 5.5f,0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(-15f, 5.5f,0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-10f, YSIZE + 2.5f +2,0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(-15f, YSIZE+ 1.375f +2,0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(-10f, YSIZE + 2.5f +2,0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(-15f, YSIZE+ 1.375f +2,0.01f);
        glTexCoord2f(0,1.f);
        glVertex3f(-10f, 5.5f,0.01f);
        glTexCoord2f(1,1.f);
        glVertex3f(-15f, 5.5f,0.01f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(-15f, 0f,0.01f);
        glTexCoord2f(1,0.f);
        glVertex3f(-16.5f, 0f,0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(-15f, 0f,0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(-16.5f, 0f,0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-15f, YSIZE + 1.375f +2,0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(-16.5f, YSIZE+ 1f +2,0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(-15f, YSIZE + 1.375f +2,0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(-16.5f, YSIZE+ 1f +2,0.01f);
        glTexCoord2f(0,1.f);
        glVertex3f(-15f, 0f,0.01f);
        glTexCoord2f(1,1.f);
        glVertex3f(-16.5f, 0f,0.01f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(-16.5f, 0f, 0.01f);
        glTexCoord2f(0,0.f);
        glVertex3f(-XSIZE, 0f, 0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(-16.5f, 0f, 0.5f);
        glTexCoord2f(0,0.25f);
        glVertex3f(-XSIZE, 0f, 0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-16.5f, YSIZE + 0.875f, 0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-XSIZE, YSIZE, 0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(-16.5f, YSIZE + 0.875f, 0.01f);
        glTexCoord2f(0,0.75f);
        glVertex3f(-XSIZE, YSIZE, 0.01f);
        glEnd();
        glPopMatrix();

    }

    private void criarCrucifixo(){

        /* Crucifixo da fachada, usado como lâmpada direcional */
        glPushMatrix();
        glColor3f(0.9f,0.9f,0.9f);
        textures.get(7).bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0,0.f);
        glVertex3f(-0.25f, 15, 0.51f);
        glTexCoord2f(0,1.f);
        glVertex3f(-0.25f, 17f, 0.51f);
        glTexCoord2f(1,1.f);
        glVertex3f(0.25f, 17f, 0.51f);
        glTexCoord2f(1,0.f);
        glVertex3f(0.25f, 15, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f, 17.5f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-0.25f, 18.5f, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(0.25f, 18.5f, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(0.25f, 17.5f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f, 17.f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-1.f, 17.f, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(-1.f, 17.5f, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(-0.25f, 17.5f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(0.25f, 17.5f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(1f, 17.5f, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(1f, 17f, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(0.25f, 17f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f, 17f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-0.25f, 17.5f, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(0.25f, 17.5f, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(0.25f, 17f, 0.51f);
        glEnd();
        glPopMatrix();

        float thickness1 = 0.15f;
        glPushMatrix();

        textures.get(0).bind();
        glColor3f(0.6f,0.432f,0.264f);
        /* contorno da cruz */
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f - thickness1, 15, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-0.25f - thickness1, 15-thickness1, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(0.25f + thickness1, 15-thickness1, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(0.25f + thickness1, 15, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f - thickness1, 18.5f, 0.52f);
        glTexCoord2f(0,1);
        glVertex3f(-0.25f - thickness1, 18.5f - thickness1, 0.52f);
        glTexCoord2f(1,1);
        glVertex3f(0.25f + thickness1, 18.5f - thickness1, 0.52f);
        glTexCoord2f(1,0);
        glVertex3f(0.25f + thickness1, 18.5f, 0.52f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(0.25f , 17.5f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(0.25f , 17.5f + thickness1, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(1.f + thickness1, 17.5f + thickness1, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(1.f + thickness1, 17.5f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f , 17.5f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-0.25f , 17.5f + thickness1, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(-1.f - thickness1, 17.5f + thickness1, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(-1.f - thickness1, 17.5f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(0.25f , 17.f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(0.25f , 17.f - thickness1, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(1.f + thickness1, 17.f - thickness1, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(1.f + thickness1, 17.f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f , 17.f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-0.25f , 17.f - thickness1, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(-1.f - thickness1, 17.f - thickness1, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(-1.f - thickness1, 17.f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f , 18.5f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-0.25f - thickness1 , 18.5f, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(-0.25f - thickness1, 17.5f + thickness1, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(-0.25f , 17.5f + thickness1, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(0.25f , 18.5f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(0.25f + thickness1 , 18.5f, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(0.25f + thickness1, 17.5f + thickness1, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(0.25f , 17.5f + thickness1, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-0.25f , 17f - thickness1, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-0.25f - thickness1 , 17f - thickness1, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(-0.25f - thickness1, 15f, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(-0.25f , 15f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(0.25f , 17f - thickness1, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(0.25f + thickness1 , 17f - thickness1, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(0.25f + thickness1, 15f, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(0.25f , 15f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(1f , 17.5f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(1f + thickness1 , 17.5f, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(1f + thickness1, 17f, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(1f , 17f, 0.51f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-1f , 17.5f, 0.51f);
        glTexCoord2f(0,1);
        glVertex3f(-1f - thickness1 , 17.5f, 0.51f);
        glTexCoord2f(1,1);
        glVertex3f(-1f - thickness1, 17f, 0.51f);
        glTexCoord2f(1,0);
        glVertex3f(-1f , 17f, 0.51f);
        glEnd();
        glPopMatrix();
    }

    private void criarVitral(){

        glPushMatrix();
        textures.get(4).bind();
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.25f);
        glVertex3f(-2f, 8f, 0.51f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-2f, 10f, 0.51f);
        glTexCoord2f(0.25f,0.25f);
        glVertex3f(-0.75f, 8f, 0.51f);
        glTexCoord2f(0.25f,0.5f);
        glVertex3f(-0.75f, 10f, 0.51f);
        glTexCoord2f(-0.75f,0.25f);
        glVertex3f(0.75f, 8f, 0.51f);
        glTexCoord2f(-0.75f,0.5f);
        glVertex3f(0.75f, 10f, 0.51f);
        glTexCoord2f(1,0.25f);
        glVertex3f(2f, 8f, 0.51f);
        glTexCoord2f(1,0.5f);
        glVertex3f(2f, 10f, 0.51f);

        glEnd();

        glBegin(GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            float angle = (float) (2*Math.PI*i/360);
            if(sin(angle) >= 0 ){
                glVertex3f((float)cos(angle)*2f, (float)sin(angle)*1f + 10.f ,  0.51f);
            }
        }
        glEnd();

        /* Linhas do vitral*/
        glColor3f(0,0,0);
//        glLineWidth(2);
        glBegin(GL_LINE_LOOP);
        for (int i = 0; i < 360; i++) {
            float angle = (float) (2*Math.PI*i/360);
            if(sin(angle) >= 0 ){
                glVertex3f((float)cos(angle)*2f, (float)sin(angle)*1f + 10.f ,  0.515f);
            }
        }
        glEnd();

        glBegin(GL_LINES);
        glVertex3f(-2f, 10, 0.515f);
        glVertex3f(-2f, 8, 0.515f);
        glEnd();
        glBegin(GL_LINES);
        glVertex3f(-0.75f, 10, 0.515f);
        glVertex3f(-0.75f, 8, 0.515f);
        glEnd();
        glBegin(GL_LINES);
        glVertex3f(0.75f, 10, 0.515f);
        glVertex3f(0.75f, 8, 0.515f);
        glEnd();
        glBegin(GL_LINES);
        glVertex3f(2f, 10, 0.515f);
        glVertex3f(2f, 8, 0.515f);
        glEnd();
        glBegin(GL_LINES);
        glVertex3f(-2f, 8, 0.515f);
        glVertex3f(2f, 8, 0.515f);
        glEnd();
        glPopMatrix();

        glPushMatrix();
        textures.get(5).bind();
        /* Arcos acima das portas */
        //centro
        glBegin(GL_LINE_LOOP);
        for (int i = 0; i < 360; i++) {
            float angle = (float) (2*Math.PI*i/360);
            if(sin(angle) >= 0 ){
                glVertex3f((float)cos(angle)*3, (float)sin(angle)*1.5f + 5.5f ,  0.51f);
            }
        }
        glEnd();
        //direita
        glBegin(GL_LINE_LOOP);
        for (int i = 0; i < 360; i++) {
            float angle = (float) (2*Math.PI*i/360);
            if(sin(angle) >= 0 ){
                glVertex3f((float)cos(angle)*2.5f + 12.5f, (float)sin(angle)*1.5f + 5.5f ,  0.51f);
            }
        }
        glEnd();
        //esquerda
        glBegin(GL_LINE_LOOP);
        for (int i = 0; i < 360; i++) {
            float angle = (float) (2*Math.PI*i/360);
            if(sin(angle) >= 0 ){
                glVertex3f((float)cos(angle)*2.5f - 12.5f, (float)sin(angle)*1.5f + 5.5f ,  0.51f);
            }
        }
        glEnd();

        glPopMatrix();


    }

    private void criarAreaPortaCentral(){

        /* Parede da esquerda*/
        glPushMatrix();
        textures.get(1).bind();
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0);
        glVertex3f(-3, 0, 0.01f);
        glTexCoord2f(1,0);
        glVertex3f(-3, YSIZE+9.5f, 0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(-3, 0, 0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(-3, YSIZE+9.5f, 0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-4.5f, 0, 0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(-4.5f, YSIZE+9.125f, 0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(-4.5f, 0, 0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(-4.5f, YSIZE+9.125f, 0.01f);
        glEnd();


        /* Parede da direita */
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0);
        glVertex3f(3, 0, 0.01f);
        glTexCoord2f(1,0);
        glVertex3f(3, YSIZE+9.5f, 0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(3, 0, 0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(3, YSIZE+9.5f, 0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(4.5f, 0, 0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(4.5f, YSIZE+9.125f, 0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(4.5f, 0, 0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(4.5f, YSIZE+9.125f, 0.01f);
        glEnd();

        /* Parede acima da porta */
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0);
        glVertex3f(-3, 5.5f,0.01f);
        glTexCoord2f(1,0);
        glVertex3f(0, 5.5f,0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(-3, 5.5f,0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(0, 5.5f,0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-3, YSIZE + 9.5f,0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(0, YSIZE + 9.5f + 0.75f,0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(-3, YSIZE + 9.5f,0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(0, YSIZE + 9.5f + 0.75f,0.01f);
        glTexCoord2f(0,1);
        glVertex3f(-3, 5.5f,0.01f);
        glTexCoord2f(1,1);
        glVertex3f(0, 5.5f,0.01f);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0);
        glVertex3f(3, 5.5f,0.01f);
        glTexCoord2f(1,0);
        glVertex3f(0,5.5f,0.01f);
        glTexCoord2f(0,0.25f);
        glVertex3f(3, 5.5f,0.5f);
        glTexCoord2f(1,0.25f);
        glVertex3f(0, 5.5f,0.5f);
        glTexCoord2f(0,0.5f);
        glVertex3f(3, YSIZE + 9.5f,0.5f);
        glTexCoord2f(1,0.5f);
        glVertex3f(0, YSIZE + 9.5f + 0.75f,0.5f);
        glTexCoord2f(0,0.75f);
        glVertex3f(3, YSIZE + 9.5f,0.01f);
        glTexCoord2f(1,0.75f);
        glVertex3f(0, YSIZE + 9.5f + 0.75f,0.01f);
        glTexCoord2f(0,1);
        glVertex3f(3, 5.5f,0.01f);
        glTexCoord2f(1,1);
        glVertex3f(0, 5.5f,0.01f);
        glEnd();

        /* Cobertura acima da porta*/
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0);
        glVertex3f(-3.5f, 7.5f,0);
        glTexCoord2f(1,0);
        glVertex3f(3.5f, 7.5f,0);
        glTexCoord2f(0,0.25f);
        glVertex3f(-3.5f, 7.5f,4);
        glTexCoord2f(1,0.25f);
        glVertex3f(3.5f, 7.5f,4);
        glTexCoord2f(0,0.5f);
        glVertex3f(-3.5f, 8f,4);
        glTexCoord2f(1,0.5f);
        glVertex3f(3.5f, 8f,4);
        glTexCoord2f(0,0.75f);
        glVertex3f(-3.5f, 8f,0);
        glTexCoord2f(1,0.75f);
        glVertex3f(3.5f, 8f,0);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(-3.5f, 7.5f,0);
        glTexCoord2f(0,1);
        glVertex3f(-3.5f, 7.5f,4);
        glTexCoord2f(1,1);
        glVertex3f(-3.5f, 8f,4);
        glTexCoord2f(1,0);
        glVertex3f(-3.5f, 8f,0);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex3f(3.5f, 7.5f,0);
        glTexCoord2f(0,1);
        glVertex3f(3.5f, 7.5f,4);
        glTexCoord2f(1,1);
        glVertex3f(3.5f, 8f,4);
        glTexCoord2f(1,0);
        glVertex3f(3.5f, 8f,0);
        glEnd();
        glPopMatrix();
    }

    private void criarPilaresLaterais(float x, float y, float z){
        glPushMatrix();
        textures.get(3).bind();
        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(-x,0,0);
        glTexCoord2f(1,0.f);
        glVertex3f(-x,y,0);
        glTexCoord2f(0,0.25f);
        glVertex3f(-x,0,z);
        glTexCoord2f(01,0.25f);
        glVertex3f(-x,y,z);
        glTexCoord2f(0,0.75f);
        glVertex3f(-x + 0.5f,0,z);
        glTexCoord2f(1,0.75f);
        glVertex3f(-x + 0.5f,y+0.125f,z);
        glTexCoord2f(0,1f);
        glVertex3f(-x + 0.5f,0,0);
        glTexCoord2f(1,1f);
        glVertex3f(-x + 0.5f,y+0.125f,0);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(-x +1,0,0);
        glTexCoord2f(1,0.f);
        glVertex3f(-x +1,y+0.25f,0);
        glTexCoord2f(0,0.25f);
        glVertex3f(-x +1,0,z);
        glTexCoord2f(1,0.25f);
        glVertex3f(-x +1,y+0.25f,z);
        glTexCoord2f(0,0.5f);
        glVertex3f(-x + 1.5f,0,z);
        glTexCoord2f(1,0.5f);
        glVertex3f(-x + 1.5f,y+0.375f,z);
        glTexCoord2f(0,0.75f);
        glVertex3f(-x + 1.5f,0,0);
        glTexCoord2f(1,0.75f);
        glVertex3f(-x + 1.5f,y+0.375f,0);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(x,0,0);
        glTexCoord2f(1,0.f);
        glVertex3f(x,y,0);
        glTexCoord2f(0,0.25f);
        glVertex3f(x,0,z);
        glTexCoord2f(1,0.25f);
        glVertex3f(x, y, z);
        glTexCoord2f(0,0.5f);
        glVertex3f(x - 0.5f,0,z);
        glTexCoord2f(1,0.5f);
        glVertex3f(x - 0.5f,y+0.125f,z);
        glTexCoord2f(0,0.75f);
        glVertex3f(x - 0.5f,0,0);
        glTexCoord2f(1,0.75f);
        glVertex3f(x - 0.5f,y+0.125f,0);
        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(x -1,0,0);
        glTexCoord2f(1,0.f);
        glVertex3f(x -1,y+0.25f,0);
        glTexCoord2f(0,0.25f);
        glVertex3f(x -1,0,z);
        glTexCoord2f(1,0.25f);
        glVertex3f(x -1,y+0.25f,z);
        glTexCoord2f(0,0.5f);
        glVertex3f(x - 1.5f,0,z);
        glTexCoord2f(1,0.5f);
        glVertex3f(x - 1.5f,y+0.375f,z);
        glTexCoord2f(0,0.75f);
        glVertex3f(x - 1.5f,0,0);
        glTexCoord2f(1,0.75f);
        glVertex3f(x - 1.5f,y+0.375f,0);
        glEnd();
        glPopMatrix();
    }

}

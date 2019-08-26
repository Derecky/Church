package things;

import utils.Texture;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class AltarChair {

    float ydif = 0.6f;
    float ydifas = 0.4f;

    final float thickness = 0.05f;

    List<Texture> textures;

    public AltarChair(List<Texture> textures){
        this.textures = textures;
    }

    public void altarChair(){

        textures.get(0).bind();
        glColor3f(0.5f,0.216f,0.132f);
        hasteAltarChair1();
        hasteAltarChair2();
        assento();
        encosto();

    }

    private void encosto(){

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f( -1.0f + thickness, 2.5f + ydif, -92.5f + 0.2f );
        glTexCoord2f(1,0.f);
        glVertex3f( 1.0f - thickness, 2.5f + ydif, -92.5f + 0.2f );
        glTexCoord2f(0,0.25f);
        glVertex3f(  -1.0f + thickness, 2.8f + ydif, -92.5f + 0.2f );
        glTexCoord2f(1,0.25f);
        glVertex3f( 1.0f - thickness, 2.8f + ydif, -92.5f + 0.2f );
        glTexCoord2f(0,0.5f);
        glVertex3f(  -1.0f + thickness, 2.8f + ydif, -92.5f - 2*thickness  + 0.2f);
        glTexCoord2f(1,0.5f);
        glVertex3f( 1.0f - thickness, 2.8f + ydif, -92.5f - 2*thickness  + 0.2f);
        glTexCoord2f(0,0.75f);
        glVertex3f(  -1.0f + thickness, 2.5f + ydif, -92.5f - 2*thickness  + 0.2f);
        glTexCoord2f(1,0.75f);
        glVertex3f( 1.0f  - thickness, 2.5f + ydif, -92.5f - 2*thickness  + 0.2f);
        glTexCoord2f(0,1.f);
        glVertex3f( -1.0f + thickness, 2.5f + ydif, -92.5f + 0.2f);
        glTexCoord2f(1,1.f);
        glVertex3f( 1.0f  - thickness, 2.5f + ydif,-92.5f + 0.2f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0.f);
        glVertex3f(-1.0f + thickness, 2.5f + ydif, -92.5f + 0.2f );
        glTexCoord2f(0,1.f);
        glVertex3f(-1.0f + thickness, 2.8f + ydif, -92.5f  + 0.2f);
        glTexCoord2f(1,1.f);
        glVertex3f(-1.0f + thickness, 2.8f + ydif, -92.5f - 2*thickness  + 0.2f);
        glTexCoord2f(1,0.f);
        glVertex3f(-1.0f + thickness, 2.5f + ydif, -92.5f - 2*thickness  + 0.2f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0.f);
        glVertex3f(1.0f  - thickness, 2.5f + ydif, -92.5f + 0.2f);
        glTexCoord2f(0,1.f);
        glVertex3f(1.0f  - thickness, 2.8f + ydif, -92.5f + 0.2f);
        glTexCoord2f(1,1.f);
        glVertex3f(1.0f  - thickness, 2.8f + ydif, -92.5f - 2*thickness + 0.2f );
        glTexCoord2f(1,0.f);
        glVertex3f(1.0f - thickness, 2.5f + ydif, -92.5f - 2*thickness  + 0.2f);
        glEnd();


        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f( -1.0f + thickness, 3.2f + ydif, -92.5f+ 0.2f );
        glTexCoord2f(1,0.f);
        glVertex3f( 1.0f - thickness, 3.2f + ydif, -92.5f + 0.2f);
        glTexCoord2f(0,0.25f);
        glVertex3f(  -1.0f + thickness, 3.5f + ydif, -92.5f + 0.2f);
        glTexCoord2f(1,0.25f);
        glVertex3f( 1.0f - thickness, 3.5f + ydif, -92.5f + 0.2f);
        glTexCoord2f(0,0.5f);
        glVertex3f(  -1.0f + thickness, 3.5f + ydif, -92.5f - 2*thickness + 0.2f);
        glTexCoord2f(1,0.5f);
        glVertex3f( 1.0f - thickness, 3.5f + ydif, -92.5f - 2*thickness + 0.2f);
        glTexCoord2f(0,0.75f);
        glVertex3f(  -1.0f + thickness, 3.2f + ydif, -92.5f - 2*thickness + 0.2f);
        glTexCoord2f(1,0.75f);
        glVertex3f( 1.0f  - thickness, 3.2f + ydif, -92.5f - 2*thickness + 0.2f);
        glTexCoord2f(0,1.f);
        glVertex3f( -1.0f + thickness, 3.2f + ydif, -92.5f+ 0.2f);
        glTexCoord2f(1,1.f);
        glVertex3f( 1.0f  - thickness, 3.2f + ydif,-92.5f+ 0.2f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0.f);
        glVertex3f(-1.0f + thickness, 3.2f + ydif, -92.5f + 0.2f);
        glTexCoord2f(0,1.f);
        glVertex3f(-1.0f + thickness, 3.5f + ydif, -92.5f + 0.2f);
        glTexCoord2f(1,1.f);
        glVertex3f(-1.0f + thickness, 3.5f + ydif, -92.5f - 2*thickness + 0.2f );
        glTexCoord2f(1,0.f);
        glVertex3f(-1.0f + thickness, 3.2f + ydif, -92.5f - 2*thickness + 0.2f);
        glEnd();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0.f);
        glVertex3f(1.0f  - thickness, 3.2f + ydif, -92.5f+ 0.2f);
        glTexCoord2f(0,1.f);
        glVertex3f(1.0f  - thickness, 3.5f + ydif, -92.5f+ 0.2f);
        glTexCoord2f(1,1.f);
        glVertex3f(1.0f  - thickness, 3.5f + ydif, -92.5f - 2*thickness + 0.2f);
        glTexCoord2f(1,0.f);
        glVertex3f(1.0f - thickness, 3.2f + ydif, -92.5f - 2*thickness+ 0.2f );
        glEnd();

    }

    private void assento(){

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(-1.0f + thickness, 2.0f-3*thickness + ydifas, -90.5f-0.1f);
        glTexCoord2f(1,0.f);
        glVertex3f(1.0f - thickness, 2.0f-3*thickness + ydifas, -90.5f-0.1f);
        glTexCoord2f(0,0.25f);
        glVertex3f(-1.0f + thickness, 2.0f-thickness + ydifas, -90.5f-0.1f);
        glTexCoord2f(1,0.25f);
        glVertex3f(1.0f - thickness, 2.0f-thickness + ydifas, -90.5f-0.1f);
        glTexCoord2f(0,0.5f);
        glVertex3f(-1.0f + thickness, 2.0f-thickness + ydifas, -90.5f-2);
        glTexCoord2f(1,0.5f);
        glVertex3f(1.0f - thickness, 2.0f-thickness + ydifas, -90.5f-2);
        glTexCoord2f(0,0.75f);
        glVertex3f(-1.0f + thickness, 2.0f-3*thickness + ydifas, -90.5f-2);
        glTexCoord2f(1,0.75f);
        glVertex3f(1.0f - thickness, 2.0f-3*thickness + ydifas, -90.5f-2);
        glTexCoord2f(0,1.f);
        glVertex3f(-1.0f + thickness, 2.0f-3*thickness + ydifas, -90.5f-0.1f);
        glTexCoord2f(1,1.f);
        glVertex3f(1.0f - thickness, 2.0f-3*thickness + ydifas, -90.5f-0.1f);
        glEnd();

    }

    private void hasteAltarChair1(){

        glBegin(GL_POLYGON);
        glTexCoord2f(0,0.f);
        glVertex3f(-1.0f-thickness, 1, -92.5f);
        glTexCoord2f(0.2f,0.f);
        glVertex3f(-1.0f-thickness, 1,-92.5f+2);
        glTexCoord2f(0.2f,0.5f);
        glVertex3f(-1.0f-thickness,3.0f,-92.5f+2 );
        glTexCoord2f(1,0.5f);
        glVertex3f(-1.0f-thickness, 3.0f,-92.5f+0.3f);
        glTexCoord2f(1,1f);
        glVertex3f(-1.0f-thickness,4.5f,-92.5f+0.3f);
        glTexCoord2f(0,1.f);
        glVertex3f(-1.0f-thickness,4.5f,-92.5f);
        glEnd();

        glBegin(GL_POLYGON);
        glTexCoord2f(0,0.f);
        glVertex3f(-1.0f+thickness, 1, -92.5f);
        glTexCoord2f(0.2f,0.f);
        glVertex3f(-1.0f+thickness, 1,-92.5f+2);
        glTexCoord2f(0.2f,0.5f);
        glVertex3f(-1.0f+thickness,3.0f,-92.5f+2 );
        glTexCoord2f(1,0.5f);
        glVertex3f(-1.0f+thickness, 3.0f,-92.5f+0.3f);
        glTexCoord2f(1,1f);
        glVertex3f(-1.0f+thickness,4.5f,-92.5f+0.3f);
        glTexCoord2f(0,1.f);
        glVertex3f(-1.0f+thickness,4.5f,-92.5f);

        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(-1.0f-thickness, 1, -92.5f);
        glTexCoord2f(1,0.f);
        glVertex3f(-1.0f+thickness, 1, -92.5f);
        glTexCoord2f(0,0.2f);
        glVertex3f(-1.0f-thickness, 1,-92.5f+2);
        glTexCoord2f(1,0.2f);
        glVertex3f(-1.0f+thickness, 1,-92.5f+2);
        glTexCoord2f(0,0.4f);
        glVertex3f(-1.0f-thickness,3.0f,-92.5f+2 );
        glTexCoord2f(1,0.4f);
        glVertex3f(-1.0f+thickness,3.0f,-92.5f+2 );
        glTexCoord2f(0,0.6f);
        glVertex3f(-1.0f-thickness, 3.0f,-92.5f+0.3f);
        glTexCoord2f(1,0.6f);
        glVertex3f(-1.0f+thickness, 3.0f,-92.5f+0.3f);
        glTexCoord2f(0,0.8f);
        glVertex3f(-1.0f-thickness,4.5f,-92.5f+0.3f);
        glTexCoord2f(1,0.8f);
        glVertex3f(-1.0f+thickness,4.5f,-92.5f+0.3f);
        glTexCoord2f(0,1.f);
        glVertex3f(-1.0f-thickness,4.5f,-92.5f);
        glTexCoord2f(1,1.f);
        glVertex3f(-1.0f+thickness,4.5f,-92.5f);
        glEnd();
    }

    private void hasteAltarChair2(){

        glBegin(GL_POLYGON);
        glTexCoord2f(0,0.f);
        glVertex3f(1.0f-thickness, 1 , -92.5f);
        glTexCoord2f(0.2f,0.f);
        glVertex3f(1.0f-thickness, 1 ,-92.5f+2);
        glTexCoord2f(0.2f,0.5f);
        glVertex3f(1.0f-thickness,3.0f ,-92.5f+2 );
        glTexCoord2f(1,0.5f);
        glVertex3f(1.0f-thickness, 3.0f ,-92.5f+0.3f);
        glTexCoord2f(1,1f);
        glVertex3f(1.0f-thickness,4.5f,-92.5f+0.3f);
        glTexCoord2f(0,1.f);
        glVertex3f(1.0f-thickness,4.5f ,-92.5f);
        glEnd();

        glBegin(GL_POLYGON);
        glTexCoord2f(0,0.f);
        glVertex3f(1.0f+thickness, 1 , -92.5f);
        glTexCoord2f(0.2f,0.f);
        glVertex3f(1.0f+thickness, 1 ,-92.5f+2);
        glTexCoord2f(0.2f,0.5f);
        glVertex3f(1.0f+thickness,3.0f,-92.5f+2 );
        glTexCoord2f(1f,0.5f);
        glVertex3f(1.0f+thickness, 3.0f ,-92.5f+0.3f);
        glTexCoord2f(1,1.f);
        glVertex3f(1.0f+thickness,4.5f,-92.5f+0.3f);
        glTexCoord2f(0,1.f);
        glVertex3f(1.0f+thickness,4.5f,-92.5f);

        glEnd();

        glBegin(GL_QUAD_STRIP);
        glTexCoord2f(0,0.f);
        glVertex3f(1.0f-thickness, 1 , -92.5f);
        glTexCoord2f(1,0.f);
        glVertex3f(1.0f+thickness, 1 , -92.5f);
        glTexCoord2f(0,0.2f);
        glVertex3f(1.0f-thickness, 1 ,-92.5f+2);
        glTexCoord2f(1,0.2f);
        glVertex3f(1.0f+thickness, 1 ,-92.5f+2);
        glTexCoord2f(0,0.4f);
        glVertex3f(1.0f-thickness,3.0f ,-92.5f+2 );
        glTexCoord2f(1,0.4f);
        glVertex3f(1.0f+thickness,3.0f ,-92.5f+2 );
        glTexCoord2f(0,0.6f);
        glVertex3f(1.0f-thickness, 3.0f ,-92.5f+0.3f);
        glTexCoord2f(1,0.6f);
        glVertex3f(1.0f+thickness, 3.0f,-92.5f+0.3f);
        glTexCoord2f(0,0.8f);
        glVertex3f(1.0f-thickness,4.5f,-92.5f+0.3f);
        glTexCoord2f(1,0.8f);
        glVertex3f(1.0f+thickness,4.5f,-92.5f+0.3f);
        glTexCoord2f(0,1.f);
        glVertex3f(1.0f-thickness,4.5f,-92.5f);
        glTexCoord2f(1,1.f);
        glVertex3f(1.0f+thickness,4.5f,-92.5f);
        glEnd();
    }

}

package structure;

import org.joml.Vector3f;
import utils.Texture;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Door {

    private List<Texture> textures;
    private float door_angle;
    private Vector3f pointleft;
    private Vector3f pointright;
    private Vector3f backDoorsR;


    public Door(float door_angle){
        this.door_angle = door_angle;
    }

    public void update(float x, float tam, List<Texture> textures, float door_angle, boolean cond){
        this.textures = textures;
        this.door_angle = door_angle;
        if (cond)
            drawDoubleDoorXPosition(x, tam);
        else
            drawBackDoors(x, tam);
    }

    public void drawDoubleDoorXPosition(float x, float tam){

        pointright = new Vector3f((float) (tam*cos(door_angle)),0, (float) (tam*sin(door_angle)));
        pointleft = new Vector3f((float) (tam*cos(door_angle)), 0 , (float) (tam*sin(door_angle)));

        glColor3f(0.9f,0.9f,0.9f);
        textures.get(6).bind();
        /* Left */

        glPushMatrix();
        glBegin(GL_QUADS);
        glNormal3f(0,0,1);
        glTexCoord2f(0,0);
        glVertex3f(x-tam+pointright.x,0,pointright.z);
        glTexCoord2f(0,1);
        glVertex3f(x-tam,0,0);
        glTexCoord2f(1,1);
        glVertex3f(x-tam,5.5f,0);
        glTexCoord2f(1,0);
        glVertex3f(x-tam+pointright.x,5.5f,pointright.z);
        glEnd();
        glPopMatrix();

        glPushMatrix();
        glBegin(GL_QUADS);
        glNormal3f(0,0, 1);
        glTexCoord2f(0,0);
        glVertex3f(x+tam-pointleft.x,0,pointleft.z);
        glTexCoord2f(0,1);
        glVertex3f(x+tam,0,0);
        glTexCoord2f(1,1);
        glVertex3f(x+tam,5.5f,0);
        glTexCoord2f(1,0);
        glVertex3f(x+tam-pointleft.x,5.5f,pointleft.z);
        glEnd();
        glPopMatrix();

    }

    public void drawBackDoors(float x, float tam){

        glColor3f(0.3f,0.3f,0.3f);
        glPushMatrix();
        textures.get(6).bind();
        glBegin(GL_QUADS);
        glNormal3f(0,0,1);
        glTexCoord2f(0,1);
        glVertex3f(x,0,-3.5f*30 + 17 + 0.025f*3);
        glTexCoord2f(1,1);
        glVertex3f(x-tam,0,-3.5f*30 + 17 + 0.025f*3);
        glTexCoord2f(1,0);
        glVertex3f(x-tam,5f,-3.5f*30 + 17 + 0.025f*3);
        glTexCoord2f(0,0);
        glVertex3f(x,5f,-3.5f*30 + 17 + 0.025f*3);
        glEnd();
        glPopMatrix();

        textures.get(5).bind();
        glBegin(GL_POLYGON);
        for (int k = 0; k < 360; k++) {
            float angle = (float) (2*Math.PI*k/360);
            if(StrictMath.sin(angle) >= 0 ){
                glTexCoord2f( 0.2f + ((float)cos(angle)+1)/3.25f,0.5f + 0.35f*(float) StrictMath.sin(angle));
                glVertex3f(x-(tam/2) + (float)cos(angle)*(tam/2) , 5 + (float) StrictMath.sin(angle)*1.f , -3.5f*30 + 17.01f + 0.025f*3 );
            }
        }
        glEnd();
        glBegin(GL_LINE_LOOP);
        for (int k = 0; k < 360; k++) {
            float angle = (float) (2*Math.PI*k/360);
            if(StrictMath.sin(angle) >= 0 ){
                glVertex3f(x-(tam/2) + (float)cos(angle)*(tam/2) , 5 + (float) StrictMath.sin(angle)*1.f , -3.5f*30 + 17.01f + 0.025f*3 );
            }
        }
        glEnd();

        textures.get(6).bind();
        glPushMatrix();
        glBegin(GL_QUADS);
        glNormal3f(0,0, 1);
        glTexCoord2f(0,1);
        glVertex3f(-x ,0,-3.5f*30 + 17 + 0.025f*3);
        glTexCoord2f(1,1);
        glVertex3f(-x+tam,0,-3.5f*30 + 17 + 0.025f*3);
        glTexCoord2f(1,0);
        glVertex3f(-x+tam,5f,-3.5f*30 + 17 + 0.025f*3);
        glTexCoord2f(0,0);
        glVertex3f(-x ,5f,-3.5f*30 + 17 + 0.025f*3);
        glEnd();
        glPopMatrix();

        textures.get(5).bind();
        glBegin(GL_POLYGON);
        for (int k = 0; k < 360; k++) {
            float angle = (float) (2*Math.PI*k/360);
            if(StrictMath.sin(angle) >= 0 ){
                glTexCoord2f( 0.2f + ((float)cos(angle)+1)/3.25f,0.5f + 0.35f*(float) StrictMath.sin(angle));
                glVertex3f(-x+(tam/2) - (float)cos(angle)*(tam/2) , 5 + (float) StrictMath.sin(angle)*1.f , -3.5f*30 + 17.01f + 0.025f*3 );
            }
        }
        glEnd();
        glBegin(GL_LINE_LOOP);
        for (int k = 0; k < 360; k++) {
            float angle = (float) (2*Math.PI*k/360);
            if(StrictMath.sin(angle) >= 0 ){
                glVertex3f(-x+(tam/2) - (float)cos(angle)*(tam/2) , 5 + (float) StrictMath.sin(angle)*1.f , -3.5f*30 + 17.01f + 0.025f*3 );
            }
        }
        glEnd();

    }
}

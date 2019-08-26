package structure;

import org.joml.Vector3f;
import utils.Texture;

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

    public void update(float x, float tam, List<Texture> textures, float door_angle){
        this.textures = textures;
        this.door_angle = door_angle;
        drawDoubleDoorXPosition(x, tam);
    }

    public void drawDoubleDoorXPosition(float x, float tam){

        pointright = new Vector3f((float) (3*cos(door_angle)),0, (float) (3*sin(door_angle)));
        pointleft = new Vector3f((float) (3*cos(door_angle)), 0 , (float) (3*sin(door_angle)));

        glColor3f(0.9f,0.9f,0.9f);
        textures.get(6).bind();
        /* Left */
        glPushMatrix();
        glBegin(GL_QUADS);
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

    public void drawBackDoors(float x, float tam, boolean direction){

        backDoorsR = new Vector3f((float) (3*cos(-door_angle)), 0 , (float) (3*sin(-door_angle)));

        glColor3f(0.2f,0.2f,0.2f);
        glPushMatrix();
        glBegin(GL_QUADS);
        glVertex3f(x-tam ,0,-3.5f*30 + 17 + 0.025f*3);
        glVertex3f(x-tam + backDoorsR.x,0,backDoorsR.z-3.5f*30 + 17 + 0.025f*3);
        glVertex3f(x-tam + backDoorsR.x,5f,backDoorsR.z-3.5f*30 + 17 + 0.025f*3);
        glVertex3f(x-tam ,5f,-3.5f*30 + 17 + 0.025f*3);
        glEnd();
        glPopMatrix();

    }
}

package utils;

import org.joml.Vector3f;
import static org.lwjgl.opengl.GL11.*;


public class Material {

    Vector3f ambient;
    Vector3f diffuse;
    Vector3f specular;
    float shininess;

    public Material(){
        this.ambient = new Vector3f();
        this.diffuse = new Vector3f();
        this.specular = new Vector3f();
    }

    public void extra(){

    }
}

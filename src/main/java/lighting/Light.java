package lighting;

import static org.lwjgl.opengl.GL11.*;

public class Light {

    float x;
    float z;

    public Light(float x, float z){
        this.x = x;
        this.z = z;
    }

    public void drawLights(){
        putLights();
    }

    private void putLights() {
        float[] luzAmbiente = {0.2f, 0.2f, 0.2f, 1.0f};
        float[] luzDifusa = {0.7f,0.7f,0.7f,1.0f};	        // "cor"
        float[] luzEspecular = {1.0f, .0f, 1.0f, 1.0f};    // "brilho"
        float[] posicaoLuz = {x, 9, z, 1};
//        {0.0f, 50.0f, 50.0f, 1.0f};

        // Capacidade de brilho do material
        float[] especularidade = {1.0f,1.0f,1.0f,1.0f};
        int especMaterial = 60;

        // Exibe uma linha da posição da luz até (0,0,0)
        glBegin(GL_LINES);
        glColor3f(0,0,0);
        glVertex4fv(posicaoLuz);
        glVertex3f(0,0,0);
        glEnd();

        // Habilita o modelo de colorização de Gouraud
        glShadeModel(GL_SMOOTH);

        // Define a refletância do material
        glMaterialfv(GL_FRONT,GL_SPECULAR, especularidade);
        // Define a concentração do brilho
        glMateriali(GL_FRONT,GL_SHININESS,especMaterial);

        // Ativa o uso da luz ambiente
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, luzAmbiente);

        // Define os parâmetros da luz de número 0
        glLightfv(GL_LIGHT0, GL_AMBIENT, luzAmbiente);
        glLightfv(GL_LIGHT0, GL_DIFFUSE, luzDifusa );
        glLightfv(GL_LIGHT0, GL_SPECULAR, luzEspecular );
        glLightfv(GL_LIGHT0, GL_POSITION, posicaoLuz );

        // Habilita a definição da cor do material a partir da cor corrente
        glEnable(GL_COLOR_MATERIAL);
        //Habilita o uso de iluminação
        glEnable(GL_LIGHTING);
        // Habilita a luz de número 0
        glEnable(GL_LIGHT0);
    }

}

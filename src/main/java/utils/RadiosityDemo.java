package utils;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class RadiosityDemo extends Applet implements ActionListener, ItemListener{
        //// constants
        // possible element sizes
        static final int esizs[] = { 2, 4, 8, 16, 32, 64 };

        //// attributes
        boolean swmod;              // modify flag
        Dimension siz;              // size of the applet
        Button sttbtn, rstbtn;      // GUI components
        Label lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8;
        Panel pnl1, pnl2, pnl3, pnl4, pnl5, pnl6, pnl7, pnl8;
        Panel pnl0a, pnld;
        TextField ceilfld, wallfld, flrfld, wndfld, iterfld;
        Choice esizchc;
        RMCanvas rmcvs;

        //// methods

        // init
        public void init () {
        //// make array objects
        //// make components & lay them out
        siz = getSize();
        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 0x80));
        setForeground(Color.white);

        pnl1 = new Panel();
        pnl1.setLayout(new FlowLayout());
        pnl1.add(sttbtn = new Button("Start"));
        pnl1.add(rstbtn = new Button("Reset"));
        pnl2 = new Panel();
        pnl2.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnl2.add(lbl2 = new Label("Reflection:"));
        pnl3 = new Panel();
        pnl3.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));
        pnl3.add(lbl3 = new Label("ceiling:"));
        pnl3.add(ceilfld = new TextField("0.7", 10));
        pnl4 = new Panel();
        pnl4.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));
        pnl4.add(lbl4 = new Label("wall:"));
        pnl4.add(wallfld = new TextField("0.5", 10));
        pnl5 = new Panel();
        pnl5.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));
        pnl5.add(lbl5 = new Label("window:"));
        pnl5.add(wndfld = new TextField("0.9", 10));
        pnl6 = new Panel();
        pnl6.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));
        pnl6.add(lbl6 = new Label("floor:"));
        pnl6.add(flrfld = new TextField("0.9", 10));
        pnld = new Panel();
        pnl7 = new Panel();
        pnl7.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        pnl7.add(lbl7 = new Label("Iteration:"));
        pnl7.add(iterfld = new TextField("10", 10));
        pnl8 = new Panel();
        pnl8.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        pnl8.add(lbl8 = new Label("Element size:"));
        pnl8.add(esizchc = new Choice());
        for (int i = 0; i < esizs.length; i++)
            esizchc.addItem("" + esizs[i]);
        esizchc.select(2);

        pnl0a = new Panel();
        pnl0a.setLayout(new GridLayout(9, 1, 0, 0));
        pnl0a.setSize(160, 160);
        pnl0a.add(pnl1);
        pnl0a.add(pnl2);
        pnl0a.add(pnl3);
        pnl0a.add(pnl4);
        pnl0a.add(pnl5);
        pnl0a.add(pnl6);
        pnl0a.add(pnld);
        pnl0a.add(pnl7);
        pnl0a.add(pnl8);
        pnl0a.setSize(160, 320);
        add("East", pnl0a);

        rmcvs = new RMCanvas(this);
        rmcvs.setSize(320, 320);
        rmcvs.setBackground(Color.black);
        add("West", rmcvs);

        //// initialize the kernel
        resetKernel();

        //// register buttons to listener
        sttbtn.addActionListener(this);
        rstbtn.addActionListener(this);
        esizchc.addItemListener(this);
    }

        // paint
        public void paint (Graphics g) {
    }

        // resetRMKernel : Resets the kernel (RMcanvas)
        void resetKernel () {
        showStatus("Reset...");
        if (!rmcvs.resetIt()) {
            showStatus("Error occurred! (Illegal value?)");
            return;
        }
        showStatus("Now ready to go!");
        swmod = false;    // clear modify flag
        rmcvs.repaint();
    }

        // itemStateChanged
        public void itemStateChanged (ItemEvent ie) {
        swmod = true;        // parameter changed
    }

        // actionPerformed
        public void actionPerformed (ActionEvent ae) {
        Object sobj = ae.getSource();
        if (sobj == sttbtn) {
            if (swmod)        // if parameter changed
                resetKernel();  // reset
            showStatus("Now calculating...");
            if (!rmcvs.calcRadiosity()) {
                showStatus("Error occurred! (Illegal value?)");
                return;
            }
            showStatus("Done.");
            rmcvs.repaint();
        } else if (sobj == rstbtn) {
            resetKernel();
        }
    }

        // getAppletInfo
        public String getAppletInfo () {
        return "Applet 'RadiosityDemo' by T.Yato (2001/02/16)\n";
    }
    }

    /*
     * class RMCanvas : radiosity method simulation kernel
     */
    class RMCanvas extends Canvas
    {
        //// constants
        static final int WD = 256, HT = 256;  // size of the room
        // obstacle is a horizontal bar
        static final int X1 = 128, Y1 = 191;  // position of left end
        static final int X2 = 192, Y2 = Y1;   // position of right end
        static final int Y3 = 64, Y4 = 128;   // y-coord. of the window (x = 0)
        static final int XM = 32, YM = 32;    // margins
        static final int L1 = 500;           // radiosity of direct light
        static final int L0 = 0;              // (no light)
        static final int LWD = 64;            // light source width
        static final int BWD = 6;
        static final int INIT = 0, BUSY = 1, DONE = 2; // state constants
        static final int M_GS = 0, M_PR = 1;           // method no.
        static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3; // vector no.
        static final int CEIL = 0, WALL = 1, WND = 2, FLR = 3, OBST = 4;

        //// attributes
        RadiosityDemo app;                // applet that created this
        int state;                        // current state
        int xl;                           // x-coord. of the light (y = 0)
        int method;                       // method to use
        int imax;                         // max iteration count
        int esiz;                         // element size
        int ne;                           // number of elements
        int xc[], yc[];                   // center of each element
        int pt[];                         // part no. of each element
        int nr[];                         // normal vector no. of each element
        double ff[][];                    // form factor between elememts
        double prho[];                    // reflection ratio of each part
        double e0[];                      // radiosity of each element (direct)
        double e[];                       // radiosity of each element

        //// methods

        // <constructor>
        public RMCanvas (RadiosityDemo app0){
            app = app0;
        }

        // calcRadiosity : Calculates radiosity of each element.
        boolean calcRadiosity () {
            double a[][] = new double[ne][ne];
            prho = new double[5];
            e = new double[ne];
            state = BUSY; method = M_GS;

            // get parameters from applet
            try {
                prho[CEIL] = Double.valueOf(app.ceilfld.getText()).doubleValue();
                prho[WALL] = Double.valueOf(app.wallfld.getText()).doubleValue();
                prho[WND] = Double.valueOf(app.wndfld.getText()).doubleValue();
                prho[FLR] = Double.valueOf(app.flrfld.getText()).doubleValue();
                prho[OBST] = prho[FLR];
                imax = Integer.parseInt(app.iterfld.getText());
            } catch (NumberFormatException e) {
                return false;
            }

            // make coefficient matrix
            for (int i = 0; i < ne; i++) {
                for (int j = 0; j < ne; j++)
                    a[i][j] = -prho[pt[i]] * ff[i][j];
                a[i][i] += 1.0;    // = 1.0, actually...
            }

            // solve the radiosity equation
            if (method == M_GS)
                solveGaussSeidel(a);
            else
                return false;

            state = DONE;
            return true;
        }

        // solveGaussSeidel : Solves the radiosity equation (a*e = e0)
        //   by using Gauss-Seidel method.
        void solveGaussSeidel (double a[][]) {
            for (int i = 0; i < ne; i++)
                e[i] = e0[i];
            double s;
            for (int c = 0; c < imax; c++) {
                app.showStatus("Loop " + c);
                for (int i = 0; i < ne; i++) {
                    s = e0[i];
                    for (int j = 0; j < ne; j++)
                        s -= a[i][j] * e[j];
                    e[i] += s;
                }
            }
        }

        // setParameters : Sets parameters of each element.
        boolean setParameters () {
            int c = 0, n, i, x, y, hsiz;
            n = (WD*2 + HT*2 + (X2-X1)*2) / esiz;
            hsiz = esiz / 2;
            xc = new int[n]; yc = new int[n];
            pt = new int[n]; nr = new int[n];
            e0 = new double[n];
            for (i = 0; i < n; i++)
                e0[i] = (double)L0;

            // ceiling
            n = WD / esiz; x = hsiz;
            for (i = 0; i < n; i++) {
                xc[c] = x; yc[c] = 0;
                pt[c] = CEIL; nr[c] = DOWN;
                if (xl - LWD/2 <= x && x < xl + LWD/2)
                    e0[c] = (double)L1; // element includes light
                c++; x += esiz;
            }
            // floor
            x = hsiz;
            for (i = 0; i < n; i++) {
                xc[c] = x; yc[c] = HT;
                pt[c] = FLR; nr[c] = UP;
                c++; x += esiz;
            }
            // left wall (including window)
            n = HT / esiz; y = hsiz;
            for (i = 0; i < n; i++) {
                xc[c] = 0; yc[c] = y; nr[c] = RIGHT;
                pt[c] = (Y3 <= y && y < Y4) ? WND : WALL;
                c++; y += esiz;
            }
            // right wall
            y = hsiz;
            for (i = 0; i < n; i++) {
                xc[c] = WD; yc[c] = y;
                pt[c] = WALL; nr[c] = LEFT;
                c++; y += esiz;
            }
            // obstacle top
            n = (X2-X1) / esiz; x = X1 + hsiz;
            for (i = 0; i < n; i++) {
                xc[c] = x; yc[c] = Y1;
                pt[c] = OBST; nr[c] = UP;
                c++; x += esiz;
            }
            // obstacle back
            x = X1 + hsiz;
            for (i = 0; i < n; i++) {
                xc[c] = x; yc[c] = Y1;
                pt[c] = OBST; nr[c] = DOWN;
                c++; x += esiz;
            }

            // all done
            ne = c;
            return true;
        }

        // isVisible : Tells whether or not element j is visible from i.
        boolean isVisible (int i, int j) {
            if (i > j)
                return isVisible(j, i);
            if (pt[j] == OBST)  // either is obstacle
                return (yc[i] < Y1 && nr[j] == UP) || (yc[i] > Y1 && nr[j] == DOWN);
            else if (nr[i] == nr[j]) // then form factor is zero, anyway
                return false;
            else if (yc[i] == yc[j]) // walls facing each other
                return true;
            double m = (double)(xc[i] - xc[j]) / (double)(yc[i] - yc[j]);
            int x0 = (int)(m * (double)(Y1 - yc[j])) + xc[j];
            return !(X1 <= x0 && x0 < X2);
        }

        // calcFormFactor : Calculates the form factors between elements.
        boolean calcFormFactor () {
            int dx, dy, t;
            double dist;
            ff = new double[ne][ne];
            // here I use a method that is simple but strongly dependent
            // on the ocnfiguration of the room
            for (int i = 0; i < ne; i++) {
                ff[i][i] = 0.0; // here self-reflection is ignored
                for (int j = i + 1; j < ne; j++) {
                    if (!isVisible(i, j)) {
                        ff[i][j] = ff[j][i] = 0.0;
                        continue;
                    }
                    dx = Math.abs(xc[i] - xc[j]);
                    dy = Math.abs(yc[i] - yc[j]);
                    dist = Math.sqrt(dx * dx + dy * dy);
                    if ((nr[i] == UP && nr[j] == DOWN)
                        || (nr[i] == DOWN && nr[j] == UP)) {
                        t = dy * dy;
                    } else if ((nr[i] == LEFT && nr[j] == RIGHT)
                        || (nr[i] == RIGHT && nr[j] == LEFT)) {
                        t = dx * dx;
                    } else {
                        t = dx * dy;
                    }
                    ff[i][j] = ff[j][i] =
                        (double)(t * esiz) / (dist * dist * dist * 2.0);
                }
            }
            return true;
        }

        // resetIt : Resets this system according to the input of the applet.
        boolean resetIt () {
            state = INIT;
            esiz = app.esizs[app.esizchc.getSelectedIndex()];
            xl = 96;    // at present this value is fixed
            if (!(setParameters() && calcFormFactor()))
                return false;
            return true;
        }

        // update : overridden to suppress flickering
        public void update (Graphics g) {
            paint(g);
        }

        // paint
        public void paint (Graphics g) {
            drawRoomImage(g);
            if (state == DONE)
                showRadiosity(g);
        }

        // drawRoomImage : Draws the image of the room
        void drawRoomImage (Graphics g) {
            Dimension siz = getSize();
            g.clearRect(0, 0, siz.width, siz.height); // clear screen
            //
            g.setColor(new Color(0x72, 0x9f, 0xff));
            g.drawRect(XM, YM, WD-1, HT-1);      // boundary
            g.drawRect(XM-1, YM-1, WD+1, HT+1);  //
            g.fillRect(XM+X1, YM+Y1-1, X2-X1, 2);  // obstacle
            g.setColor(new Color(0x80, 0xff, 0xff));
            g.fillRect(XM-1, YM+Y3, 3, Y4-Y3);   // window
            g.setColor(new Color(0xff, 0xff, 0x80));
            g.fillRect(XM+xl-LWD/2, YM-1, LWD, 3);       // light
        }

        // setIntensity
        static void setIntensity (Graphics g, double e1) {
            int c = (int)e1;
            if (c < 0) c = 0;
            if (c > 255) c = 255;
            g.setColor(new Color(c, c, c));
        }

        // showRadiosity : Shows the calculated radiosity.
        void showRadiosity (Graphics g) {
            int c = 0, i, k, n, hsiz;
            hsiz = esiz / 2;
            // ceiling
            n = WD / esiz;
            for (i = 0; i < n; i++) {
                setIntensity(g, e[c]);
                g.fillRect(XM+xc[c++]-hsiz, YM-2-BWD, esiz, BWD);
            }
            for (i = 0; i < n; i++) { // floor
                setIntensity(g, e[c]);
                g.fillRect(XM+xc[c++]-hsiz, YM+HT+2, esiz, BWD);
            }
            n = HT / esiz;
            for (i = 0; i < n; i++) { // left wall
                setIntensity(g, e[c]);
                g.fillRect(XM-2-BWD, YM+yc[c++]-hsiz, BWD, esiz);
            }
            for (i = 0; i < n; i++) { // right wall
                setIntensity(g, e[c]);
                g.fillRect(XM+WD+2, YM+yc[c++]-hsiz, BWD, esiz);
            }
            n = (X2-X1) / esiz;
            for (i = 0; i < n; i++) { // obstacle top
                setIntensity(g, e[c]);
                g.fillRect(XM+xc[c++]-hsiz, YM+Y1-2-BWD, esiz, BWD);
            }
            for (i = 0; i < n; i++) { // obstacle back
                setIntensity(g, e[c]);
                g.fillRect(XM+xc[c++]-hsiz, YM+Y1+2, esiz, BWD);
            }
        }

    }

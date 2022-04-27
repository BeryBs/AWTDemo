
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class AWTDemo extends Frame implements ActionListener, MouseListener  {
    int x = 100;
    int y = 100;
    boolean clicked=false; //clicked flag is false initially since there is no click


    //Two types of constructors selected by the integer passed
    //First one is for Lab3A second one is for Lab 3B
    public AWTDemo(int a) {
        if (a == 1) { //if user inputs 1
            setTitle("Lab 3A"); //title is Lab3A
            addWindowListener(new MyFinishWindow()); //windowlistener



        } else if (a == 2) { //if user inputs 2
            setTitle("Lab 3B"); //title is Lab3B
            MenuBar menu_bar = new MenuBar(); //MenuBar will be displayed

            Menu exit = new Menu("File"); //Label of the menu
            exit.add(new MenuItem("Exit")); //Option of the menu
            exit.addActionListener(this);
            menu_bar.add(exit);
            setMenuBar(menu_bar);
            addWindowListener(new MyFinishWindow()); //windowlistener
            addMouseListener(this);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { //Check if the mouse is clicked

        if(e.getButton()!=e.NOBUTTON) { //if any buttons clicked,
            clicked =  true; //set the flag true
            x = e.getX(); //print x and y values
            y = e.getY();
            System.out.println(x);
            System.out.println(y);

        }
        repaint();

    }

    //Overriding methods coming from MouseListener
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public class MyFinishWindow extends WindowAdapter //Window Event to exit the window
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

    public void paint(Graphics g) { //paint function to draw circles

        Graphics2D g2d = (Graphics2D) g;

        int r = 100; //radius of the circle
        if(clicked){ //if user clicks draw the circle right there(where the mouse is located)
            drawCircle(g2d, x, y, 2*r); //Draw the big circle
            x=x-2*r;
            y=y-2*r;
            r=50; //small circle radius
            drawCircle(g2d, x, y, r); //Draw the small circle
        }else {
            //if user inputs 1, big circle will be displayed on centre of the frame and small circle  will be display near above
            x = this.getWidth() / 2;
            y = this.getHeight() / 2;
            drawCircle(g2d, x, y, 2 * r); //Draw the big circle
            x = x - 2 * r;
            y = y - 2 * r;
            r = 50;//small circle radius
            drawCircle(g2d, x, y, r);//Draw the small circle

        }

    }

    public void actionPerformed(ActionEvent arg0) { //Action for executing the "Exit" operation
        // TODO Auto-generated method stub
        String str = arg0.getActionCommand();
        System.out.println(str);
        if(str.equals("Exit")) {
            System.exit(0);
        }

    }
    private void drawCircle(Graphics2D g2d, int x, int y, int r) { // draw circle with given x,y,r values using graphics g2d
        g2d.drawOval(x - r, y - r, 2*r, 2*r);
    }
    public static void main(String[] args) {
        int a;

        System.out.println("PLEASE ENTER 1 OR 2 :"); //user receives message
        Scanner sc = new Scanner(System.in); //user inputs 1 or 2 with scanner
        a = sc.nextInt();
        sc.close();// closing the scanner
        AWTDemo f = new AWTDemo(a); //instance of the object
        f.setSize(500, 500); //setting the frame size
        f.setVisible(true); //Turn on for visibility of frame.

    }
}
package task1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class class_main {
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(config.class);
        Rect rect = (Rect) context.getBean("Rect");
        System.out.println("Coordinates of the Point p1 are :" + rect.getP1().getX() + ", " + rect.getP1().getY());
        System.out.println("Coordinates of the Point p2 are :" + rect.getP2().getX() + ", " + rect.getP2().getY());
        System.out.println("Coordinates of the Point p3 are :" + rect.getP3().getX() + ", " + rect.getP3().getY());
        System.out.println("Coordinates of the Point p4 are :" + rect.getP4().getX() + ", " + rect.getP4().getY());

        List<String> colors = rect.getcolors();
        System.out.println("List of quadilaterals : ");
        for (int i = 0; i<colors.size(); i++) {
                System.out.println(colors.get(i) + " ");
        }

        System.out.println("Height of the rectangle is :" + rect.getHeight());
        System.out.println("Width of the rectangle is :" + rect.getWidth());


    }
}

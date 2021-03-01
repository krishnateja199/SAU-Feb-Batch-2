package task2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import task2.employee;

public class class_main1 {
    public static void main(String[] args)throws Exception {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(config.class);
        employee e = context.getBean(employee.class);
        e.getName();
        int roll = e.getRoll();
        e.getCourse("CSE");

    }
}



package task2;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class employee {


        String name = "KrishnaTeja";
        int roll = 97;


    public void getName() {
            System.out.println("Hello this is KrishnaTeja");
        }

        public int getRoll()
        {
            return roll;
        }

        public void getCourse(String course)throws  Exception {

            System.out.println("Course = " + course);
            throw new RuntimeException();

        }


    }

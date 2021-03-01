package task1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class config {
    @Bean(name="Rect")
    public Rect createReactangleobject() {
        List<String> colors = new ArrayList<>();
        colors.add("pink");
        colors.add("red");
        colors.add("violet");
        return new Rect(getpointP1(),getpointP2(),getpointP3(),getpointP4(),colors);
    }

    @Bean(name="point 1")
    public point getpointP1() {
        return new point(10,20);
    }

    @Bean(name="point 2")
    public point getpointP2() {
        return new point(20,10);
    }

    @Bean(name="point 3")
    public point getpointP3() {
        return new point(20,10);
    }

    @Bean(name="point 4")
    public point getpointP4() {
        return new point(10,10);
    }

}

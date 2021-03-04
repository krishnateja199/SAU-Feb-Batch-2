package task3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class audience {
    @Id
    private int age;
    private String name;

    // This is on the basis of one to many relationship in the screen's class.
    // this time we don't get a third table while creating the mapping, cause the mapping
    // is done by audience class. More precisely, it is done by the screen object inside audience class.
    // So for many to one relation. Many audience belong to one screen. therefore there can be a sepatate column of


    @ManyToOne
    private screen screen1;


    public screen getScreen1()
    {
       return screen1;
    }
    public void setScreen1(screen screen1)
    {
         this.screen1=screen1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
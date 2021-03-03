package task3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class screen {
    // Many to one: One screen can have many audience

    @Id
    private int screenno;
    private String name;
    private int showtime;

    @OneToMany(mappedBy = "screen1")
    private List<audience> audiences = new ArrayList<>();


    public List<audience> getAudience() {
        return audiences;
    }

    public void setaudience(List<audience> audiences) {
        this.audiences = audiences;
    }


    public int getScreenno() {
        return screenno;
    }

    public void setScreenno(int screenno) {
        this.screenno = screenno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShowtime() {
        return showtime;
    }

    public void setShowtime(int showtime) {
        this.showtime = showtime;
    }
}

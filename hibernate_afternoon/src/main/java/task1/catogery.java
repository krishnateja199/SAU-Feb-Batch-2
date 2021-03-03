package task1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
//import java.util.function.Supplier;

@Entity
public class catogery {
    @Id
    private int catId;
    private String catName;

    @ManyToOne
    private product prodObj;

    @ManyToMany(mappedBy = "catm2m")
    private List<supplier> supplist = new ArrayList<>();


    public int getCatId() {
        return catId;
    }

    public List<supplier> getSupplist() {
        return supplist;
    }

    public void setSupplist(List<supplier> supplist) {
        this.supplist = supplist;
    }

    public product getProdObj() {
        return prodObj;
    }

    public void setProdObj(product prodObj) {
        this.prodObj = prodObj;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

}

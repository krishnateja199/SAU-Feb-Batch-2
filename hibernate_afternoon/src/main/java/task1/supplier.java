package task1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class supplier {
    @Id
    private int supplierId;
    private String supplierName;

    @ManyToMany
    private List<catogery> catm2m = new ArrayList<>();



    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }



    public List<catogery> getCatm2m() {
        return catm2m;
    }

    public void setCatm2m(List<catogery> catm2m) {
        this.catm2m = catm2m;
    }


}


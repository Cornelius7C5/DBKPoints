package pl.spot.dbk.points.server.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICES")
public class Invoice {
    @Override
    public String toString() {
        return "Invoice [id_i=" + id_i + ", invoiceSalePoint=" + invoiceSalePoint + ", user=" + user + "]";
    }

    @Id
    @GeneratedValue
    @Column(name = "id_i")
    private int id_i;

    @ManyToOne
    @JoinColumn(name = "id_i_salepoint", referencedColumnName = "id_sp")
    private SalePoint invoiceSalePoint;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_u")
    private User user;

    public Invoice() {
        // TODO Auto-generated constructor stub
    }

    public int getId_i() {
        return id_i;
    }

    public void setId_i(int id_i) {
        this.id_i = id_i;
    }

    public SalePoint getSalePoint() {
        return invoiceSalePoint;
    }

    public void setSalePoint(SalePoint salePoint) {
        this.invoiceSalePoint = salePoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

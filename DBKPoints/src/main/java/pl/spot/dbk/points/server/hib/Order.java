package pl.spot.dbk.points.server.hib;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id_o")
    private int id_o;

    @Column(name = "date")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_u")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_o_salepoint", referencedColumnName = "id_sp")
    private SalePoint salePoint;

    @ManyToOne
    @JoinColumn(name = "id_status", referencedColumnName = "id_s")
    private Status status;

    @OneToMany(mappedBy = "id_order")
    private Set<Basket> basketItems;

    public Order() {}

    public int getId_o() {
        return id_o;
    }

    public void setId_o(int id_o) {
        this.id_o = id_o;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SalePoint getSalePoint() {
        return salePoint;
    }

    public void setSalePoint(SalePoint salePoint) {
        this.salePoint = salePoint;
    }

    public Set<Basket> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(Set<Basket> basketItems) {
        this.basketItems = basketItems;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order [id_o=" + id_o + ", date=" + date + ", user=" + user + "]";
    }

    public void setBasketItems(ArrayList<Basket> basket) {
        // TODO Auto-generated method stub
        
    }

}

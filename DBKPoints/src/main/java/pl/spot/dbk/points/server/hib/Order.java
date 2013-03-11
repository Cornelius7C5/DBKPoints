package pl.spot.dbk.points.server.hib;

import java.sql.Date;
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
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_u")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_o_salepoint", referencedColumnName = "id_sp")
    private SalePoint salePoint;

    @OneToMany(mappedBy = "id_order")
    private Set<Basket> basketItems;

    public Order() {}

    public int getId_o() {
        return id_o;
    }

    public void setId_o(int id_o) {
        this.id_o = id_o;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

}

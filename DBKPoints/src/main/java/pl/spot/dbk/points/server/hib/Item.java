package pl.spot.dbk.points.server.hib;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "id_i")
    private int id_i;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private int cost;

    @OneToMany(mappedBy = "id_item")
    private Set<Basket> basketsWithThisItem;

    public Item() {}

    public int getId_i() {
        return id_i;
    }

    public void setId_i(int id_i) {
        this.id_i = id_i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Set<Basket> getBasketsWithThisItem() {
        return basketsWithThisItem;
    }

    public void setBasketsWithThisItem(Set<Basket> basketsWithThisItem) {
        this.basketsWithThisItem = basketsWithThisItem;
    }

}

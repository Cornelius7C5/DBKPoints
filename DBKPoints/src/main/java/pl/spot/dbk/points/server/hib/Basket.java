package pl.spot.dbk.points.server.hib;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BASKETS")
@IdClass(BasketId.class)
public class Basket {

    @ManyToOne
    @Id
    @JoinColumn(name = "id_order", referencedColumnName = "id_o")
    private Order id_order;

    @ManyToOne
    @Id
    @JoinColumn(name = "id_item", referencedColumnName = "id_i")
    private Item id_item;

    private int amount;

    public Basket() {}

    public Order getId_order() {
        return id_order;
    }

    public void setId_order(Order id_order) {
        this.id_order = id_order;
    }

    public Item getId_item() {
        return id_item;
    }

    public void setId_item(Item id_item) {
        this.id_item = id_item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Basket [id_order=" + id_order + ", id_item=" + id_item + ", amount=" + amount + "]";
    }

}

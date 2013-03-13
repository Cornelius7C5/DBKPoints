package pl.spot.dbk.points.server.hib;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BasketId implements Serializable {

    private static final long serialVersionUID = 8127524047581257352L;
    private int id_order;
    private int id_item;

    public BasketId() {}

    public BasketId(int id_order, int id_item) {
        this.id_item = id_item;
        this.id_order = id_order;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_item;
        result = prime * result + id_order;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BasketId other = (BasketId) obj;
        if (id_item != other.id_item)
            return false;
        if (id_order != other.id_order)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BasketId [id_order=" + id_order + ", id_item=" + id_item + "]";
    }

}

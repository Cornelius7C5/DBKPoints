package pl.spot.dbk.points.server.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "id_i_salepoint", referencedColumnName = "id_sp")
    private SalePoint invoiceSalePoint;
    @Transient
    private int invoiceSalePoint_id;
    
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_u")
    private User user;
    @Transient
    private int user_id;

    public Invoice() {
        // TODO Auto-generated constructor stub
    }

    public int getId_i() {
        return id_i;
    }

    public void setId_i(int id_i) {
        this.id_i = id_i;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public SalePoint getSalePoint() {
        return invoiceSalePoint;
    }

    public void setSalePoint(SalePoint salePoint) {
        this.invoiceSalePoint = salePoint;
    }

    /**
     * @return the invoiceSalePoint_id
     */
    public int getInvoiceSalePoint_id() {
        return invoiceSalePoint_id;
    }

    /**
     * @param invoiceSalePoint_id the invoiceSalePoint_id to set
     */
    public void setInvoiceSalePoint_id(int invoiceSalePoint_id) {
        this.invoiceSalePoint_id = invoiceSalePoint_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /** @return the user_id */
    public int getUser_id() {
        return user_id;
    }

    /** @param user_id the user_id to set */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}

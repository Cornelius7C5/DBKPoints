package pl.spot.dbk.points.server.hib;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_u;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "last_login")
    private Timestamp last_login;
    @Column(name = "last_points")
    private Timestamp last_points;
    @Column(name = "last_order_realization")
    private Timestamp last_order_realization;
    @Column(name = "blocked_points")
    private int blocked_points;

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_r")
    Role role;
    @Transient
    private String role_id;

    @ManyToOne
    @JoinColumn(name = "id_register_point", referencedColumnName = "id_sp")
    SalePoint registerPoint;

    @Transient
    private int registerPoint_id;

    @ManyToOne
    @JoinColumn(name = "id_work_sp", referencedColumnName = "id_sp")
    SalePoint workSalePoint;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<Invoice> invoices;

    public User() {}

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getLast_login() {
        return last_login;
    }

    public void setLast_login(Timestamp last_login) {
        this.last_login = last_login;
    }

    public Timestamp getLast_points() {
        return last_points;
    }

    public void setLast_points(Timestamp last_points) {
        this.last_points = last_points;
    }

    public Timestamp getLast_order_realization() {
        return last_order_realization;
    }

    public void setLast_order_realization(Timestamp last_order_realization) {
        this.last_order_realization = last_order_realization;
    }

    public int getBlocked_points() {
        return blocked_points;
    }

    public void setBlocked_points(int blocked_points) {
        this.blocked_points = blocked_points;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public SalePoint getRegisterPoint() {
        return registerPoint;
    }

    public void setRegisterPoint(SalePoint registerPoint) {
        this.registerPoint = registerPoint;
    }

    public SalePoint getWorkSalePoint() {
        return workSalePoint;
    }

    public void setWorkSalePoint(SalePoint workSalePoint) {
        this.workSalePoint = workSalePoint;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public int getRegisterPoint_id() {
        return registerPoint_id;
    }

    public void setRegisterPoint_id(int registerPoint_id) {
        this.registerPoint_id = registerPoint_id;
    }

    public boolean isAdmin() {
        return getRole().getId_r() == 111;
    }

    @Override
    public String toString() {
        return "User [id_u=" + id_u + ", password=" + password + ", name=" + name + ", surname=" + surname + ", role="
                + role + "]";
    }

}

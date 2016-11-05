package org.example.domain.admin;

import javax.persistence.*;

/**
 * Created by Deniss Makarenkov on 05/11/2016.
 * Visit http://www.makdeniss.eu/
 */
@Entity
@Table(name = "customer", schema = "public", catalog = "postgres")
public class CustomerEntity {
    private int id;
    private String name;
    private int balance;
    private String bankId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "balance")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "bank_id")
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (id != that.id) return false;
        if (balance != that.balance) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + balance;
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        return result;
    }
}

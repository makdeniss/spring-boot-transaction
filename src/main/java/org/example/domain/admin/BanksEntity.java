package org.example.domain.admin;

import javax.persistence.*;

/**
 * Created by Deniss Makarenkov on 05/11/2016.
 * Visit http://www.makdeniss.eu/
 */
@Entity
@Table(name = "banks", schema = "public", catalog = "postgres")
public class BanksEntity {
    private String bankId;
    private String bankName;

    @Id
    @Column(name = "bank_id")
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Basic
    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BanksEntity that = (BanksEntity) o;

        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bankId != null ? bankId.hashCode() : 0;
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        return result;
    }
}

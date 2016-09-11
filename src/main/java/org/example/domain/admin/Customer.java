package org.example.domain.admin;

import org.example.domain.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity
{
  @Column(name = "name")
  private String name;

  @Column(name = "balance")
  private int balance;

  public String getName()
  {
    return name;
  }

  public void setName(final String name)
  {
    this.name = name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}

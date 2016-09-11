package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity
{
  @Generated(GenerationTime.ALWAYS)
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private Long id;

  public Long getID()
  {
    return id;
  }
}

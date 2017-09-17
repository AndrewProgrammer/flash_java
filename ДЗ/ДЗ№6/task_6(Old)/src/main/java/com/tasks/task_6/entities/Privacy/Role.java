package com.tasks.task_6.entities.Privacy;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

  @Column(name = "name")
  private String name;

  // the attribute mappedBy indicates that the entity in this side is the inverse of the relationship,
  // and the owner resides in the "other" entity.
  // This also means that you can access the other table from the class
  // which you've annotated with "mappedBy" (fully bidirectional relationship).
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
  private Set<User> users;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private double role_id;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getRole_id() {
    return role_id;
  }

  public void setRole_id(double role_id) {
    this.role_id = role_id;
  }
}

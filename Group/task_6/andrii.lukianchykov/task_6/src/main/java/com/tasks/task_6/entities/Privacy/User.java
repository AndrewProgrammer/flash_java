package com.tasks.task_6.entities.Privacy;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {


  @Column(name = "login")
  private String login;

  @Column(name = "password")
  private String password;

  //cascade = CascadeType.ALL - destructor of tables(when something wrong)
  //LAZY = fetch when needed
  //EAGER = fetch immediately
  @ManyToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
  //Create new Table
  @JoinTable(
      //fields in this Table
      name = "user_roles",
      joinColumns = {@JoinColumn(name = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id")})
  private Set<Role> roles;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private double user_id;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public double getUser_id() {
    return user_id;
  }

  public void setUser_id(double user_id) {
    this.user_id = user_id;
  }
}

package edu.my.wallet.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

/**
 * User entity.
 */
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String email;

  @JsonIgnore
  @Column(nullable = false)
  private String password;

  @Nullable
  @Column(nullable = true)
  private String imageUrl;

  public User() {}

  public User(String username, String email, String password, @Nullable String imageUrl) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.imageUrl = imageUrl;
  }

  public User(String username, String email, @Nullable String imageUrl) {
    this.username = username;
    this.email = email;
    this.imageUrl = imageUrl;
  }

  public Long getId() {return id;}

  public void setId(Long id) {this.id = id;}

  public String getUsername() {return username;}

  public void setUsername(String username) {this.username = username;}

  public String getEmail() {return email;}

  public void setEmail(String email) {this.email = email;}

  @JsonIgnore
  public String getPassword() {return password;}

  public void setPassword(String password) {this.password = password;}

  @Nullable
  public String getImageUrl() {return imageUrl;}

  public void setImageUrl(@Nullable String imageUrl) {this.imageUrl = imageUrl;}
}

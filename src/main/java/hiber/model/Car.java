package hiber.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "series")
  private Integer series;

  @Column(name = "model")
  private String model;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "car")
  private User user;

  public Car() { }

  public Car(Integer series, String model) {
    this.series = series;
    this.model = model;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getSeries() {
    return series;
  }

  public void setSeries(Integer series) {
    this.series = series;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return String.format("Id: %d | Series: %d | Model: %s", this.id, this.series, this.model);
  }
}

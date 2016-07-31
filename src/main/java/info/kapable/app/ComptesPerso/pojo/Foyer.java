package info.kapable.app.ComptesPerso.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// imports
@Entity
@Table(name = "FOYER")
public class Foyer {
  private Long id;  
  private String name;  

  /**
   * Getter and Setter
   */
  @Id  
  @GeneratedValue(strategy=GenerationType.AUTO)  
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }

  @Column(name="NOM_FOYER")
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
}

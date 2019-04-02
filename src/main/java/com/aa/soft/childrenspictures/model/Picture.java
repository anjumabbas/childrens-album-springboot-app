package com.aa.soft.childrenspictures.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Anjum Abbas
 * @version 1.0
 */

@Entity
@Table(name = "PICTURE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"LAST_UPDATED"}, allowGetters = true)
public class Picture implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pk;

  @Column(name = "LAST_UPDATED", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date lastUpdated;

  @Column(name = "FILENAME", nullable = false)
  @NotBlank
  private String filename;

  @Column(name = "GEO_COORDINATES", nullable = true)
  private String geoCoordinates;

  @Column(name = "CHILD_AGE", nullable = true)
  private int childAge;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CHILD_FK")
  private Child mChild;

  public Long getPk()
  {
    return pk;
  }

  public void setPk(Long aPk)
  {
    pk = aPk;
  }

  public Date getLastUpdated()
  {
    return lastUpdated;
  }

  public void setLastUpdated(Date aLastUpdated)
  {
    lastUpdated = aLastUpdated;
  }

  public String getFilename()
  {
    return filename;
  }

  public void setFilename(String aFilename)
  {
    filename = aFilename;
  }

  public String getGeoCoordinates()
  {
    return geoCoordinates;
  }

  public void setGeoCoordinates(String aGeoCoordinates)
  {
    geoCoordinates = aGeoCoordinates;
  }

  public Child getChild()
  {
    return mChild;
  }

  public void setChild(Child aChild)
  {
    mChild = aChild;
  }

  public int getChildAge()
  {
    return childAge;
  }

  public void setChildAge(int aChildAge)
  {
    childAge = aChildAge;
  }
}


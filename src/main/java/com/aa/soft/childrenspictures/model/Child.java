package com.aa.soft.childrenspictures.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "CHILD")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"LAST_UPDATED"}, allowGetters = true)
public class Child implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pk;

  @Column(name="LAST_UPDATED", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date lastUpdated;

  @Column(name="NAME", nullable = false)
  @NotBlank
  private String name;

  @Column(name="DOB", nullable = false)
  @NotBlank
  private Date dob;

  @Column(name = "GENDER", length = 7, nullable = false)
  @Enumerated(EnumType.STRING)
  @NotBlank
  private GenderType gender;

  @OneToMany(mappedBy = "mChild", fetch = FetchType.LAZY)
  private List<Picture> mPictureList;

  public enum GenderType{
    MALE,
    FEMALE;
  }

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

  public String getName()
  {
    return name;
  }

  public void setName(String aName)
  {
    name = aName;
  }

  public Date getDob()
  {
    return dob;
  }

  public void setDob(Date aDob)
  {
    dob = aDob;
  }

  public GenderType getGender()
  {
    return gender;
  }

  public void setGender(GenderType aGender)
  {
    gender = aGender;
  }

  public List<Picture> getPictureList()
  {
    return mPictureList;
  }

  public void setPictureList(List<Picture> aPictureList)
  {
    mPictureList = aPictureList;
  }
}


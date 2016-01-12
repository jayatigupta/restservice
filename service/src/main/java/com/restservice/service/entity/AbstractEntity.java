package com.restservice.service.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
  private static final long serialVersionUID = 4643201185226691972L;

  @Id
  @Column(name = "id", nullable = false, length = 40, updatable = false)
  private String id;

  @Column(name = "name", nullable = false, length = 100, updatable = false)
  private String name;

  @Basic(optional = false)
//  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "createdTS", nullable = false, insertable = true, updatable = false)
  private long createdAt;

  @Basic(optional = false)
//  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modifiedTS", insertable = true, updatable = true)
  private long modifiedAt = System.currentTimeMillis();

  @Version
  private long version;

  public AbstractEntity() {
    this.createdAt = System.currentTimeMillis();
    this.modifiedAt = System.currentTimeMillis();
  }

  public AbstractEntity(String id) {
    this.id = id;
    this.createdAt = System.currentTimeMillis();
    this.modifiedAt = System.currentTimeMillis();
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id
   *          the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the createdAt
   */
  public long getCreatedAt() {
    return createdAt;
  }

  /**
   * @param createdAt
   *          the createdAt to set
   */
  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return the modifiedAt
   */
  public long getModifiedAt() {
    return modifiedAt;
  }

  /**
   * @param modifiedAt
   *          the modifiedAt to set
   */
  public void setModifiedAt(long modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }
}

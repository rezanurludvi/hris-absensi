package com.hris.absen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("unchecked")
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 7410601415199899504L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "deleted_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedTime;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "deleted_by")
    private String deletedBy;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;/*false belum kedeleted ,true sudah terhapus*/

    @PrePersist
    protected void onCreate(){
        setCreatedTime(new Date());
    }

    @PreUpdate
    protected void onUpdate(){
        setUpdatedTime(new Date());
    }

    @PreRemove
    protected void onDelete(){
        setDeletedTime(new Date());
    }

}

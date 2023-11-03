package com.medAmine.gestion.de.stock.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;



@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstracetEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    @Column(name="creationDate")
    private Instant creationDate;
    @LastModifiedDate
    @Column(name="LastUpdateDate")
    private Instant lastUpdateDate;
}

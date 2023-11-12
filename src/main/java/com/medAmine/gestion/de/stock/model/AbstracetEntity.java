package com.medAmine.gestion.de.stock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

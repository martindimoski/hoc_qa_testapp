package io.intertec.qa.performance.testapp.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;

    private String text;

    @ManyToOne
    private User user;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;
}

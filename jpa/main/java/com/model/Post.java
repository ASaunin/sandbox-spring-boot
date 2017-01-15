package com.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@Getter @Setter
@EqualsAndHashCode(exclude = {"id"})
@ToString(of = {"title"})
public class Post {

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private Person author;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Formula(value = "substr(body, 1, 500)")
    private String description;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;

}

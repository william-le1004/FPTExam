package com.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Will
 * @project NewsProject
 * @date 7/29/2023
 */
@AllArgsConstructor
@Getter
@ToString
@Setter
@Data
@NoArgsConstructor
@Entity
public class News implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;
    private String author;
    private Timestamp date_created;
    private int view;

    public News(String title, String content, String author, Timestamp date_created, int view) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date_created = date_created;
        this.view = view;
    }

    public News(String s, String s1, String minh_anh, Timestamp timestamp2) {
    }
}

package com.example.healthSquare.health_square.model;


import javax.persistence.*;

/*created by Hector Developers
06-08-2019
*/

@Entity
@Table(name = "category")
public class Category extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryname;

    public Category(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}

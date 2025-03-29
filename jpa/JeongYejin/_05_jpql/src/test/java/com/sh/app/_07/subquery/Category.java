package com.sh.app._07.subquery;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "Category07")
@Table(name = "tbl_category")
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_code")
    private Long categoryCode;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "ref_category_code")
    private Long refCategoryCode;

    public void changeCategoryName(String newCategoryName) {
        this.categoryName = newCategoryName;
    }
}

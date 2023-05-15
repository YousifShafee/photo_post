package com.photo_service.photo_post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import com.photo_service.photo_post.constants.PhotoPostConstants;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Photo extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int photoId;
    
    @NotBlank(message="Name must not be blank")
    private String name;
    
    @Lob
    @Column(name = "photo")
    private byte[] photo;

    private String description;
    
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST, targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId",nullable = false)
    private Category category;
    
    private String status = PhotoPostConstants.PENDING_STATUS;

}

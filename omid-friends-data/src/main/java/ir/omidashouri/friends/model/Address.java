package ir.omidashouri.friends.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tbl_Address")
public class Address extends BaseEntity{


    @Builder
    public Address(Long id, String street, String city) {
        super(id);
        this.street = street;
        this.city = city;
    }

    private String street;

    private String city;

    /*@JsonBackReference
    @ManyToOne()
    Friend friend;*/
}

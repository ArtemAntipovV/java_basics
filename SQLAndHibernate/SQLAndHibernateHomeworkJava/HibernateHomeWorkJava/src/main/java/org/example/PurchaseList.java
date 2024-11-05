package org.example;

import lombok.*;
import org.example.Key.PurchaseListKey;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor

@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey key;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}

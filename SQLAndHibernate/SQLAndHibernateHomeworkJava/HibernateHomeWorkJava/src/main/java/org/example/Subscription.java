package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Key.SubscriptionsKey;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionsKey subscriptionsKey;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "subscription_date")
    private Date subscriptionDate;
}


package com.shop.ecommercev2.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Date paymentDate;

    @OneToOne(mappedBy = "payment")
    private Command command;
}

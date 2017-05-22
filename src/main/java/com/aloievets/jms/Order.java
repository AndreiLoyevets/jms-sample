package com.aloievets.jms;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Andrew on 22.05.2017.
 */
@Data
@Builder
public class Order implements Serializable {

    private String orderId;
    private String productName;
    private int quantity;
}
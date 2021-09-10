package com.example.inventoryManagementRestService.entity;

import com.sun.istack.NotNull;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_recived")
public class Order_Received {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;
    @NotNull
    private Date customer_placed_date;
    private Date receivedDate;
    private String customerFname;
    private String customerLname;
    @NotNull
    private String customerAddress;
    @NotNull
    private Date deliveryDate;
    @NotNull
    private Integer contactNo;
    private Integer amount;
    private Integer noOfIteam;
    //for collection element or Object datatype

    /*Used by Hibernate*/
    public Order_Received() {
    }

    public Order_Received(Integer order_id, Date customer_placed_date, Date receivedDate, String customerFname,
                          String customerLname, String customerAddress, Date deliveryDate, Integer contactNo,
                          Integer amount, Integer noOfIteam, List<String> iteamList) {
        this.order_id = order_id;
        this.customer_placed_date = customer_placed_date;
        this.receivedDate = receivedDate;
        this.customerFname = customerFname;
        this.customerLname = customerLname;
        this.customerAddress = customerAddress;
        this.deliveryDate = deliveryDate;
        this.contactNo = contactNo;
        this.amount = amount;
        this.noOfIteam = noOfIteam;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getCustomer_placed_date() {
        return customer_placed_date;
    }

    public void setCustomer_placed_date(Date customer_placed_date) {
        this.customer_placed_date = customer_placed_date;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public void setCustomerFname(String customerFname) {
        this.customerFname = customerFname;
    }

    public String getCustomerLname() {
        return customerLname;
    }

    public void setCustomerLname(String customerLname) {
        this.customerLname = customerLname;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getContactNo() {
        return contactNo;
    }

    public void setContactNo(Integer contactNo) {
        this.contactNo = contactNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getNoOfIteam() {
        return noOfIteam;
    }

    public void setNoOfIteam(Integer noOfIteam) {
        this.noOfIteam = noOfIteam;
    }

    @Override
    public String toString() {
        return "Order_Received{" +
                "order_id=" + order_id +
                ", customer_placed_date=" + customer_placed_date +
                ", receivedDate=" + receivedDate +
                ", customerFname='" + customerFname + '\'' +
                ", customerLname='" + customerLname + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", contactNo=" + contactNo +
                ", amount=" + amount +
                ", noOfIteam=" + noOfIteam +
                '}';
    }
}

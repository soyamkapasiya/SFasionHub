package com.kapasiya.SFasionHub.controller;

import com.kapasiya.SFasionHub.datatransferobject.PurchaseDTO;
import com.kapasiya.SFasionHub.entity.Purchase;
import com.kapasiya.SFasionHub.serviceimpl.PurchaseServiceImpl;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PaymentController
{
    @Autowired
    PurchaseServiceImpl purchaseService;

    @PostMapping("/booking")
    @ResponseBody
    public String finalBooking(@RequestBody Map<String,Object> data) throws RazorpayException
    {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();

        String accountEmail = user.getUsername();
//        System.out.println("accountEmail"+accountEmail);

        PurchaseDTO purchaseDTO = new PurchaseDTO();

        purchaseDTO.setFirstName((String) data.get("firstName"));
        //System.out.println("First Name:- "+data.get("firstName"));

        purchaseDTO.setLastName((String) data.get("lastName"));
//        System.out.println("Last Name:- "+data.get("lastName"));

        purchaseDTO.setAmount(Double.parseDouble((String) data.get("amount")));
//        System.out.println("amount :- "+Double.parseDouble((String) data.get("amount")));

        purchaseDTO.setAddress1((String) data.get("add1"));
//        System.out.println("add1:- "+ data.get("add1"));

        purchaseDTO.setAddress2((String) data.get("add2"));
//        System.out.println("add2:- "+ data.get("add2"));

        purchaseDTO.setZipCode((String) data.get("zip"));
//        System.out.println("zip:- "+ data.get("zip"));

        purchaseDTO.setPhone((String) data.get("phone"));
//        System.out.println("phone:- "+data.get("phone"));

        purchaseDTO.setFormEmail((String) data.get("email"));
//        System.out.println("Email:- "+ data.get("email"));

        purchaseDTO.setAdditional((String) data.get("additional"));
//        System.out.println("Additional:- "+ data.get("additional"));



        Purchase b = purchaseService.updatePurchase(purchaseDTO,user);

        // Payment API Integration..........

        var client = new RazorpayClient("rzp_test_CAOmLVEJtoNizm","hChC99xBGSoEnQQRMj07GGOR");

        JSONObject object = new JSONObject();

        object.put("amount",purchaseDTO.getAmount() *100);
        object.put("currency","INR");
        object.put("receipt","txn_75563");

        Order order = client.orders.create(object);

        System.out.println(order);


//        model.addAttribute("record", new BookingsDTO());
        return order.toString();
    }
}

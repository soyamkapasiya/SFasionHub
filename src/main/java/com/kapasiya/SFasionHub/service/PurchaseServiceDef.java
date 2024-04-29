package com.kapasiya.SFasionHub.service;

import com.kapasiya.SFasionHub.datatransferobject.PurchaseDTO;
import com.kapasiya.SFasionHub.entity.Purchase;
import org.springframework.security.core.userdetails.UserDetails;

public interface PurchaseServiceDef
{
    Purchase updatePurchase(PurchaseDTO bookingDTO, UserDetails user);
}

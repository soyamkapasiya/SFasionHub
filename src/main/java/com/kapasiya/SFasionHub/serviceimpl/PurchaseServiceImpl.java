package com.kapasiya.SFasionHub.serviceimpl;

import com.kapasiya.SFasionHub.datatransferobject.PurchaseDTO;
import com.kapasiya.SFasionHub.entity.Purchase;
import com.kapasiya.SFasionHub.entity.User;
import com.kapasiya.SFasionHub.repository.PurchaseRepository;
import com.kapasiya.SFasionHub.repository.UserRepository;
import com.kapasiya.SFasionHub.service.PurchaseServiceDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseServiceDef
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PurchaseRepository  repository;

    @Override
    public Purchase updatePurchase(PurchaseDTO bookingDTO, UserDetails user)
    {
        Purchase booking = new Purchase();
        String email = user.getUsername();

        User users = userRepository.findByEmail(email);

        booking.setFirstName(bookingDTO.getFirstName());
    //    System.out.println(bookingDTO.getFirstName());

        booking.setLastName(bookingDTO.getLastName());

        booking.setAddress1(bookingDTO.getAddress1());

        booking.setAddress2(bookingDTO.getAddress2());

        booking.setZipCode(bookingDTO.getZipCode());

        booking.setFormEmail(bookingDTO.getFormEmail());

        booking.setAdditional(bookingDTO.getAdditional());

        booking.setAmount(bookingDTO.getAmount());

        booking.setPhone(bookingDTO.getPhone());

        booking.setAccountEmail(users.getEmail());

        String date = java.time.LocalDate.now().toString();
        booking.setDate(date);

        String time = java.time.LocalTime.now().toString();
        booking.setTime(time);

        return repository.save(booking);
    }
}

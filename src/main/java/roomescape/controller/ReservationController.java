package roomescape.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import roomescape.dto.Reservation;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationController {

    private List<Reservation> reservations = new ArrayList<>();

    @GetMapping("/reservation")
    public String reservation(){
        return "/reservation.html";
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> reservations(){

        Reservation reservation1=new Reservation(1L,"브라운","2023-01-01","10:00");
        reservations.add(reservation1);

        return ResponseEntity.ok(reservations);

    }
}

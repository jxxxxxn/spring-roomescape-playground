package roomescape.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import roomescape.dto.Reservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ReservationController {

    Reservation reservation1=new Reservation(1L,"브라운","2023-01-01","10:00");
    Reservation reservation2=new Reservation(2L,"브라운","2023-01-02","11:00");
    private List<Reservation> reservations = new ArrayList<>(Arrays.asList(reservation1,reservation2));

    @GetMapping("/reservation")
    public String reservation(Model model){

        model.addAttribute(reservations);
        return "reservation";
    }

    @GetMapping("/reservations")
    @ResponseBody
    public List<Reservation> reservations(){

        return reservations;
    }
}

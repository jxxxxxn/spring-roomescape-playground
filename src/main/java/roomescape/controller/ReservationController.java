package roomescape.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import roomescape.dto.ReservationAddReq;
import roomescape.dto.ReservationReq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ReservationController {

    //AtomicLong: Long 자료형 가지는 Wrapping 클래스. incrementAndGet(): ++x
    private AtomicLong index = new AtomicLong(0);
    private List<ReservationReq> reservations = new ArrayList<>();

    @GetMapping("/reservation")
    public String reservation(Model model){

        model.addAttribute(reservations);
        return "reservation";
    }

    @GetMapping("/reservations")
    @ResponseBody
    public List<ReservationReq> reservations(){

        return reservations;
    }

    @PostMapping("/reservations")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationReq addReservation(@RequestBody ReservationAddReq reservation, HttpServletResponse response){
        ReservationReq newReservation =new ReservationReq(index.incrementAndGet(),reservation.getName(),reservation.getDate(),reservation.getTime());
        reservations.add(newReservation);

        // ResponseEntity 사용하면 header 명시적으로 지정하지 않아도 된다고 한다.
        response.setHeader("Location", "/reservations/" + newReservation.getId());
        return newReservation;
    }

    @DeleteMapping("/reservations/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable Long id){
        ReservationReq delete=reservations.stream().filter(ReservationReq -> id.equals(ReservationReq.getId())).findAny().orElse(null);
        reservations.remove(delete);
    }
}

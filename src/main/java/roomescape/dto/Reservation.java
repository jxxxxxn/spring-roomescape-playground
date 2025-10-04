package roomescape.dto;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    public Long id;
    public String name;
    public String date; //우선 String으로.. 차후 Date로 형변환 필요하면 교체..
    public String time; //동일!!

    public Reservation(Long id,String name,String date,String time){
        this.id=id;
        this.name=name;
        this.date=date;
        this.time=time;
    }
}

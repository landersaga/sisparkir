package parkir;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Parkir {

    private @Id @GeneratedValue Long id;
    private String no_registration;
    private String arrival;
    private String departure;
    private String status;
    private Double bills;
    private int slot;

    Parkir(){}

    public Parkir(String no_registration, String arrival, String departure, String status, Double bills, int slot) {
        this.no_registration = no_registration;
        this.arrival = arrival;
        this.departure = departure;
        this.status = status;
        this.bills = bills;
        this.slot = slot;
    }

    public Long getId(){
        return this.id;
    }
    public String getNo_registration(){
        return this.no_registration;
    }
    public String getArrival(){
        return this.arrival;
    }
    public String getDeparture(){
        return this.departure;
    }
    public String getStatus(){
        return this.status;
    }
    public Double getBills(){
        return this.bills;
    }
    public int getSlot(){
        return this.slot;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setNo_registration(String no_registration){
        this.no_registration = no_registration;
    }
    public void setArrival(String arrival){
        this.arrival = arrival;
    }
    public void setDeparture(String departure){
        this.departure = departure;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setBills(Double bills){
        this.bills = bills;
    }
    public void setSlot(int slot){
        this.slot = slot;
    }



    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Parkir)) return false;
        Parkir parkir = (Parkir) o;
        return Objects.equals(this.id, parkir.id) && Objects.equals(this.no_registration, parkir.no_registration)
        && Objects.equals(this.arrival, parkir.arrival) && Objects.equals(this.departure, parkir.departure) &&
                Objects.equals(this.status, parkir.status) && Objects.equals(this.bills, parkir.bills) &&
                Objects.equals(this.slot, parkir.slot);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.no_registration, this.arrival, this.departure, this.status, this.bills,
        this.slot);
    }

    @Override
    public String toString(){
        return "Parkir{" + "id= " + this.id + ", no_registration= " + this.no_registration + ", arrival= " + this.arrival
                + ", departure= " + this.departure + ", status= " + this.status + ", bills= " + this.bills + ", status= "
                + this.status;
    }

}

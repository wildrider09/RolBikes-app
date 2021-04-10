package getstarted.bikes.rol.com.rolbikes;

/**
 * Created by sumitghosh on 09/05/17.
 */

public class bikeDetailsClass {
    bikeDetailsClass(){

    }
    private String Name;
    private String Model;
    private String Number;
    private String Price;
    private boolean Vno;
    private boolean Availability;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public boolean isVno() {
        return Vno;
    }

    public void setVno(boolean vno) {
        Vno = vno;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }
}

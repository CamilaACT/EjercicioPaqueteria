import java.util.Objects;

public class Adress {

    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Adress(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(street, adress.street) && Objects.equals(city, adress.city) && Objects.equals(state, adress.state) && Objects.equals(zipCode, adress.zipCode);
    }


    @Override
    public String toString() {
        return "Informacion Dirección{" +
                " street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

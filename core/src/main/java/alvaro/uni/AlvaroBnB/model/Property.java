package alvaro.uni.AlvaroBnB.model;

public class Property {

    private String name;
    private Double[] rates;
    private String description;
    private String address;
    private User owner;

    public Property(String name, Double[] rates, String description, String address, User owner) {
        this.name = name;
        this.rates = rates;
        this.description = description;
        this.address = address;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double[] getRates() {
        return rates;
    }

    public void setRates(Double[] rates) {
        this.rates = rates;
    }

    public Double getRate() {
        Double sum = sumaRates(rates);
        Double res = sum / rates.length;
        return res;
    }

    private Double sumaRates(Double[] rates){
        Double res = 0.0;
        for(Double d : rates){
            res += d;
        }
        return res;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

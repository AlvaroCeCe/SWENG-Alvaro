package alvaro.uni.AlvaroBnB.model.helpClasses;

public class CreditCard {

    private String number;
    private String holderName;
    private String brandName;
    private Integer expirationYear;
    private Integer cvv;
    private Integer expirationMonth;

    public CreditCard(String number, String holderName, String brandName, Integer expirationYear, Integer cvv, Integer expirationMonth) {
        this.number = number;
        this.holderName = holderName;
        this.brandName = brandName;
        this.expirationYear = expirationYear;
        this.cvv = cvv;
        this.expirationMonth = expirationMonth;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }
}

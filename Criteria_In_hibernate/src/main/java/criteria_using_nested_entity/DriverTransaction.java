package criteria_using_nested_entity;

import javax.persistence.*;

@Entity
public class DriverTransaction {
    @Id
    private int transactionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId")
    private Driver driver;


    @Override
    public String toString() {
        return "DriverTransaction{" +
                "transactionId=" + transactionId +
                ", driver=" + driver +
                '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

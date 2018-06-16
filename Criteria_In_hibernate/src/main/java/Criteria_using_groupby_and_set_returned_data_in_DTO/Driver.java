package Criteria_using_groupby_and_set_returned_data_in_DTO;

import javax.persistence.*;

@Entity
public class Driver {

    @Id
    private int driverId;
    private String driverName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="accountId")
    private DriverAccount driverAccount;


    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", driverAccount=" + driverAccount +
                '}';
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }


    public DriverAccount getDriverAccount() {
        return driverAccount;
    }

    public void setDriverAccount(DriverAccount driverAccount) {
        this.driverAccount = driverAccount;
    }
}

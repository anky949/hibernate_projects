package criteria_using_nested_entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DriverAccount {

    @Id
    private int accountId;
    private int accountNo;





    @Override
    public String toString() {
        return "DriverAccount{" +
                "accountId=" + accountId +
                ", accountNo=" + accountNo +
                '}';
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

}

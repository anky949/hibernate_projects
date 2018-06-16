package Criteria_using_groupby_and_set_returned_data_in_DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

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

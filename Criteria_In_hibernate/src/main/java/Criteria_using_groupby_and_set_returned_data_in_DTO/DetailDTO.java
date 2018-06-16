package Criteria_using_groupby_and_set_returned_data_in_DTO;


public class DetailDTO {

    public Long getTotal_drivers() {
        return total_drivers;
    }

    @Override
    public String toString() {
        return "DetailDTO{" +
                "total_drivers=" + total_drivers +
                ", accno=" + accno +
                '}';
    }

    public void setTotal_drivers(Long total_drivers) {
        this.total_drivers = total_drivers;
    }

    public Integer getAccno() {
        return accno;
    }

    public void setAccno(Integer accno) {
        this.accno = accno;
    }

    private Long total_drivers;
    private Integer accno;


}

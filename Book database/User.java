public class User {
    private int id;
    private String employeeName;
    private String hours;
    private String payments;
    public User(String employeeName, String hours, String payments){
        this.employeeName = employeeName;
        this.hours = hours;
        this.payments = payments;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getId() {
        return id;
    }

    public String getHours() {
        return hours;
    }

    public String getPayments() {
        return payments;
    }
}

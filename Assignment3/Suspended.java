public class Suspended extends Customer{
    private final String customerName;
    private final String violation;

    Suspended(String name, String violation){
        super('D');
        this.violation=violation;
        customerName= name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getViolation() {
        return violation;
    }

    @Override
    public String getCustomerInfo() {
        return "Violation: "+getViolation()+". Ticket Number "+getTicketNumber()+". Name: "+getCustomerName();
    }
}
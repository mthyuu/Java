public class Move extends Customer{
    private String customerName;
    private String stateFrom;

    Move(String name, String state){
        super('C');
        customerName=name;
        stateFrom=state;
    }

    public String getStateFrom() {
        return stateFrom;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String getCustomerInfo() {
        return "Moved from "+getStateFrom()+". Ticket Number "+getTicketNumber()+". Name: "+getCustomerName();
    }
}
public class Renew extends Customer{
    public String customerName;

    Renew(String name){
        super('B');
        customerName = name;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String getCustomerInfo(){
        return "Renewal License. Ticket Number "+getTicketNumber()+". Name: "+getCustomerName();
    }
}
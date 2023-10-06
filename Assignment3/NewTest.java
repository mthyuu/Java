public class NewTest extends Customer{
    private String customerName;
    private String dateOfBirth;

    NewTest(String name, String dob){
        super('A');
        customerName = name;
        dateOfBirth = dob;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getCustomerInfo(){
        return "New Drivers License. Ticket Number "+getTicketNumber()+". Name: "+getCustomerName()+" DOB: "+getDateOfBirth();
    }
}
import com.cabinvoice.InvoiceGenerator;
import com.cabinvoice.InvoiceSummary;
import com.cabinvoice.InvoiceWithUserId;
import com.cabinvoice.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new  InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculator(distance,time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculator(distance,time);
        Assertions.assertEquals(5, fare, 0.0);

    }

//    @Test
//    public void givenMultipleRides_ShouldReturnTotalFare(){
//        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
//        Ride[] rides ={ new Ride(2.0,5),
//                new Ride(0.1,1)
//        };
//        double fare = invoiceGenerator.calculateFare(rides);
//        Assertions.assertEquals(30, fare, 0.0);
//
//    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary= new InvoiceSummary(2, 30.2);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        int ridesId = 2;
        InvoiceWithUserId summary = invoiceGenerator.invoiceList(ridesId);
        InvoiceWithUserId expectedInvoiceSummary= new InvoiceWithUserId(1,30.2,2);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
}

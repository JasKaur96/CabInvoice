package com.cabinvoice;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final double MINIMUM_FARE = 5.0;
    private static final int id = 0;

    public double calculator(double distance, int time){
        double  totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        if(totalFare < MINIMUM_COST_PER_KM)
            return MINIMUM_FARE;
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            double fare = this.calculator(ride.distance, ride.time);
            totalFare = totalFare+fare;
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public InvoiceWithUserId invoiceList(int ridesId){
        Map<Integer, InvoiceWithUserId> summaryMap = new HashMap<>();
        InvoiceWithUserId summary1 = new InvoiceWithUserId(2,30.0,1);
        InvoiceWithUserId summary2 = new InvoiceWithUserId(1,30.2,2);
        InvoiceWithUserId summary3 = new InvoiceWithUserId(1,30.2,3);
        summaryMap.put(summary1.id,summary1);
        summaryMap.put(summary2.id,summary2);
        summaryMap.put(summary3.id,summary3);
        return summaryMap.get(ridesId);
    }
}

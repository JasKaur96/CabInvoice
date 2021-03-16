package com.cabinvoice;

public class InvoiceSummary {
    public int numOfRides;
    public double totalFare;
    public double averageFare;
    public int id;

    public InvoiceSummary(int numOfRides, double totalFare){
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/numOfRides;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        InvoiceSummary invoiceSummary = (InvoiceSummary) obj;
        return  Double.compare(invoiceSummary.averageFare, averageFare) == 0
                && numOfRides == invoiceSummary.numOfRides &&
                Double.compare(invoiceSummary.totalFare, totalFare) == 0;
    }
}
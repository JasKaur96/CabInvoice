package com.cabinvoice;

public class InvoiceWithUserId{
        public int numOfRides;
        public double totalFare;
        public double averageFare;
        public int id;

        public InvoiceWithUserId(int numOfRides, double totalFare, int id) {
            this.numOfRides = numOfRides;
            this.totalFare = totalFare;
            this.averageFare = this.totalFare/this.numOfRides;
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            InvoiceWithUserId summary = (InvoiceWithUserId) obj;
            return Double.compare(summary.averageFare, averageFare) == 0 &&
                    numOfRides == summary.numOfRides &&
                    Double.compare(summary.totalFare, totalFare) == 0 && id == summary.id;
        }
}

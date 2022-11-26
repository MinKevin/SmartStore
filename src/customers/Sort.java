package customers;

import java.util.Comparator;

public class Sort {//싱글톤
    private static Sort sort;

    private Sort() {
    }

    public static Sort getSort() {
        if (sort == null)
            sort = new Sort();
        return sort;
    }

    Comparator<Customer> compareByNameDes = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    Comparator<Customer> compareByNameASC = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    Comparator<Customer> compareBySpentTimeDes = new Comparator<Customer>(){
        @Override
        public int compare(Customer o1, Customer o2){
            return o2.getSpentTime() - o1.getSpentTime();
        }
    };

    Comparator<Customer> compareBySpentTimeAsc = new Comparator<Customer>(){
        @Override
        public int compare(Customer o1, Customer o2){
            return o1.getSpentTime() - o2.getSpentTime();
        }
    };

    Comparator<Customer> compareByTotalPaymentDes = new Comparator<Customer>(){
        @Override
        public int compare(Customer o1, Customer o2){
            return o2.getTotalPay() - o1.getTotalPay();
        }
    };

    Comparator<Customer> compareByTotalPaymentAsc = new Comparator<Customer>(){
        @Override
        public int compare(Customer o1, Customer o2){
            return o1.getTotalPay() - o2.getTotalPay();
        }
    };
}

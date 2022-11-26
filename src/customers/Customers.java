package customers;

import java.util.Arrays;
import java.util.regex.Pattern;

import static util.Main.*;

public class Customers { // 싱글톤
    private static Customers customers;
    private static final int DEFAULT_SIZE = 1;
    protected Customer[] customerArr;
    private int size;
    private int capacity;


    protected Customers() {
        customerArr = new Customer[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
    }

    public static Customers getInstance() {
        if (customers == null) {
            customers = new Customers();
        }
        return customers;
    }

    public Customer[] getCustomerArr() {
        return customerArr;
    }

    public int selectCustomer() {
        int inp;
        while (true) {
            System.out.print("\nWhich customer (1 ~ " + size + ")?");
            inp = Integer.parseInt(input());
            if (inp < 1 || inp > size)
                System.out.println(padding + "\nInvalid Type for Input. Please try again\n" + padding);
            else
                break;
        }
        return inp;
    }

    public Customer updateCustomer(Customer customer) {
        while (true) {
            String[] guide = {"Name", "ID", "Spent Time", "Total Pay"};
            System.out.println(
                    "==============================\n" +
                            " 1. Customer Name\n" +
                            " 2. Customer ID\n" +
                            " 3. Customer Spent Time\n" +
                            " 4. Customer Total Pay\n" +
                            " 5. Back\n" +
                            "==============================\n" +
                            "Choose One:"
            );
            int inp = Integer.parseInt(input());
            if (inp >= 1 && inp <= 4) {
                while (true) {
                    System.out.println("Input Customer's " + guide[inp - 1] + ":");

                    if (inp == 1 || inp == 2) {
                        String strInp = " ";
                        try {
                            strInp = br.readLine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        boolean regex = false;
                        if (inp == 1) {
                            //이름 중간에 공백문자 2개까지 허용 + 3글자 이상
                            String rgName = "^[A-Za-z]{3,}\\s?[A-Za-z]*\\s?[A-Za-z]*$$";
                            regex = Pattern.matches(rgName, strInp);
                            if (regex == true) {
                                customer.setName(strInp);
                                break;
                            }
                        } else if (inp == 2) {
                            //[A-Za-z0-9_] == \w
                            //첫 글자 숫자, _, 한글 금지 (이정도면 걍 영어만 쓰는게 낫지 않나...?)
                            String rgID = "^[^_0-9가-힣ㄱ-ㅎ]*[A-Za-z0-9_]{4,11}$";
                            regex = Pattern.matches(rgID, strInp);
                            if (regex == true) {
                                customer.setUserID(strInp);
                                break;
                            }
                        }
                        else System.out.println("Invalid Format for Input. Please try again.\n");
                    }
                    else if (inp == 3 || inp == 4) {
                        int intInp = Integer.parseInt(input());
                        if (inp == 3) {
                            customer.setSpentTime(intInp);
                        } else {
                            customer.setTotalPay(intInp);
                        }
                        break;
                    }
                }
            } else if (inp == 5) {
                return customer;
            } else System.out.println("Invalid Format for Input. Please try again.\n");
        }
    }

    public void add() {
        while (true) {
            System.out.println(
                    "** Press -1, if you want to exit! **\n" +
                            "How many customers to input?"
            );
            int cnt = Integer.parseInt(input());
            if (cnt == -1)
                break;

            while (cnt-- != 0) {
                Customer customer = new Customer();
                add(updateCustomer(customer));
            }
            break;
        }

    }

    public void view() {
        System.out.println("=======Customer Info.=======");
        //class 내부이므로
        //customerArr == Customers.getInstance().getCustomerArr()
        if (size == 0) {
            System.out.println("No Customer Info yet\n");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.printf("No.%03d ==> ", i + 1);
            System.out.println(customerArr[i]);
        }
    }

    public void update() {
            int target = selectCustomer();
            updateCustomer(customerArr[target - 1]);
    }

    public void delete() {
        int target = selectCustomer();
        pop(target - 1);
    }

    //선생님이 짜주신 부분
    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int i, Customer customer) { // i 번째 원소를 customer 로 수정
        if (!(i >= 0 && i < size)) return;
        if (customer == null) return;

        customerArr[i] = customer;
    }

    public Customer get(int i) { // i 번째 원소 반환
        if (!(i >= 0 && i < size)) return null;

        return customerArr[i];
    }

    public int indexOf(Customer customer) { // customer 원소 인덱스 반환
        if (customer == null) return -1; // 객체를 찾지 못함

        for (int i = 0; i < size; i++) {
            if (customerArr[i].getSerialNO().equals(customer.getSerialNO())) return i;
        }
        return -1; // 객체를 찾지 못함
    }


    public void add(Customer customer) { // 가장 마지막에 원소 추가
        if (customer == null) return;
        if (size < capacity) {
            customerArr[size] = customer;
            size++;
        } else {
            grow(); // doubling
            add(customer);
        }

    }

    public void add(int i, Customer customer) { // i 번째 원소 추가
        if (!(i >= 0 && i < size)) return;
        if (customer == null) return;

        if (size < capacity) {
            for (int j = size - 1; j >= i; j--) {
                customerArr[j + 1] = customerArr[j];
            }
            customerArr[i] = customer;
            size++;
        } else {
            grow();
            add(i, customer);
        }
    }


    public void pop() { // 가장 마지막의 원소 삭제
        customerArr[size - 1] = null;
        size--;
    }

    public void pop(int i) { // i 번째 원소 삭제
        if (!(i >= 0 && i < size)) return;

        customerArr[i] = null; // 명시적으로 원소 삭제되었다고 표시하기 위함 (어차피 i + 1에 의해 덮어씌워짐)

        for (int j = i + 1; j < size; j++) {
            customerArr[j - 1] = customerArr[j];
        }
        customerArr[size - 1] = null;
        size--;
    }

    public void pop(Customer customer) { // customer 원소 삭제
        if (customer == null) return;

        pop(indexOf(customer));
    }

    public void trimToSize() { // 실제 객체 수만큼 객체 배열의 크기를 변경
        Customer[] newCustomers = new Customer[size];
        for (int i = 0; i < size; i++) {
            newCustomers[i] = customerArr[i];
        }

        customerArr = newCustomers;
        capacity = size;
    }

    public void grow() { // 배열의 크기를 더블링하는 함수
        Customer[] temp = new Customer[size];
        for (int i = 0; i < size; i++) {
            temp[i] = customerArr[i];
        }

        capacity *= 2;

        Customer[] newCustomers = new Customer[capacity];
        for (int i = 0; i < Math.min(size, capacity); i++) {
            newCustomers[i] = temp[i];
        }

        customerArr = newCustomers;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.printf("No.  %4d => %s\n", (i + 1), customerArr[i]);
        }
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; i++) {
            str += customerArr[i] + "\n";
        }
        return str;
    }


    // size: 실제 객체 수
    // capacity: 배열에 저장할 수 있는 배열 크기
    // size <= capacity

    // Customer 여러명을 저장하는 객체 배열 => Customers
    // 1) add
    // 2) set
    // 3) remove
    // 4) size
    // 5) trimToSize
    // 6) grow (doubling)
}

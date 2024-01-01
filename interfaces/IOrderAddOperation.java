package interfaces;

public interface IOrderAddOperation {
    boolean orderAdd(String customer, String product, String status, boolean isCustomer);
}


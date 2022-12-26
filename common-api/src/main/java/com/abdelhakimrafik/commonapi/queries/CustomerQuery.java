package com.abdelhakimrafik.commonapi.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class CustomerQuery {

    @Getter @AllArgsConstructor @NoArgsConstructor
    private abstract static class BaseCustomerQuery {
        private String id;
        private String name;
        private String address;
        private String email;
        private String phone;
    }

    /**
     * Query to create new customer
     */
    @NoArgsConstructor
    public static class CreateCustomer extends BaseCustomerQuery {
        public CreateCustomer(String name, String address, String email, String phone) {
            super(null, name, address, email, phone);
        }
    }

    /**
     * Query to update customer by its id
     */
    @NoArgsConstructor
    public static class UpdateCustomer extends BaseCustomerQuery {
        public UpdateCustomer(String id, String name, String address, String email, String phone) {
            super(id, name, address, email, phone);
        }
    }

    /**
     * Query to delete customer by its id
     */
    @Getter @AllArgsConstructor @NoArgsConstructor
    public static class DeleteCustomer {
        private String id;
    }

    /**
     * Query to get all customers
     */
    public static class GetAllCustomers {}

    /**
     * Query to get customer by its id
     */
    @Getter @AllArgsConstructor @NoArgsConstructor
    public static class GetCustomerById {
        private String id;
    }
}

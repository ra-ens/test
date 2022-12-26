package com.abdelhakimrafik.commonapi.commands;

import com.abdelhakimrafik.commonapi.queries.CustomerQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class CustomerCommand {

    @Getter @AllArgsConstructor @NoArgsConstructor
    private abstract static class BaseCustomerCommand {
        private String id;
        private String name;
        private String address;
        private String email;
        private String phone;
    }

    @NoArgsConstructor
    public static class CreateCustomer extends BaseCustomerCommand {
        public CreateCustomer(String id, String name, String address, String email, String phone) {
            super(id, name, address, email, phone);
        }
    }


    /**
     * Command to update customer by its id
     */
    @NoArgsConstructor
    public static class UpdateCustomer extends BaseCustomerCommand {
        public UpdateCustomer(String id, String name, String address, String email, String phone) {
            super(id, name, address, email, phone);
        }
    }

    /**
     * Command to delete customer by its id
     */
    @Getter @AllArgsConstructor @NoArgsConstructor
    public static class DeleteCustomer {
        private String id;
    }
}

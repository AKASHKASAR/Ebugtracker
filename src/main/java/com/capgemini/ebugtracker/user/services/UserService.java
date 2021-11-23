package com.capgemini.ebugtracker.user.services;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.repositery.BugDao;
import com.capgemini.ebugtracker.staff.entity.StatusLogin;
import com.capgemini.ebugtracker.user.entity.Customer;
import com.capgemini.ebugtracker.user.repositery.UserDao;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
        private UserDao CustomerRepository;

        public List<Customer> getAllUser(){
            return CustomerRepository.findAll();
        }

        public Customer registerCustomer(final Customer customer){
            return CustomerRepository.save(customer);
        }

        public com.capgemini.ebugtracker.user.entity.Customer getUser(final Long userid){
            try {
                return CustomerRepository.findById(userid).get();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return null;
        }

		public StatusLogin Login(Customer customer) {
			// TODO Auto-generated method stub
			 List<Customer> userlist = CustomerRepository.findAll();
		        for (Customer other : userlist) {
		            if (other.getUsername().equals(customer.getUsername()) && other.getPassword().equals(customer.getPassword())) {
		              //  staff.setLoggedIn(true);
		               // staffdao.save(staff);
		                return StatusLogin.SUCCESS;
		            }
		        }
		        return StatusLogin.FAILURE;
		}

}

//(Objects.nonNull(other.getUsername)

package org.opportunity.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public String admin = "oxcar103";
    public String adminPass = "Onehe";


    public boolean checkUser(String user) {
        return user.equals(admin);
    }

    public boolean checkPass (String pass) {
        return pass.equals(adminPass);
    }
}

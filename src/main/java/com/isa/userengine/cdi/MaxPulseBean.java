package com.isa.userengine.cdi;

import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.Gender;
import com.isa.userengine.domain.User;

public class MaxPulseBean {


    public double getManMaxPulse(int age) {
        return 202 - (0.55 * age);
    }

    public double getWomanPulse(int age) {
        return 216 - (1.09 * age);
    }

}

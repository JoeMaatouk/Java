package chapter9.network;

import java.util.*;

public class EnterpriseProfile extends Profile{
    private HashSet<IndividualProfile> employees;

    public EnterpriseProfile(String name, String industry){
        super(name, industry);
        this.employees = new HashSet<IndividualProfile>();
    }

    public void employ (IndividualProfile p, String job) throws Exception { // we have to specify it because we used throw in the method.

        if (this.employees.contains(p)){ //contains bas mawjoude lal set mech lal list
            throw new Exception("The candidate is alredy employed by the enterprise.");
        }
        p.setJobPosition(job);
        this.employees.add(p);
    }
}
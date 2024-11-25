package chapter9.network;

import java.util.*;
//import java.util.HashMap;

public class Network {
    // key = Name (String)   value = (Profile)
    private HashMap<String, Profile> profiles = new HashMap<String, Profile>();

    /**
     * 
     * @param name
     * @return null if the name is not found among the profiles
     */
    public Profile find(String name){
        return this.profiles.get(name);
    }

    public void createProfile(String name, String industry, String type) throws Exception{
        Profile p = null;
        if (this.profiles.containsKey(name))
            throw new Exception("Cannot create profile. Name already exists");
        if (type.equalsIgnoreCase("Individual"))
            p = new IndividualProfile(name, industry, null);
        else if (type.equalsIgnoreCase("entreprise"))
            p = new EnterpriseProfile(name, industry);
        else 
            System.err.println("Cannot create profile. Profile type does not exist");
        if (p!= null)
            this.profiles.put(name, p);
    }

    @Override
    public String toString() {
        return "Network [profiles=" + profiles + "]";
    }

}
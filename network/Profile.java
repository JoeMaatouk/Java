package chapter9.network;

import java.util.*;

public class Profile {
    private String name;
    private String industry;
    private HashSet<Profile> following;

    public Profile(String name, String industry) {
        this.name = name;
        this.industry = industry;
        this.following = new HashSet<Profile>();
    }

    public void follow (Profile p){
        this.following.add(p);
    }

    // order ma elo ma3na so mech list
    // lamma esta3mel hashset majbour esta3mel hash code, men doun ma tontalab

    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;
        if (o instanceof Profile){
            Profile p = (Profile) o;
            if (p.name.equals(this.name))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Profile [name=" + name + ", industry=" + industry + "]";
    }

    @Override
    public int hashCode(){
        return this.name.hashCode(); //calls another hashCode method, not the same one as in a recursive function
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public HashSet<Profile> getFollowing() {
        return following;
    }

    public void setFollowing(HashSet<Profile> following) {
        this.following = following;
    }
}
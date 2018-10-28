

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HealthService {
    private String serviceName;
    private Set<String> locations;
    private int minAge;
    private int maxAge;
    private String gender;
    private String serviceLink;
    private Set<String> tags;

    public HealthService(String name, Set<String> locations, int minAge, int maxAge, String gender, HashSet<String> tags, String site) {
        this.serviceName = name;
        this.locations = locations;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.gender = gender;
        this.tags = tags;
        this.serviceLink = site;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Set<String> getLocations() {
        return locations;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public String getGender() {
        return gender;
    }

    public Set<String> getTags() {
        return tags;
    }

    public String getServiceLink() {
        return serviceLink;
    }



}

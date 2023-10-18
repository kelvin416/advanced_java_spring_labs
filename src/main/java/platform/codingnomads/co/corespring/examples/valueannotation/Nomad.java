package platform.codingnomads.co.corespring.examples.valueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Nomad {

    private String name;

    private Integer age;

    public Nomad(@Value("${nomad.name}") String name, @Value("${nomad.age}") Integer age) {
        this.name = name;
        this.age = age;
    }

    @Value("Hello!!")
    private String greeting;

    @Value("${nomad.framework}")
    private String framework;

    @Value("${nomad.jdk}")
    private String jdk;

    @Value("${nomad.ide:IntelliJ IDEA}")
    private String ide;

    @Value("${nomad.workingDays}")
    private List<String> workingDays;

    @Value("#{${database.values}}")
    private Map<String, String> databaseValues;

    @Value("${nomad.dob}")
    private Integer dob;
    @Value("${nomad.email}")
    private String email;
    @Value("${nomad.course}")
    private String course;
    @Value("${nomad.location:Kenya}")
    private String location;

    public String nomadIdentity() {
        return name.concat(" ").concat(age.toString()).concat(" date of birth: ")
                .concat(dob.toString().concat(", email: ").concat(email).concat(", course: ")
                        .concat(course).concat(", location:").concat(location));
    }

    public String getGreeting() {
        return greeting;
    }

    public String output() {
        return "Spring Developer is building awesome software using: ".concat(jdk).concat(" , ").concat(framework).concat(" and ").concat(ide);
    }

    public List<String> getWorkingDays() {
        return workingDays;
    }

    public Map<String, String> getDatabaseValues() {
        return databaseValues;
    }
}

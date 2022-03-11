package Collections;

import java.util.HashMap;
import java.util.Map;

public class Participant {

    public Integer registrationNumber;
    public Integer rg;
    public String firstName;
    public String lastName;
    public Integer age;
    public Integer phone;
    public Integer emergencyNumber;
    public String bloodType;

    public Participant( Integer rg, String firstName, String lastName, Integer age, Integer phone, Integer emergencyNumber, String bloodType) {

        this.rg = rg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    @Override
    public int hashCode() {
        return this.rg;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Participant){
            Participant p = (Participant) obj;
            return p.rg.equals(this.rg);
        }
        return false;
    }

    @Override
    public String toString() {
        Map<String, String> infos = new HashMap<>();
        infos.put("Número", registrationNumber.toString());
        infos.put("RG", rg.toString());
        infos.put("Nome", firstName);
        infos.put("Telefone", phone.toString());

        return infos.toString();

    }
}

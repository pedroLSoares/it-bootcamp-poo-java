import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JungleRace {

    public Integer kmSize;
    public String description;
    public String course;
    public Set<Participant> participants = new HashSet<>();

    public static Map<String, Object> smallCircuit = Map.of("distance", "2km", "Course", "Selvas e riachos", "participants", new HashSet<Participant>());

    public JungleRace(Integer kmSize, String description, String course) {
        this.kmSize = kmSize;
        this.description = description;
        this.course = course;
    }

    public Integer addParticipantAndReturnTax(Participant participant){
        if(this.kmSize == 10 && participant.age < 18){
            System.out.println("Not allowed");
            return -1;
        }

        boolean included = participants.add(participant);

        if(!included){
            System.out.println("Participant is already registered");
            return -1;
        }

        participant.registrationNumber = participants.size();

        Integer tax =  getRegistrationTax(participant);

        System.out.println("Need to pay R$ " + tax);

        return tax;

    }

    public boolean removeParticipant(Participant participant){
        return participants.remove(participant);
    }

    public boolean removeParticipant(int rgToRemove){
        return participants.removeIf(p -> p.rg == rgToRemove);
    }

    private Integer getRegistrationTax(Participant participant){
        switch (this.kmSize){
            case 2:
                return participant.age == 18 ? 1300 : 1500;
            case 5:
                return participant.age == 18 ? 2000 : 2300;
            case 10:
                return 2800;
            default:
                return -1;

        }
    }

}

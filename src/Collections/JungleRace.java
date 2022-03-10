package Collections;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JungleRace {

    public Integer kmSize;
    public String description;
    public String course;
    public Set<Participant> participants = new HashSet<>();


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
            System.out.println("Participante com rg " + participant.rg + " já inserido. \n");
            return -1;
        }

        participant.registrationNumber = participants.size();

        Integer tax =  getRegistrationTax(participant);

        System.out.println(participant.firstName + " inserido com sucesso.");
        System.out.println("Valor R$ " + tax + "\n");

        return tax;

    }

    public boolean removeParticipant(Participant participant){
        return this.removeParticipant(participant.rg);
    }

    public boolean removeParticipant(int rgToRemove){
        boolean removed =  participants.removeIf(p -> p.rg == rgToRemove);

        String message = removed ? "Participante com rg " + rgToRemove + " removido com sucesso. \n" : "Participante não encontrado. \n";

        System.out.println(message);

        return removed;
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

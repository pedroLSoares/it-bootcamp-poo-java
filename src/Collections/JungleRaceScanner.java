package Collections;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

public class JungleRaceScanner {

    JungleRace smallCircuit = new JungleRace(2, "Circuito pequeno", "Selva e riachos");
    JungleRace mediumCircuit = new JungleRace(5, "Circuito médio", "Selva, riachos e lama");
    JungleRace advancedCircuit = new JungleRace(10, "Circuito avancado", "Selva, riachos, lama e escalada");
    List<JungleRace> races = List.of(smallCircuit, mediumCircuit, advancedCircuit);
    Scanner sc;

    public void startConsole() {

        try {
            String[] options = {"registerParticipant", "removeParticipant", "showParticipants"};
            showOptions();
            sc = new Scanner(System.in);
            int menuOption = sc.nextInt();

            if(menuOption < -1 || menuOption > options.length){
                return;
            }

            Method method = JungleRaceScanner.class.getDeclaredMethod(options[menuOption - 1]);

            method.invoke(this);

            startConsole();

        }catch (Exception e){
            System.out.printf("Something went wrong " + e.getMessage());

        }finally {
            sc.close();
        }

    }

    private void showOptions(){
        System.out.println("Digite uma das opcoes");
        System.out.println("1 - Cadastrar participante.");
        System.out.println("2 - Remover participante.");
        System.out.println("3 - Exibir participantes.");
        System.out.println("0 - Sair");
    }

    private void registerParticipant(){
        System.out.print("RG: ");
        int rg = sc.nextInt();

        System.out.print("Primeiro nome: ");
        sc.nextLine();
        String firstName = sc.nextLine();


        System.out.print("Último nome: ");
        String lastName = sc.nextLine();

        System.out.print("Idade: ");
        int age = sc.nextInt();

        System.out.print("Telefone: ");
        int phone = sc.nextInt();

        System.out.print("Telefone para emergencia: ");
        int emergencyPhone = sc.nextInt();

        System.out.print("Tipo Sanguineo: ");
        sc.nextLine();
        String bloodType = sc.nextLine();



        Participant participant = new Participant(rg, firstName, lastName, age, phone, emergencyPhone, bloodType);

        addToList(participant);

    }

    private void removeParticipant(){
        System.out.println("Informe a corrida: ");
        System.out.println("1: Curta");
        System.out.println("2: Médio");
        System.out.println("3: Avancado");
        int raceLevel = sc.nextInt();

        JungleRace jungleRace = getRaceByLevel();

        System.out.print("Informe o RG: ");
        int rg = sc.nextInt();

        jungleRace.removeParticipant(rg);

    }

    private void showParticipants(){
        JungleRace jungleRace = getRaceByLevel();

        System.out.println(jungleRace.participants);
    }

    private JungleRace  getRaceByLevel(){
        showRaceOptions();
        int raceLevel = sc.nextInt();

        if(raceLevel < 0 || raceLevel > races.size()){
            System.out.println("Corrida inválida");
            return getRaceByLevel();

        }
            JungleRace jungleRace = races.get(raceLevel -1);
            return jungleRace;

    }

    private void showRaceOptions(){
        System.out.println("Informe a corrida: ");
        System.out.println("1: Curta");
        System.out.println("2: Médio");
        System.out.println("3: Avancado");
    }

    private void addToList(Participant participant){

        JungleRace jungleRace = getRaceByLevel();

        jungleRace.addParticipantAndReturnTax(participant);

    }
}

package AbstractClasseAndInterfaces.PrintDocuments;

public class Printer {

    public static void print(Document document){
        System.out.println("Printing " + document.getFileName());
    }
}

package AbstractClasseAndInterfaces.PrintDocuments;

import Classes.Ability;
import Classes.Person;

import java.io.IOException;
import java.util.List;

public class PrintDocuments {

    public static void main(String[] args) throws IOException {
        Curriculum curriculum = new Curriculum();
        Person person = new Person("2", "Jonas", 23, 180, 75.4);
        Ability ability1 = new Ability("Java", 10);
        curriculum.setPerson(person).setAbilities(List.of(ability1));

        PDFBook pdfBook = new PDFBook();
        pdfBook.setAuthorName("Pedro").setGenre("Fantasy").setPagesNumber(250).setTitle("Book title");


        Printer.print(pdfBook);
        Printer.print(curriculum);
    }
}

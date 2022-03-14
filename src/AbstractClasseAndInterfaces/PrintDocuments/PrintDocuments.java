package AbstractClasseAndInterfaces.PrintDocuments;

import Classes.Person;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PrintDocuments {

    public static void main(String[] args) throws IOException {
        Curriculum curriculum = new Curriculum("curriculum");
        Person person = new Person("2", "Jonas", 23, 180, 75.4);
        curriculum.setPerson(person).setAbilities(new ArrayList<>());

        PDFBook pdfBook = new PDFBook("pdfbook.pdf");
        pdfBook.setAuthorName("Pedro").setGenre("Fantasy").setPagesNumber(250).setTitle("Book title");


        Printer.print(pdfBook);
        Printer.print(curriculum);
    }
}

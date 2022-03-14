package AbstractClasseAndInterfaces.PrintDocuments;

public class Report extends Document{
    private String authorName;
    private String reviewerName;
    private String text;
    private int pagesNumber;

    public Report(String fileName) {
        super(fileName);
    }
}

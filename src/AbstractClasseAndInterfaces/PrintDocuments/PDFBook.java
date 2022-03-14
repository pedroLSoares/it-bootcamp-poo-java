package AbstractClasseAndInterfaces.PrintDocuments;

public class PDFBook extends Document{
    private String title;
    private String genre;
    private String authorName;
    private int pagesNumber;

    public PDFBook(String fileName) {
        super(fileName);
    }

    public PDFBook setTitle(String title) {
        this.title = title;
        return this;
    }

    public PDFBook setGenre(String genre) {
        this.genre = genre;
        return  this;
    }

    public PDFBook setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public PDFBook setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
        return this;
    }
}

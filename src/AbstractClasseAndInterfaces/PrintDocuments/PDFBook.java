package AbstractClasseAndInterfaces.PrintDocuments;

public class PDFBook implements Document{
    private String title;
    private String genre;
    private String authorName;
    private int pagesNumber;


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

    @Override
    public DocumentObject getContent() {
        return new DocumentObject(title, null, pagesNumber, "Genero: " + genre);

    }
}

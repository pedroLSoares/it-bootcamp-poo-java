package AbstractClasseAndInterfaces.PrintDocuments;

public class Report implements Document{
    private String authorName;
    private String reviewerName;
    private String text;
    private int pagesNumber;

    public Report setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public Report setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
        return this;
    }

    public Report setText(String text) {
        this.text = text;
        return this;
    }

    public Report setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
        return this;
    }

    @Override
    public String getContent() {
        return "Autor: " + authorName + "\nRevisor: " + reviewerName + "\n Número de páginas: " + pagesNumber + "\nConteúdo: " + text;
    }
}

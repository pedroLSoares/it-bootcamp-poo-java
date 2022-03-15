package AbstractClasseAndInterfaces.PrintDocuments;

public class DocumentObject {
    private String title;
    private String content;
    private Integer pages;
    private String additionalInformation;

    public DocumentObject(String title, String content, Integer pages) {
        this.title = title;
        this.content = content;
        this.pages = pages;
    }

    public DocumentObject(String title, String content, Integer pages, String additionalInformation) {
        this.title = title;
        this.content = content;
        this.pages = pages;
        this.additionalInformation = additionalInformation;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getPages() {
        return pages;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    @Override
    public String toString() {

        return "DocumentObject{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pages=" + pages +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}

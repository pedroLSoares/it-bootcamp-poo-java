package AbstractClasseAndInterfaces.PrintDocuments;

abstract class Document {
    private String fileName;

    public Document(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}

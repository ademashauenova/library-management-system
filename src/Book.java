public class Book {
    private String title;
    private boolean status;
    private String author;

    public Book(){

    }

    public Book(String title, String author){
        setTitle(title);
        setAuthor(author);
        setStatus(status);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString(){
        return "Book:" + "title = " + title + ", author = " + author + ", status = " + (status ? "Available" : "Borrowed");
    }
}

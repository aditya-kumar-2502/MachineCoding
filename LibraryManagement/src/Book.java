public class Book {
    Long id;
    String title;
    String author;
    int totalCopies;
    int availableCopies;

    Book(Long id, String title, String author, int totalCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalCopies = this.availableCopies = totalCopies;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getAvailableCopies(){
        return availableCopies;
    }

    public void issue(){
        if(availableCopies > 0){
            availableCopies--;
        } else {
            System.out.println("No copies available");
        }
    }

    public void returnBook(){
        if(availableCopies < totalCopies){
            availableCopies++;
        } else {
            System.out.println("All copies are already returned");
        }
    }
    
    @Override
    public String toString(){
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                '}';
    }
}

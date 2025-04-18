import java.util.HashSet;
import java.util.Set;

public class Member {
    Long id;
    String name;
    Set<Long> borrowedBooks = new HashSet<>();

    Member(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return  id;
    }

    public void addBook(Long bookId){
        borrowedBooks.add(bookId);
    }
    public void removeBook(Long bookId){
        borrowedBooks.remove(bookId);
    }

    @Override
    public String toString(){
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}

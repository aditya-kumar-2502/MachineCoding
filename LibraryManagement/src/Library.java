import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    Map<Long, Book> books = new HashMap<>();
    Map<Long, Member> members = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void removeBook(Long bookId) {
        books.remove(bookId);
    }

    public List<Book> searchBooks(String keyword){
        return books.values().stream().filter(book -> book.getTitle().contains(keyword)).toList();
    }

    public void registerMember(Member member) {
        members.put(member.getId(), member);
    }

    public void deleteMember(Long memberId) {
        members.remove(memberId);
    }

    public void issueBook(Long bookId, Long memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book != null && members != null) {
            book.issue();
            members.get(memberId).addBook(book.getId());
            System.out.println("Book issued to member");
        } else {
            System.out.println("Book or Member not found");
        }
    }

    public void returnBook(Long bookId, Long memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book != null && member != null) {
            book.returnBook();
            member.removeBook(book.getId());
            System.out.println("Book returned from member");
        } else {
            System.out.println("Book or Member not found");
        }
    }

    public void showAvailableBooks() {
        List<Book> availableBooks = books.values().stream().filter(book -> book.getAvailableCopies() > 0).toList();
        if(availableBooks.isEmpty()){
            System.out.println("No available books");
            return;
        }
        availableBooks.forEach(System.out::println);
    }

    public void showAllMembers(){
        members.values().forEach(System.out::println);
    }

    public void showBorrowedBooks(Long memberId){
        Member member = members.get(memberId);
        if (member != null) {
            List<Book> borrowedBooks = books.values().stream().filter(book -> member.borrowedBooks.contains(book.getId())).toList();
            borrowedBooks.forEach(System.out::println);
        } else {
            System.out.println("Member not found");
        }
    }
}

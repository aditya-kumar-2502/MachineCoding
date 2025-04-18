public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", 1);
        Member member = new Member(1L, "John Doe");
        library.addBook(book);
        library.registerMember(member);
        library.showAllMembers();
        library.showAvailableBooks();

        library.issueBook(1L, 1L);
        library.showAvailableBooks();
        library.showBorrowedBooks(1L);

    }
}
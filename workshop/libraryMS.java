public class libraryMS {
    import java.util.ArrayList;
import java.util.List;

    class Book {
        private String title;
        private String author;
        private String isbn;
        private boolean isAvailable;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isAvailable = true;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getIsbn() { return isbn; }
        public boolean isAvailable() { return isAvailable; }

        public void borrowBook() {
            if (isAvailable) {
                isAvailable = false;
                System.out.println(title + " has been borrowed.");
            } else {
                System.out.println(title + " is not available.");
            }
        }

        public void returnBook() {
            isAvailable = true;
            System.out.println(title + " has been returned.");
        }

        @Override
        public String toString() {
            return "Book [Title=" + title + ", Author=" + author + ", ISBN=" + isbn + ", Available=" + isAvailable + "]";
        }
    }

    class Member {
        private String name;
        private String memberId;

        public Member(String name, String memberId) {
            this.name = name;
            this.memberId = memberId;
        }

        public String getName() { return name; }
        public String getMemberId() { return memberId; }

        @Override
        public String toString() {
            return "Member [Name=" + name + ", ID=" + memberId + "]";
        }
    }

    class Library {
        private List<Book> bookList;
        private List<Member> memberList;

        public Library() {
            bookList = new ArrayList<>();
            memberList = new ArrayList<>();
        }

        public void addBook(Book book) {
            bookList.add(book);
            System.out.println(book.getTitle() + " added to library.");
        }

        public void addMember(Member member) {
            memberList.add(member);
            System.out.println(member.getName() + " registered as a member.");
        }

        public void showBooks() {
            System.out.println("\n--- Library Books ---");
            for (Book book : bookList) {
                System.out.println(book);
            }
        }

        public void borrowBook(String isbn, String memberId) {
            for (Book book : bookList) {
                if (book.getIsbn().equals(isbn)) {
                    book.borrowBook();
                    return;
                }
            }
            System.out.println("Book with ISBN " + isbn + " not found.");
        }

        public void returnBook(String isbn) {
            for (Book book : bookList) {
                if (book.getIsbn().equals(isbn)) {
                    book.returnBook();
                    return;
                }
            }
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Library library = new Library();

            Book b1 = new Book("The Alchemist", "Paulo Coelho", "ISBN001");
            Book b2 = new Book("1984", "George Orwell", "ISBN002");
            library.addBook(b1);
            library.addBook(b2);

            Member m1 = new Member("Alice", "M001");
            Member m2 = new Member("Bob", "M002");
            library
}

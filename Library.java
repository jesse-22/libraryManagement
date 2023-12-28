package library_management;

import java.util.ArrayList;

public class Library {
	  String location;
	  ArrayList<Book> books;
	  
	 public Library(String address) {
		  this.location = address;
		  books = new ArrayList<Book>();  
	  }
	 
	 public static void printOpeningHours() {
		 System.out.println("Libraries are open daily from 9AM to 5PM.");
	 }
	 
	 public void printAddress() {
		String address = "";
		address = Library.this.location;
		System.out.println(address);
	 }
	 
	 public void addBook(Book book) {
		 books.add(book);
		 
	 }
	 
	 public void borrowBook(String title) {
		for (Book book : books) {
			if (book.getTitle() == title) {
				if (!book.isBorrowed()) {
					book.borrowed();
					System.out.println("You successfully borrowed the book");
					return;
				}
				else {
					System.out.println("Sorry that book is already borrowed.");
					return;
				}
			}
			else {
				continue;
			}
		}
		System.out.println("Sorry that book is not in the catalog.");
	 }
	 
	 public void returnBook(String title) {
			for (Book book : books) {
				if (book.getTitle() == title ){
						book.returned();
						System.out.println("You successfully return the book.");
						return;
			}
		}
	 }
		  
	 public void printAvailableBooks() { 
			 if (this.books.size() > 0) {
				for(Book book : books)
				if(!book.isBorrowed()) {
				System.out.println(book.getTitle());
				} 
			 }
			if (this.books.size() == 0)
				 System.out.println("The catalog is empty");
		return;
	 }
	 
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        

       // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        // Try to borrow The Lords of the Rings from both libraries
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    } 
}
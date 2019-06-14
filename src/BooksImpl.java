import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksImpl {

	Map<String, Book> nameMap = new HashMap<>();
	Map<String, Book> authorMap = new HashMap<>();
	List<Book> bookList = new ArrayList<>();
	TrieImpl nameTrie = new TrieImpl();
	TrieImpl authorTrie = new TrieImpl();

	public static void main(String[] args) {
		BooksImpl booksImpl = new BooksImpl();
		Book book = new Book("Book1", "author1", "publisher1", "2001", "category1", 123.4, 1);
		booksImpl.addBookToCatalog(book);
		booksImpl.addBookToCatalog(new Book("Book2", "author2", "publisher1", "2001", "category1", 123.4, 5));
		booksImpl.addBookToCatalog(new Book("Book3", "author3", "publisher1", "2001", "category1", 123.4, 2));
		List<Book> booksList = booksImpl.searchBookByName("Book");
		System.out.println(booksList);
		System.out.println(booksImpl.searchBookByAuthor("author"));
		booksImpl.searchMostSoldBooks();
	}

	public void addBookToCatalog(Book book) {
		nameMap.put(book.getName(), book);
		authorMap.put(book.getAuthor(), book);
		nameTrie.insert(book.getName());
		authorTrie.insert(book.getAuthor());
		bookList.add(book);
	}

	public List<Book> searchBookByName(String name) {
		List<String> bookNames = nameTrie.search(name);
		List<Book> booksList = new ArrayList<>();
		bookNames.stream().forEach(str -> booksList.add(nameMap.get(str)));
		return booksList;
	}

	public List<Book> searchBookByAuthor(String author) {
		List<String> bookNames = authorTrie.search(author);
		List<Book> booksList = new ArrayList<>();
		bookNames.stream().forEach(str -> booksList.add(authorMap.get(str)));
		return booksList;
	}

	public void searchMostSoldBooks() {
		Collections.sort(bookList, new SoldComparator());
		System.out.println(bookList);
	}

	class SoldComparator implements Comparator<Book> {

		@Override
		public int compare(Book b1, Book b2) {
			// TODO Auto-generated method stub
			return b2.getCount() - b1.getCount();
		}

	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Accounts {
	
	private String userId;
	
	private String username;
	
	public Accounts(String _userId, String _username) {
		this.userId = _userId;
		this.username = _username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public static void main(String[] args) {
		List<Accounts> accountsList = new ArrayList<>();
		Accounts a1 = new Accounts("ABCD", "User1");
		Accounts a2 = new Accounts("ABcD", "User2");
		accountsList.add(a1);
		accountsList.add(a2);
		
		List<String> userIdList = accountsList.stream().map(Accounts::getUserId).map(element -> element.toUpperCase()).collect(Collectors.toList());
		System.out.println(userIdList);
		
		Map<String, Accounts> accMap = accountsList.stream().collect(Collectors.toMap(x -> x.getUserId().toUpperCase(), Function.identity(), (a, b) -> a));
		System.out.println(accMap);
	}
	
}

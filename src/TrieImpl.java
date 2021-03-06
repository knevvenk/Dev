import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TrieNode{
	
	Map<Character, TrieNode> child = new HashMap<Character, TrieNode>();
	boolean isLastNode = false;
}

public class TrieImpl {
	
	TrieNode root;
	
	TrieImpl(){
		root = new TrieNode();
	}
	
	public void insert(String word){
	    TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.child.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.child.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.isLastNode = true;
    }
	
	public List<String> search(String word){
		
		Map<Character, TrieNode> tempChild = root.child;
		TrieNode tempTrie = null;
		
		char[] wordArray = word.toCharArray();
		for(int i =0; i<wordArray.length; i++){
			char c = wordArray[i];
			if(tempChild.containsKey(c)) {
				tempTrie = tempChild.get(c);
				tempChild = tempTrie.child;
			}else
				return null;
		}
		List<String> wordsList = new ArrayList<>(); 
		getWords(word, tempTrie, wordsList); 
		printTrieNode(tempTrie);
		printWordsList(wordsList);
		return wordsList;
	}
	
	private void printWordsList(List<String> wordsList) {
		System.out.println();
		System.out.println(wordsList);
		
	}

	private void getWords(String word, TrieNode tempTrie, List<String> wordsList) {		
		if(tempTrie.isLastNode) {
			wordsList.add(word);
		}
		Iterator<Character> charIterator= tempTrie.child.keySet().iterator();
		
		while(charIterator.hasNext()) {
			Character ch = charIterator.next();
			getWords(word+ch, tempTrie.child.get(ch), wordsList);
		}
	}

	public void delete(String s){
		
	}
	
	public void printTrieNode(TrieNode node) {
		TrieNode tempNode = node;
		Map<Character, TrieNode> tempChild = tempNode.child;
		Iterator<Character> it = null;
		if(tempNode.isLastNode) {
			if(!tempChild.isEmpty()) {
				it = tempChild.keySet().iterator();
				Character ch = it.next();
				System.out.println(ch);
			}
		}else {
			it = tempChild.keySet().iterator();
			for(int i=0; i<tempChild.size();i++) {
				Character ch = it.next();
				System.out.print(ch);
				printTrieNode(tempChild.get(ch));
			}
		}
		
	}

	public static void main(String[] args) {
		String[] input = {"abc", "abcd", "def", "cgh", "abgl"};//
		TrieImpl trieImpl = new TrieImpl();
		for(int i=0; i<input.length; i++)
			trieImpl.insert(input[i]);
		
		trieImpl.search("ab");
		
	}

}

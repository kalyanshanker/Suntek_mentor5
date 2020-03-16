import java.util.*;
public class Main {

	public static void Validparentheses(int l, int r, String string) { //recursive method
		if (l == 0 && r == 0) // mean all opening and closing in
			System.out.println(string);
		if (l > r)                                    // means closing parentheses is more than open ones
			return;
		if (l > 0)
			Validparentheses(l- 1, r, string + "("); // prints '(' reduces l- count by 1
		if (r > 0)
			Validparentheses(l, r - 1, string + ")"); //prints ')'reduces r-count by 1
	}


	public static void main(String[] args) {
	
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();

	Validparentheses(n / 2, n / 2, "");
	
	}
}

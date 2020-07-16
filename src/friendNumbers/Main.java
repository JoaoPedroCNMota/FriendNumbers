package friendNumbers;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		setFriendNums(100000);
	}

	static void setFriendNums(int value) {

		List<Numbers> friendNums = new ArrayList<>();

		for (int i = 1; i <= value; i++) {
			Numbers num = new Numbers(i, checkDivisorsAndSum(i));
			friendNums.add(num);
		}

		findFriendNums(friendNums);
	}

	static void findFriendNums(List<Numbers> friends) {
		for (Numbers num : friends) {
			for (Numbers sum : friends) {
				if (num.getNum() == sum.getDivisorsSum() && num.getDivisorsSum() == sum.getNum()) {
					if (num.getNum() != sum.getNum()) {
						System.out.println(num.getNum() + " amigo de " + sum.getNum());
					}
				}
			}
		}
		System.out.println("FIM");
	}

	static Integer checkDivisorsAndSum(int num) {

		List<Integer> divisors = new ArrayList<>();

		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				divisors.add(i);
			}
		}
		return divisors.stream().mapToInt(Integer::intValue).sum();
	}
}

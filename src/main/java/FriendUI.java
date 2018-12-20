import java.util.Scanner;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-20
 * Github : https://github.com/YeoHoonYun
 */
public class FriendUI {
    public int printMenuAndInputValue(){
        System.out.println("1. 친구등록");
        System.out.println("2. 이름조회");
        System.out.println("3. 전화번호로 삭제");
        System.out.println("4. 종료");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        return value;
    }
    public Friend getFriend(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력하세요. : ");
        String name = scanner.nextLine();
        System.out.println("전화번호를 입력하시오. : ");
        String phone = scanner.nextLine();
        Friend friend = new Friend(name);
        friend.setNum(phone);
        return friend;
    }


}

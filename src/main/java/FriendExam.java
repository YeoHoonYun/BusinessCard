/**
 * Created by cjswo9207u@gmail.com on 2018-12-20
 * Github : https://github.com/YeoHoonYun
 */
public class FriendExam {
    public static void main(String[] args) {
        //친구 추가
        Friend friend1 = new Friend("윤1", "01011111111");
        Friend friend2 = new Friend("윤2", "01022222222");
        Friend friend3 = new Friend("윤3", "01033333333");
        Friend friend4 = new Friend("윤2", "01044444444");
        FriendManager friendManager = new FriendManager();
        friendManager.addFriend(friend1);
        friendManager.addFriend(friend2);
        friendManager.addFriend(friend3);
        friendManager.addFriend(friend4);

        // 친구 리스트 사이즈
        System.out.println(friendManager.friendSize());

        // 조회한 친구
        System.out.println(friendManager.reFriend("윤2").toString());

        // 친구 리스트 사이즈
        System.out.println(friendManager.friendSize());

        // 해당 전화번호를 찾아 삭제
        friendManager.delFriend("01022222222");

        // 확인
        for(Friend friend : friendManager.getFriendList()){
            System.out.println(friend.toString());
        }

        // 친구 리스트 사이즈
        System.out.println(friendManager.friendSize());

    }
}

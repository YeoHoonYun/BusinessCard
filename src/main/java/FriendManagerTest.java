import org.junit.Before;
import org.junit.Test;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-20
 * Github : https://github.com/YeoHoonYun
 */
public class FriendManagerTest {
    FriendManager friendManager;

    @Before
    public void init(){
        friendManager = new FriendManager();
        Friend f1 = new Friend("홍길동1");
        f1.setNum("01011111111");
        friendManager.addFriend(f1);

        Friend f2 = new Friend("홍길동2");
        f2.setNum("01022222222");
        friendManager.addFriend(f2);

        Friend f3 = new Friend("홍길동3");
        f3.setNum("01033333333");
        friendManager.addFriend(f3);
    }

    @Test
    public void addFriend() throws Exception{
        System.out.println(friendManager.friendSize());
        for(Friend f : friendManager.getFriendList()){
            System.out.println(f.toString());
        }
    }
}

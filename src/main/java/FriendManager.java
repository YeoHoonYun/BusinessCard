import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-20
 * Github : https://github.com/YeoHoonYun
 */
public class FriendManager {
    List<Friend> friendList;

    public FriendManager() {
        friendList = new ArrayList<>();
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public void addFriend(Friend friend){
        friendList.add(friend);
    }

    public List<Friend> reFriend(String name){
        List<Friend> returnList = new ArrayList<>();
        for (Friend f : this.friendList){
            if (f.getName().equals(name)){
                returnList.add(f);
            }
        }
        return returnList;
    }

    public void delFriend(String num){
        Iterator<Friend> iterator = friendList.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getNum().equals(num)){
                iterator.remove();
            }
        }
    }

    public int friendSize(){
        return friendList.size();
    }

    @Override
    public String toString() {
        return "FriendManager{" +
                "friendList=" + friendList +
                '}';
    }
}


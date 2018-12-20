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

    // 친구 추가
    public void addFriend(Friend friend){
        friendList.add(friend);
    }

    // 친구 검색
    public List<Friend> reFriend(String name){
        List<Friend> returnList = new ArrayList<>();
        for (Friend f : this.friendList){
            if (f.getName().contains(name)){
                returnList.add(f);
            }
        }
        return returnList;
    }

    // 친구 삭제
    public int delFriend(String num){
        // for문을 사용하면 기존의 데이터의 길이가 줄어 들기 때문에 아웃 오브 바운드가 발생하기 때문에 Iterator로 바꿔서 작성해준다.
        Iterator<Friend> iterator = friendList.iterator();
        int deleteNum = 0;
        while(iterator.hasNext()){
            if(iterator.next().getNum().equals(num)){
                deleteNum++;
                iterator.remove();
            }
        }
        return deleteNum;
    }

    // 친구 수
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


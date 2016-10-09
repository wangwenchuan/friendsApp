
package model;


public class Friends {
    private int friendID;
    private String friendName;
    private String emailAddr;
    private int age;
    private String favoriteColor;
    
    
    public Friends() {
        this.friendID = 0;
        this.friendName = "";
        this.emailAddr = "";
        this.age = 0;
        this.favoriteColor = "";
    }

    public Friends(int friendID, String friendName, String emailAddr, int age, String favoriteColor) {
        this.friendID = friendID;
        this.friendName = friendName;
        this.emailAddr = emailAddr;
        this.age = age;
        this.favoriteColor = favoriteColor;
    }

    public int getFriendID() {
        return friendID;
    }

    public void setFriendID(int friendID) {
        this.friendID = friendID;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    @Override
    public String toString() {
        return "Friends{" + "friendID=" + friendID + ", friendName=" + friendName + ", emailAddr=" + emailAddr + ", age=" + age + ", favoriteColor=" + favoriteColor + '}';
    }
    
    
    
}

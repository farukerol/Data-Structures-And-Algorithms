package arraylistpart;
import java.util.ArrayList;
/**
 *
 * Class of Account.
 * User actions' methods are contained in this class.
 */
public class Account {
    /**
     * Keeps account's id.
     */
    private int accountId;
    /**
     * Keeps account's username.
     */
    private String userName;
    /**
     * Keeps account's birthdate.
     */
    private String birthDate;
    /**
     * Keeps account's location.
     */
    private String location;
    /**
     * Keeps account's login information.
     */
    private boolean isLogin;
    /**
     * Keeps account's following accounts.
     */
    private ArrayList<Account> following = new ArrayList<Account>();
    /**
     * Keeps account's followers.
     */
    private ArrayList<Account> followers = new ArrayList<Account>();
    /**
     * Keeps account's inbox.
     */
    private ArrayList<Message> inBox = new ArrayList<Message>();
    /**
     * Keeps account's outbox.
     */
    private ArrayList<Message> outBox = new ArrayList<Message>();
    /**
     * Keeps account's posts.
     */
    private ArrayList<Post> posts = new ArrayList<Post>();
    /**
     * Keeps blockList posts.
     */
    private ArrayList<Account> blockList = new ArrayList<Account>();
    /**
     * Keeps who blocked the user
     */
    private ArrayList<Account> whoBlockList = new ArrayList<Account>();
    /**
     * Keeps user action's posts.
     */
    private ArrayList<String> actions = new ArrayList<String>();
    /**
     * Constructor of Account class.
     * Creates user in the system.
     * @param accountId represent the account's id.
     * @param userName represent the account's username.
     * @param birthDate represent the account's birthdate.
     * @param location represent the account's location.
     * @param isLogin represent the account's login information.
     */
    public Account(int accountId,String userName,String birthDate,String location,boolean isLogin)
    {
        this.accountId = accountId;
        this.userName = userName;
        this.birthDate = birthDate;
        this.location = location;
        this.isLogin = isLogin;
        System.out.println("An account with username "+ userName + " has been created.");
    }
    /**
     * Shows profile information.
     * @param profile Represents the account whose information is requested to be displayed.
     */
    public void ViewProfile(Account profile){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else {
            if (profile == null){
                System.out.println("There is no profile");
            }
            else{
                if (this.blockList.indexOf(profile) != -1){
                    System.out.println("You blocked this account. You can't view this profile.");
                }else if (this.whoBlockList.indexOf(profile) != -1){
                    System.out.println("This account blocked of you. You can't view this profile");
                }else{
                    System.out.println("Viewing "+profile.getUserName()+" profile...");
                    boolean postControl = false;
                    boolean followersControl = false;
                    boolean followingControl = false;

                    int postCount = profile.getPosts().size();
                    int followerCount = profile.getFollowers().size();
                    int followingCount = profile.getFollowing().size();

                    if (postCount>0){
                        postControl = true;
                    }
                    if (followerCount>0){
                        followersControl = true;
                    }
                    if (followingCount>0){
                        followingControl = true;
                    }

                    System.out.println("User ID: "+ profile.getAccountId());
                    System.out.println("Location: "+profile.getLocation());
                    System.out.println("Birth Date: "+profile.getBirthDate());
                    System.out.println(profile.getUserName()+" "+"is following "+followingCount+" "+"account(s) and has "+followerCount+" "+"follower(s)");
                    System.out.print(profile.getUserName()+"'s followers:"+" ");
                    ListOfFollowers(profile);
                    System.out.println();
                    System.out.print(profile.getUserName()+"'s followings:"+" ");
                    ListOfFollowings(profile);
                    System.out.println();
                    if (postControl == false){
                        System.out.println(profile.getUserName()+" "+"has no post");
                    }
                    else{
                        System.out.println(profile.getUserName()+" "+"has "+postCount+" "+"post(s)" );
                    }
                }
                actions.add("You viewed "+profile.getUserName()+"'s profile");
            }
        }
    }
    /**
     * Method's of user's login.
     * Activates the login status.
     */
    public void LogIn(){
        this.isLogin = true;
        System.out.println(this.getUserName()+" Login to the system...");
        System.out.println("---");
    }
    /**
     * Method's of user's logout.
     * Makes login status inactive.
     */
    public void LogOut(){
        this.isLogin = false;
        System.out.println(this.getUserName()+" Logout to the system...");
        System.out.println("---");
    }
    /**
     * Method for list of followers.
     * @param profile Represents the profile whose followers you want to list.
     */
    public void ListOfFollowers(Account profile){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else {
            for (int i=0; i< profile.followers.size();i++){
                    System.out.print(profile.followers.get(i).getUserName()+", ");
            }
        }
    }
    /**
     * Method for list of followings.
     * @param profile Represents the profile whose followings you want to list.
     */
    public void ListOfFollowings(Account profile){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else {
            for (int i=0; i< profile.following.size();i++){
                System.out.print(profile.following.get(i).getUserName()+", ");
            }
        }
    }
    /**
     * Shares the post.
     * @param SharedPost Represents the post object to be shared
     */
    public void AddPost(Post SharedPost){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            posts.add(SharedPost);
            int flag = posts.size();
            posts.get(flag-1).setAccountId(this.accountId);
            System.out.println("Post with id number "+ SharedPost.getPostId()+" was successfully shared");
            actions.add("You shared a post with id number "+SharedPost.getPostId());
        }
    }
    /**
     * View the post details.
     * @param user Represents the user object whose posts you want to see.
     */
    public void ViewPosts(Account user){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            if (this.blockList.indexOf(user) != -1){
                System.out.println("You blocked this account. You can't view posts.");
            }else if (this.whoBlockList.indexOf(user) != -1){
                System.out.println("This account blocked of you. You can't view posts");
            }else{
                System.out.println("Viewing "+user.getUserName()+" posts...");
                if (user.posts.size() == 0){
                    System.out.println(user.getUserName()+" "+"has no post");
                }
                else{
                    for (int i =0; i<user.posts.size();i++){
                        if (user.posts.get(i)!= null){
                            System.out.println("(POST ID: "+user.posts.get(i).getPostId()+")"+" "+ user.getUserName()+": "+user.posts.get(i).getContent());
                        }
                    }
                }
            }
            actions.add("You viewed posts of "+user.getUserName());
        }
    }
    /**
     * Method for following users.
     * @param profile Represents the account to follow.
     */
    public void Follow(Account profile){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            if (this.blockList.indexOf(profile) != -1){
                System.out.println("You blocked this account. You can't follow.");
            }else if (this.whoBlockList.indexOf(profile) != -1){
                System.out.println("This account blocked of you. You can't follow");
            }else if (this.following.indexOf(profile) != -1){
                System.out.println("You have already followed this account");
            }
            else{
                profile.followers.add(this);
                this.following.add(profile);
                System.out.println(this.getUserName()+" successfully followed to "+profile.getUserName());
            }
            actions.add("You followed "+profile.getUserName());
        }
    }
    /**
     * Method for unfollow for users.
     * @param profile Represents the account to unfollowed.
     */
    public void UnFollow(Account profile){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            if (this.following.indexOf(profile) == -1){
                System.out.println("You don't follow this account. So you can't unfollow");
            }else{
                profile.followers.remove(this);
                this.following.remove(profile);
                System.out.println(this.getUserName()+" successfully unfollowed to "+profile.getUserName());
            }
            actions.add("You unfollowed "+profile.getUserName());
        }
    }
    /**
     * Method for add message to inbox.
     * @param message Represents the incoming message.
     */
    public void AddToInBox(Message message){
        this.inBox.add(message);
    }
    /**
     * Method for add message to outbox.
     * @param message Represents the sending message.
     */
    public void AddToOutBox(Message message){
        this.outBox.add(message);
    }
    /**
     * Method for checks the inbox.
     */
    public void CheckingInBox(){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            int countOfMessages = this.inBox.size();
            System.out.println("Checking Inbox... ");
            System.out.println("There is/are "+countOfMessages+" "+"in the inbox");
        }
    }
    /**
     * Method for checks the outbox.
     */
    public void CheckingOutBox(){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            int countOfMessages = this.outBox.size();
            System.out.println("Checking Outbox... ");
            System.out.println("There is/are "+countOfMessages+" "+"in the outbox");
        }
    }
    /**
     * Method for list of inbox.
     */
    public void ListOfInbox(){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            System.out.println("Viewing Inbox...");
            int countOfMessages = this.inBox.size();
            if (countOfMessages == 0){
                System.out.println("There is no message");
            }else{
                for (int i= 0; i< countOfMessages;i++){
                    System.out.println("Message ID: "+this.inBox.get(i).getMessageId());
                    System.out.println("From: "+this.inBox.get(i).getSenderAccount().getUserName());
                    System.out.println("To: "+this.inBox.get(i).getReceiverAccount().getUserName());
                    System.out.println("Message: "+this.inBox.get(i).getContent());
                    System.out.println("---");
                }
            }
        }
    }
    /**
     * Method for list of outbox.
     */
    public void ListOfOutBox(){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            System.out.println("Viewing Outbox...");
            int countOfMessages = this.outBox.size();
            if (countOfMessages == 0){
                System.out.println("There is no message");
            }else{
                for (int i= 0; i< countOfMessages;i++){
                    System.out.println("Message ID: "+this.outBox.get(i).getMessageId());
                    System.out.println("From: "+this.outBox.get(i).getSenderAccount().getUserName());
                    System.out.println("To: "+this.outBox.get(i).getReceiverAccount().getUserName());
                    System.out.println("Message: "+this.outBox.get(i).getContent());
                    System.out.println("---");
                }
            }
        }
    }
    /**
     * Method for add a like of one post.
     * @param profile Represents the post owner
     * @param like Represents the object of Like
     */
    public void AddLike(Account profile,Like like){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            int flag =-1;
            for (int i =0; i < profile.getPosts().size(); i++){
                if (profile.getPosts().get(i).getPostId() == like.getPostId()){
                    flag = i;
                }
            }
            if (flag != -1){
                profile.getPosts().get(flag).getLikes().add(like);
            }
            like.setProfile(this);
            System.out.println(this.getUserName()+" liked "+profile.getUserName()+"'s Post");
            actions.add("You liked "+profile.getUserName()+"'s post id: "+like.getPostId());
        }
    }
    /**
     * Method for delete like of one post.
     * @param profile Represents the post owner
     * @param postId Represents the id of unliked post
     */
    public void Unlike(Account profile,int postId){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            int flag =-1;
            for (int i =0; i < profile.getPosts().size(); i++){
                if (profile.getPosts().get(i).getPostId() == postId){
                    flag = i;
                }
            }
            for (int j=0; j<profile.getPosts().get(flag).getLikes().size();j++){
                if (profile.getPosts().get(flag).getLikes().get(j).getProfile().getAccountId() == this.accountId){
                    profile.getPosts().get(flag).getLikes().remove(j);
                }
            }
            System.out.println("Succesfully unlike");
            actions.add("You unliked "+profile.getUserName()+"'s post id: "+postId);
        }
    }
    /**
     * Method for add a comment of one post.
     * @param profile Represents the post owner
     * @param comment Represents the object of Comment
     */
    public void AddComment(Account profile,Comment comment){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            int flag =-1;
            for (int i =0; i < profile.getPosts().size(); i++){
                if (profile.getPosts().get(i).getPostId() == comment.getPostId()){
                    flag = i;
                }
            }
            if (flag != -1){
                profile.getPosts().get(flag).getComments().add(comment);
            }
            comment.setProfile(this);
            System.out.println(this.getUserName()+" left a comment "+profile.getUserName()+"'s Post");
            actions.add("You add a comment "+profile.getUserName()+"'s post id: "+comment.getPostId());
        }
    }
    /**
     * Method for add a comment of one post.
     * @param profile Represents the post owner
     * @param postId Represents the id of uncommented post
     */
    public void Uncomment(Account profile,int postId){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            int flag =-1;
            for (int i =0; i < profile.getPosts().size(); i++){
                if (profile.getPosts().get(i).getPostId() == postId){
                    flag = i;
                }
            }
            for (int j=0; j<profile.getPosts().get(flag).getComments().size();j++){
                if (profile.getPosts().get(flag).getComments().get(j).getProfile().getAccountId() == this.accountId){
                    profile.getPosts().get(flag).getComments().remove(j);
                }
            }
            System.out.println("Succesfully uncomment");
            actions.add("You uncomment "+profile.getUserName()+"'s post id: "+postId);
        }
    }
    /**
     * Shows interactions on a post.
     * @param profile Represents the user to be displayed.
     */
    public void ViewPostInteractions(Account profile){
        int outputControl = 0;
        for (int i=0; i<profile.getPosts().size();i++){
            if (profile.getPosts().get(i) !=null){
                System.out.println("(Post ID: "+profile.getPosts().get(i).getPostId()+") : "+profile.getPosts().get(i).getContent());
                for (int j=0; j< profile.getPosts().get(i).getLikes().size(); j++){
                    if (profile.getPosts().get(i).getLikes().get(j) != null){
                        if (outputControl ==0){
                            System.out.print("The post was liked by the following account(s): ");
                            outputControl++;
                        }
                        System.out.print(profile.getPosts().get(i).getLikes().get(j).getProfile().getUserName()+",");
                    }
                    else {
                        break;
                    }
                }
                System.out.println();
                //
                for (int j=0; j< profile.getPosts().get(i).getComments().size(); j++){
                    if (profile.getPosts().get(i).getComments().get(j) != null){
                        if (outputControl ==0){
                            System.out.print("The post was commented by the following account(s): ");
                            outputControl++;
                        }
                        System.out.print(profile.getPosts().get(i).getComments().get(j).getProfile().getUserName()+"' said '" +profile.getPosts().get(i).getComments().get(j).getContent()+"', ");
                    }
                    else {
                        break;
                    }
                }
                System.out.println();
                //
            }
            else{
                break;
            }
            outputControl = 0;
        }
        actions.add("You viewed post interactions of "+profile.getUserName());
    }
    /**
     * Methods for block a profile.
     * @param profile Represents the user to will be blocked.
     */
    public void Block(Account profile){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            this.blockList.add(profile);
            profile.whoBlockList.add(this);
            if (profile.followers.indexOf(this) != -1){
                profile.followers.remove(this);
                profile.following.remove(this);
                this.following.remove(profile);
            }
            System.out.println(profile.getUserName()+" successfully blocked");
            actions.add("You blocked "+profile.getUserName());
        }
    }
    /**
     * Methods for unblock a profile.
     * @param profile Represents the user to will be blocked.
     */
    public void UnBlock(Account profile){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            this.blockList.remove(profile);
            profile.whoBlockList.remove(this);
            System.out.println(profile.getUserName()+" successfully unblocked");
            actions.add("You unblocked "+profile.getUserName());
        }
    }
    /**
     * Methods for listing user actions.
     */
    public void ListActions(){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }else{
            System.out.println(this.getUserName()+" List of actions:");
            for (int i=0; i<this.actions.size();i++){
                System.out.println(this.actions.get(i));
            }
        }
        System.out.println("---");
    }
    /**
     * Get the account's id.
     */
    public int getAccountId() {
        return accountId;
    }
    /**
     * Set the account's id.
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    /**
     * Get the account's username.
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Set the account's username.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * Get the account's birthdate.
     */
    public String getBirthDate() {
        return birthDate;
    }
    /**
     * Set the account's birthdate.
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    /**
     * Get the account's location.
     */
    public String getLocation() {
        return location;
    }
    /**
     * Set the account's location.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Get the account's login information.
     */
    public boolean isLogin() {
        return isLogin;
    }
    /**
     * Set the account's login information.
     */
    public void setLogin(boolean login) {
        isLogin = login;
    }
    /**
     * Get the account's following accounts.
     */
    public ArrayList<Account> getFollowing() {
        return following;
    }
    /**
     * Set the account's login information.
     */
    public void setFollowing(ArrayList<Account> following) {
        this.following = following;
    }
    /**
     * Get the account's followers.
     */
    public ArrayList<Account> getFollowers() {
        return followers;
    }
    /**
     * Set the account's followers.
     */
    public void setFollowers(ArrayList<Account> followers) {
        this.followers = followers;
    }
    /**
     * Get the account's inbox.
     */
    public ArrayList<Message> getInBox() {
        return inBox;
    }
    /**
     * Set the account's inbox.
     */
    public void setInBox(ArrayList<Message> inBox) {
        this.inBox = inBox;
    }
    /**
     * Get the account's outbox.
     */
    public ArrayList<Message> getOutBox() {
        return outBox;
    }
    /**
     * Set the account's outbox.
     */
    public void setOutBox(ArrayList<Message> outBox) {
        this.outBox = outBox;
    }
    /**
     * Get the account's posts.
     */
    public ArrayList<Post> getPosts() {
        return posts;
    }
    /**
     * Set the account's posts.
     */
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
    /**
     * Get the account's Blocklist.
     */
    public ArrayList<Account> getBlockList() {
        return blockList;
    }
    /**
     * Set the account's Blocklist.
     */
    public void setBlockList(ArrayList<Account> blockList) {
        this.blockList = blockList;
    }
    /**
     * Get the account's who blocked list.
     */
    public ArrayList<Account> getWhoBlockList() {
        return whoBlockList;
    }
    /**
     * Set the account's who blocked list.
     */
    public void setWhoBlockList(ArrayList<Account> whoBlockList) {
        this.whoBlockList = whoBlockList;
    }
    /**
     * Get the account's action list.
     */
    public ArrayList<String> getActions() {
        return actions;
    }
    /**
     * Set the account's action list.
     */
    public void setActions(ArrayList<String> actions) {
        this.actions = actions;
    }
}

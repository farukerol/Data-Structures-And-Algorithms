package homework1;
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
    private Account[] following = new Account[10];
    /**
     * Keeps account's followers.
     */
    private Account[] followers = new Account[10];
    /**
     * Keeps account's inbox.
     */
    private Message[] inBox = new Message[10];
    /**
     * Keeps account's outbox.
     */
    private Message[] outBox = new Message[10];
    /**
     * Keeps account's posts.
     */
    private Post[] posts = new Post[10];
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
        this.posts = new Post[10];
        this.following = new Account[10];
        this.followers = new Account[10];
        this.inBox = new Message[10];
        this.outBox = new Message[10];
        System.out.println("An account with username "+ userName + " has been created.");
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
     * Set the account's id.
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
    public Account[] getFollowing() {
        return following;
    }
    /**
     * Set the account's login information.
     */
    public void setFollowing(Account[] following) {
        this.following = following;
    }
    /**
     * Get the account's followers.
     */
    public Account[] getFollowers() {
        return followers;
    }
    /**
     * Set the account's followers.
     */
    public void setFollowers(Account[] followers) {
        this.followers = followers;
    }
    /**
     * Get the account's inbox.
     */
    public Message[] getInBox() {
        return inBox;
    }
    /**
     * Set the account's inbox.
     */
    public void setInBox(Message[] inBox) {
        this.inBox = inBox;
    }
    /**
     * Get the account's outbox.
     */
    public Message[] getOutBox() {
        return outBox;
    }
    /**
     * Set the account's outbox.
     */
    public void setOutBox(Message[] outBox) {
        this.outBox = outBox;
    }
    /**
     * Get the account's posts.
     */
    public Post[] getPosts() {
        return posts;
    }
    /**
     * Set the account's oposts.
     */
    public void setPosts(Post[] posts) {
        this.posts = posts;
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
     * Shows profile information.
     * @param profile Represents the account whose information is requested to be displayed.
     */
    public void ViewProfile(Account profile){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else {
            System.out.println("Viewing "+profile.getUserName()+" profile...");
            boolean postControl = false;
            int postCount = 0;
            int followerCount = 0;
            int followingCount = 0;
            for (int i = 0; i<profile.getPosts().length;i++){
                if (profile.getPosts()[i] != null){
                    postControl = true;
                    postCount++;
                }
            }

            boolean followersControl = false;
            for (int j = 0; j<profile.getFollowers().length;j++){
                if (profile.getFollowers()[j] != null){
                    followersControl = true;
                    followerCount++;
                }
            }

            boolean followingControl = false;
            for (int k = 0; k<profile.getFollowing().length;k++){
                if (profile.getFollowing()[k] != null){
                    followingControl = true;
                    followingCount++;
                }
            }

            if (profile == null){
                System.out.println("There is no profile");
            }
            else{
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
            for (int i= 0; i<this.posts.length;i++){
                if (this.posts[i]==null){
                    this.posts[i] = SharedPost;
                    this.posts[i].setAccountId(this.accountId);
                    break;
                }
            }
            System.out.println("Post with id number "+ SharedPost.getPostId()+" was successfully shared");
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
            System.out.println("Viewing "+user.getUserName()+" posts...");
            if (user.posts == null && user.posts.length == 0){
                System.out.println(user.getUserName()+" "+"has no post");
            }
            else{
                for (int i =0; i<user.posts.length;i++){
                    if (user.posts[i] != null){
                        System.out.println("(POST ID: "+user.posts[i].getPostId()+")"+" "+ user.getUserName()+": "+user.posts[i].getContent());
                    }
                }
            }
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
            for (int i=0; i<profile.followers.length;i++){
                if (profile.followers[i] == null){
                    profile.followers[i] = this;
                    break;
                }
            }
            for (int j=0; j<profile.following.length;j++){
                if (this.following[j] == null){
                    this.following[j] = profile;
                    break;
                }
            }
            System.out.println(profile.getUserName()+" successfully followed");
        }
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
            for (int i=0; i< profile.followers.length;i++){
                if (profile.followers[i] !=null){
                    System.out.print(profile.followers[i].getUserName()+", ");
                }
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
        else{
            for (int i=0; i< profile.following.length;i++){
                if (profile.following[i] !=null){
                    System.out.print(profile.following[i].getUserName()+", ");
                }
            }
        }
    }
    /**
     * Method for add message to inbox.
     * @param message Represents the incoming message.
     */
    public void AddToInBox(Message message){
        for(int i=0; i<this.inBox.length;i++){
            if (this.inBox[i] == null){
                this.inBox[i] = message;
                break;
            }
        }
    }
    /**
     * Method for add message to outbox.
     * @param message Represents the sending message.
     */
    public void AddToOutBox(Message message){
        for(int i=0; i<this.outBox.length;i++){
            if (this.outBox[i] == null){
                this.outBox[i] = message;
                break;
            }
        }
    }
    /**
     * Method for checks the inbox.
     */
    public void CheckingInBox(){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            int countOfMessages = 0;
            for(int i=0; i<this.inBox.length;i++){
                if (this.inBox[i] != null){
                    countOfMessages++;
                }
            }
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
            int countOfMessages = 0;
            for(int i=0; i<this.outBox.length;i++){
                if (this.outBox[i] != null){
                    countOfMessages++;
                }
            }
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
            int countOfMessages = 0;
            for(int i=0; i<this.inBox.length;i++){
                if (this.inBox[i] == null){
                    break;
                }
                else {
                    System.out.println("Message ID: "+this.inBox[i].getMessageId());
                    System.out.println("From: "+this.inBox[i].getSenderAccount().getUserName());
                    System.out.println("To: "+this.inBox[i].getReceiverAccount().getUserName());
                    System.out.println("Message: "+this.inBox[i].getContent());
                }
                System.out.println("---");
            }
        }
    }
    /**
     * Method for list of outbox.
     */
    public void ListOfOutbox(){
        if (this.isLogin==false){
            System.out.println("You need to be Log In for this operation");
        }
        else{
            System.out.println("Viewing Outbox...");
            int countOfMessages = 0;
            for(int i=0; i<this.outBox.length;i++){
                if (this.outBox[i] == null){
                    break;
                }
                else {
                    System.out.println("Message ID: "+this.outBox[i].getMessageId());
                    System.out.println("From: "+this.outBox[i].getSenderAccount().getUserName());
                    System.out.println("To: "+this.outBox[i].getReceiverAccount().getUserName());
                    System.out.println("Message: "+this.outBox[i].getContent());
                }
            }
            System.out.println("---");
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
            for (int i=0; i<profile.getPosts().length;i++){
                if (profile.getPosts()[i] != null){
                    if (profile.getPosts()[i].getPostId() == like.getPostId()){
                        for (int j=0; j<profile.getPosts()[i].getLikes().length;j++){
                            if (profile.getPosts()[i].getLikes()[j] == null){
                                profile.getPosts()[i].getLikes()[j] = like;
                                like.setProfile(this);
                                break;
                            }
                        }
                    }
                }
                else {
                    break;
                }
            }
            System.out.println(this.getUserName()+" liked "+profile.getUserName()+"'s Post");
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
            int flag=0;
            for (int i=0; i<profile.getPosts().length;i++){
                if (profile.getPosts()[i] !=null){
                    if (profile.getPosts()[i].getPostId() == comment.getPostId()){
                        flag = i;
                        break;
                    }
                }
            }
            for (int j=0; j<profile.getPosts()[flag].getLikes().length;j++){
                if (profile.getPosts()[flag].getComments()[j] == null){
                    profile.getPosts()[flag].getComments()[j] = comment;
                    comment.setProfile(this);
                    break;
                }
            }
            System.out.println(this.getUserName()+" left a comment "+profile.getUserName()+"'s Post");
        }
    }
    /**
     * Shows interactions on a post.
     * @param profile Represents the user to be displayed.
     */
    public void ViewPostInteractions(Account profile){
        int outputControl = 0;
        for (int i=0; i<profile.getPosts().length;i++){
            if (profile.getPosts()[i] !=null){
                System.out.println("(Post ID: "+profile.getPosts()[i].getPostId()+") : "+profile.getPosts()[i].getContent());
                for (int j=0; j< profile.getPosts()[i].getLikes().length; j++){
                    if (profile.getPosts()[i].getLikes()[j] != null){
                        if (outputControl ==0){
                            System.out.print("The post was liked by the following account(s): ");
                            outputControl++;
                        }
                        System.out.print(profile.getPosts()[i].getLikes()[j].getProfile().getUserName()+",");
                    }
                    else {
                        break;
                    }
                }
                System.out.println();
                //
                for (int j=0; j< profile.getPosts()[i].getLikes().length; j++){
                    if (profile.getPosts()[i].getComments()[j] != null){
                        if (outputControl ==0){
                            System.out.print("The post was liked by the following account(s): ");
                            outputControl++;
                        }
                        System.out.print("Comments: '"+profile.getPosts()[i].getComments()[j].getProfile().getUserName()+"' said '" +profile.getPosts()[i].getComments()[j].getContent()+"'");
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

    }

}

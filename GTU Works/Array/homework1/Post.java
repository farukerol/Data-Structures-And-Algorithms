package homework1;
/**
 *
 * Class of Post.
 */
public class Post {
    /**
     * Keeps post's id.
     */
    private int postId;
    /**
     * Keeps post's owner's id.
     */
    private int accountId;
    /**
     * Keeps incoming likes to post.
     */
    private Like[] likes = new Like[10];
    /**
     * Keeps incoming comments to post.
     */
    private Comment[] comments = new Comment[10];
    /**
     * Keeps content of the post.
     */
    private String content;
    /**
     * Constructor of Post Class.
     * @param postId represent the post's id.
     * @param content represent the post's content.
     */
    public Post(int postId,String content){
        this.postId = postId;
        this.content = content;
    }
    /**
     *
     * Get the post's id.
     */
    public int getPostId() {
        return postId;
    }
    /**
     *
     * Set the post's id.
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }
    /**
     *
     * Get the account id.
     */
    public int getAccountId() {
        return accountId;
    }
    /**
     *
     * Set the account id.
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    /**
     *
     * Get the likes.
     */
    public Like[] getLikes() {
        return likes;
    }
    /**
     *
     * Set the likes.
     */
    public void setLikes(Like[] likes) {
        this.likes = likes;
    }
    /**
     *
     * Get the comments.
     */
    public Comment[] getComments() {
        return comments;
    }
    /**
     *
     * Set the comments.
     */
    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
    /**
     *
     * Get the contents.
     */
    public String getContent() {
        return content;
    }
    /**
     *
     * Set the comments.
     */
    public void setContent(String content) {
        this.content = content;
    }
}

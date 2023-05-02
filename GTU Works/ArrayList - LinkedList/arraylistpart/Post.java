package arraylistpart;
import java.util.ArrayList;
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
    private ArrayList<Like> likes = new ArrayList<Like>();
    /**
     * Keeps incoming comments to post.
     */
    private ArrayList<Comment> comments = new ArrayList<Comment>();
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
     * Get the contents.
     */
    public String getContent() {
        return content;
    }
    /**
     *
     * Set the contents.
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     *
     * Get the likes.
     */
    public ArrayList<Like> getLikes() {
        return likes;
    }
    /**
     *
     * Set the likes.
     */
    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }
    /**
     *
     * Get the comments.
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }
    /**
     *
     * Set the comments.
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
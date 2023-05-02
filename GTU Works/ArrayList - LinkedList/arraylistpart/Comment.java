package arraylistpart;
/**
 *
 * Base classes of like interaction.
 * Inherits from Interaction class.
 */
public class Comment extends Interaction{
    /**
     *
     * Keeps content of comment
     */
    private String content;
    /**
     * Constructor of Comment Class.
     * @param content content of comment.
     * @param interactionId interaction id of interactions.
     * @param post represents the commented post.
     */
    public Comment(String content,int interactionId,Post post){
        this.content = content;
        this.setPostId(post.getPostId());
        this.setInteractionId(interactionId);
    }
    /**
     *
     * Get the comment's content.
     */
    public String getContent() {
        return content;
    }
    /**
     *
     * Set the comment's content.
     */
    public void setContent(String content) {
        this.content = content;
    }
}

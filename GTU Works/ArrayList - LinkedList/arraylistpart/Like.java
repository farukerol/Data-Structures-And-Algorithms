package arraylistpart;
/**
 *
 * Base classes of like interaction
 * Inherits from Interaction class
 */
public class Like extends Interaction{
    /**
     * Constructor of Like Class
     * @param interactionId id of interaction's
     * @param post represents the liked post
     */
    public Like(int interactionId,Post post){
        this.setAccountId(post.getAccountId());
        this.setPostId(post.getPostId());
        this.setInteractionId(interactionId);
    }
}
package homework1;
/**
 *
 * Base classes of interactions.
 * Comment and like classes inherit this class.
 */
public abstract class Interaction {
    /**
     *
     * Keeps interaction's id
     */
    private int interactionId;
    /**
     *
     * Keeps the id of the interaction owner
     */
    private int accountId;
    /**
     *
     * The owner of the interaction keeps the id of the post
     */
    private int postId;
    /**
     *
     * Keeps the information of the user who made the interaction
     */
    private Account profile;
    /**
     *
     * Get the interaction id
     */
    public int getInteractionId() {
        return interactionId;
    }
    /**
     *
     * Set the interaction id
     */
    public void setInteractionId(int interactionId) {
        this.interactionId = interactionId;
    }
    /**
     *
     * Get the interaction owner's id
     */
    public int getAccountId() {
        return accountId;
    }
    /**
     *
     * Set the interaction owner's id
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    /**
     *
     * Get the interaction post's id
     */
    public int getPostId() {
        return postId;
    }
    /**
     *
     * Set the interaction post's id
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }
    /**
     *
     * Get the owner of interaction's
     */
    public Account getProfile() {
        return profile;
    }
    /**
     *
     * Set the owner of interaction's
     */
    public void setProfile(Account profile) {
        this.profile = profile;
    }
}

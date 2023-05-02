package linkedlistpart;
/**
 *
 * Class of Message.
 */
public class Message {
    /**
     * Keeps message id.
     */
    private int messageId;
    /**
     * Keeps sender id.
     */
    private int senderId;
    /**
     * Keeps receiver id.
     */
    private int receivedId;
    /**
     * Keeps sender account.
     */
    private Account senderAccount;
    /**
     * Keeps receiver account.
     */
    private Account receiverAccount;
    /**
     * Keeps the message content.
     */
    private String content;
    /**
     * Constructor of Message class.
     * After making the necessary definitions, it checks the follow-up status of the users. It then adds messages to users' inbox and outbox.
     * @param id represent the message's id.
     * @param sender represent the sender account.
     * @param receiver represent the receiver account.
     * @param content represent the message's content.
     */
    public Message(int id,Account sender,Account receiver,String content){
        this.messageId = id;
        this.senderAccount = sender;
        this.receiverAccount = receiver;
        this.content = content;
        this.senderId = sender.getAccountId();
        this.receivedId = receiver.getAccountId();
        boolean isFollowing = false;
        /*
        for (int i=0;i<receiver.getFollowers().size();i++){
                if (receiver.getFollowers().get(i).getAccountId()== sender.getAccountId()){
                    isFollowing = true;
                    break;
                }
        }*/
        if (sender.getBlockList().indexOf(receiver) != -1){
            System.out.println("You blocked this account. You can't sende a message.");
        }else if (receiver.getBlockList().indexOf(sender) != -1){
            System.out.println("This account blocked of you. You can't send a message");
        }else{
            if (receiver.getFollowers().indexOf(sender) != -1){
                isFollowing = true;
            }
            if (isFollowing) {
                sender.AddToOutBox(this);
                receiver.AddToInBox(this);
                System.out.println("Message sent successfully "+"("+sender.getUserName()+" to "+receiver.getUserName()+")");
                sender.getActions().add("You sende a message to "+receiver.getUserName());
            }
            else{
                System.out.println(sender.getUserName()+" Doesn't follow the "+receiver.getUserName());
            }
        }
    }
    /**
     *
     * Get the message's id.
     */
    public int getMessageId() {
        return messageId;
    }
    /**
     *
     * Set the message's id.
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    /**
     *
     * Get the content.
     */
    public String getContent() {
        return content;
    }
    /**
     *
     * Set the content.
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     *
     * Get the sender account.
     */
    public Account getSenderAccount() {
        return senderAccount;
    }
    /**
     *
     * Set the sender account.
     */
    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }
    /**
     *
     * Get the receiver account.
     */
    public Account getReceiverAccount() {
        return receiverAccount;
    }
    /**
     *
     * Set the receiver account.
     */
    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }
    /**
     *
     * Get the sender id.
     */
    public int getSenderId() {
        return senderId;
    }
    /**
     *
     * Set the sender id.
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
    /**
     *
     * get the receiver id.
     */
    public int getReceivedId() {
        return receivedId;
    }
    /**
     *
     * set the receiver id.
     */
    public void setReceivedId(int receivedId) {
        this.receivedId = receivedId;
    }
}


import java.util.Stack;
/**
 * Security System Class. It has methods' and data fields.
 */
public class SecuritySystem {
    /**
     * Keeps username.
     */
    private String username;
    /**
     * Keeps password1.
     */
    private String password1;
    /**
     * Constructor of this method.
     * @param username represent the system user's username.
     * @param password1 represent the system user's password1.
     */
    public SecuritySystem(String username,String password1){
        this.username = username;
        this.password1 = password1;
    }
    /**
     * Get Usernames.
     */
    public String getUsername() {
        return username;
    }
    /**
     * Set Usernames.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Get Password1.
     */
    public String getPassword1() {
        return password1;
    }
    /**
     * Set Password1.
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    /**
     * Method for control of username valid or not.
     *  @param username represent the system user's username
     */
    public boolean checkIfValidUsername(String username){
        if (username.length() == 0){
            System.out.println("Your Username is not valid(Length is 0).Try again...");
            return false;
        }
        if(username.length() == 1 && Character.isLetter(username.charAt(0))){
            return true;
        }
        if (username.length() > 1 && Character.isLetter(username.charAt(0))){
            return checkIfValidUsername(username.substring(1));
        }
        System.out.println("Your Username is not valid(Should must be only letter).Try again...");
        return  false;
    }
    /**
     * Method for checks if the string password contains at least one letter of the username.
     *  @param username represent the system user's username
     *  @param password1 represent the system user's password1
     */
    public boolean containsUserNameSpirit(String username, String password1){
        username = clearBrackets(username);
        password1 = clearBrackets(password1);
        Stack<Character> passwordStack = new Stack<>();
        Stack<Character> controlStack = new Stack<>();

        for (int i=0;i<password1.length();i++){
            passwordStack.push(password1.charAt(i));
        }

        for (int j=0; j<username.length(); j++){
            for (int z=0;z<password1.length();z++){
                if (passwordStack.peek() != username.charAt(j)){
                    controlStack.push(passwordStack.pop());
                }
                else{
                    return true;
                }
            }
            for (int t = 0; t<password1.length();t++){
                passwordStack.push(controlStack.pop());
            }
        }
        System.out.println("Your password doesn't have letter of your username.Try again...");
        return false;
    }
    /**
     * Method for considers two brackets to be matching if the first bracket is an open bracket.
     *  @param password1 represent the system user's password1
     */
    public boolean isBalancedPassword(String password1){

        Stack<Character> controlStack = new Stack<>();

        for (int i = 0; i< password1.length();i++){
            char c = password1.charAt(i);
            if (controlStack.isEmpty() && (password1.charAt(i) == '}' || password1.charAt(i) == ']'
                    || password1.charAt(i) == ')')){
                System.out.println("Your password is not balanced password.Try again...");
                return false;
            }
            else if (password1.charAt(i) == '{' || password1.charAt(i) == '[' || password1.charAt(i) == '('){
                controlStack.push(password1.charAt(i));
            }
            else if (password1.charAt(i) == '}' || password1.charAt(i) == ']' || password1.charAt(i) == ')'){
                if(!controlStack.isEmpty()){
                    if ((controlStack.peek() == '{' && password1.charAt(i) == '}') ||
                            (controlStack.peek() == '[' && password1.charAt(i) == ']') ||
                            (controlStack.peek() == '(' && password1.charAt(i) == ')'))
                    {
                        controlStack.pop();
                    }
                    else{
                        System.out.println("Your password is not balanced password.Try again...");
                        return false;
                    }
                }
            }
        }
        if (controlStack.empty()){
            return true;
        }
        System.out.println("Your password is not balanced password.Try again...");
        return false;
    }
    /**
     * Method for In the given string sequence, the function considers if it is possible to obtain a palindrome by rearranging the letters in the string.
     *  @param password1 represent the system user's password1
     *  @param firstposition represent the first index to compare
     *  @param secondPosition represent the second index to compare
     */
    public boolean isPalindromePossible(String password1,int firstposition,int secondPosition){
        password1 = clearBrackets(password1);
        if (password1.length() % 2 == 1){
            if (password1.length() == 1){
                return true;
            }
            if (password1.length() == 3){
                if ((password1.charAt(0) == password1.charAt(1)) || (password1.charAt(1) == password1.charAt(2)) ||
                        (password1.charAt(0) == password1.charAt(2))){
                    return true;
                }
                else{
                    System.out.println("Palindrome is not possible for your password.Try again...");
                    return false;
                }
            }
            if (secondPosition == password1.length()){
                return isPalindromePossible(password1.substring(1),0,1);
            }
            if (password1.charAt(firstposition) == password1.charAt(secondPosition)){
                StringBuilder stringBuilder = new StringBuilder(password1);
                stringBuilder.deleteCharAt(firstposition);
                stringBuilder.deleteCharAt(secondPosition-1);
                password1 = stringBuilder.toString();
                return isPalindromePossible(password1,0,1);
            }
            if (password1.charAt(0) != password1.charAt(secondPosition)){
                return isPalindromePossible(password1,0,secondPosition+1);
            }
        }
        if (password1.length() % 2 == 0){
            if (password1.length() == 2){
                if (password1.charAt(0) == password1.charAt(1))
                    return true;
                else
                    System.out.println("Palindrome is not possible for your password.Try again...");
                    return false;
            }
            if (password1.charAt(firstposition) == password1.charAt(secondPosition)){
                StringBuilder stringBuilder = new StringBuilder(password1);
                stringBuilder.deleteCharAt(firstposition);
                stringBuilder.deleteCharAt(secondPosition-1);
                password1 = stringBuilder.toString();
                return isPalindromePossible(password1,0,1);
            }
            if (password1.charAt(0) != password1.charAt(secondPosition)){
                return isPalindromePossible(password1,0,secondPosition+1);
            }
            System.out.println("Palindrome is not possible for your password.Try again...");
            return false;
        }
        System.out.println("Palindrome is not possible for your password.Try again...");
        return false;
    }
    /**
     * Helper method for testing and control the is password has two bracket and password's length
     */
    public void SecurityControl(){
        if (!isHasTwoBracket(this.password1)){
            System.out.println("Your password should consist at least 2 brackets");
        }
        else if(this.password1.length() < 8){
            System.out.println("Your password should at least 8 characters");
        }
        else{
            if (checkIfValidUsername(this.username) && containsUserNameSpirit(this.username,this.password1) && isBalancedPassword(this.password1)
                    && isPalindromePossible(this.password1,0,1)){
                System.out.println("The username and passwords are valid. The door is opening, please wait...");
            }
        }
    }
    /**
     * Helper method for cleaning brackets
     * @param password represent the system user's password
     */
    public static String clearBrackets(String password){
        password = password.replace("{","");
        password = password.replace("[","");
        password = password.replace("(","");
        password = password.replace("}","");
        password = password.replace("]","");
        password = password.replace(")","");
        return password;
    }
    /**
     * Helper method count the brackets and return true or false
     * @param password represent the system user's password
     */
    public boolean isHasTwoBracket(String password){
        int count = 0;
        for (int i= 0; i<password.length();i++){
            if (password.charAt(i) == '{' || password.charAt(i) == '[' || password.charAt(i) == '(' ||
                    password.charAt(i) == '}'|| password.charAt(i) == ']'|| password.charAt(i) == ')'){
                count++;
            }
        }
        if (count < 2){
            return false;
        }else{
            return true;
        }
    }

}

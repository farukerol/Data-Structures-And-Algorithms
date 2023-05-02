package homework1;
/**
 *
 * Test Class for Scenario 1.
 */
public class TestClass1 {
    public static void main(String[] args) {
        System.out.println("--Scenario 1 Star---");
        System.out.println("Step 1... Creating Accounts");
        Account gizemsungu = new Account(1,"gizemsungu","01.01.1999","Istanbul",false);
        Account sibelgulmez = new Account(2,"sibelgulmez","02.02.1999","Bursa",false);
        Account gokhankaya = new Account(3,"gokhankaya","03.03.1999","Ankara",false);
        System.out.println("---");

        System.out.println("Step 2...");
        sibelgulmez.LogIn();
        System.out.println("Step 3...");
        Post Post1 = new Post(1,"I like Java");
        Post Post2 = new Post(2,"Java the coffee...");
        sibelgulmez.AddPost(Post1);
        sibelgulmez.AddPost(Post2);
        System.out.println("---");

        System.out.println("Step Error Situation...");
        Post Post3 = new Post(3,"Gebze Technical University");
        gizemsungu.AddPost(Post3);
        System.out.println("---");

        System.out.println("Step 4...");
        sibelgulmez.Follow(gizemsungu);
        sibelgulmez.Follow(gokhankaya);
        System.out.println("---");

        System.out.println("Step 5...");
        sibelgulmez.LogOut();

        System.out.println("Step 6...");
        gokhankaya.LogIn();

        System.out.println("Step 7...");
        gokhankaya.ViewProfile(sibelgulmez);
        System.out.println("---");

        System.out.println("Step 8...");
        gokhankaya.ViewPosts(sibelgulmez);
        System.out.println("---");

        System.out.println("Step 9...");
        Like like1 = new Like(1,Post1);
        gokhankaya.AddLike(sibelgulmez,like1);
        System.out.println("---");

        System.out.println("Step 10...");
        Comment comment1 = new Comment("me too!",2,Post1);
        gokhankaya.AddComment(sibelgulmez,comment1);
        System.out.println("---");

        System.out.println("Step- Error Situtation...");
        Message msg1 = new Message(1,gokhankaya,gizemsungu,"This homework is too easy!");
        System.out.println();
        System.out.println("---");

        System.out.println("Step 11...");
        gokhankaya.Follow(gizemsungu);
        gokhankaya.Follow(sibelgulmez);

        System.out.println("Step 12...");
        Message msg2 = new Message(2,gokhankaya,gizemsungu,"This homework is too easy!");
        System.out.println("---");

        System.out.println("Step 13...");
        gokhankaya.LogOut();

        System.out.println("Step 14...");
        gizemsungu.LogIn();

        System.out.println("Step 15...");
        gizemsungu.CheckingOutBox();
        System.out.println("---");

        System.out.println("Step 16...");
        gizemsungu.CheckingInBox();
        System.out.println("---");

        System.out.println("Step 17...");
        gizemsungu.ListOfInbox();
        System.out.println("---");

        System.out.println("Step 18...");
        gizemsungu.ViewProfile(sibelgulmez);
        System.out.println("---");

        System.out.println("Step 19...");
        gizemsungu.ViewPosts(sibelgulmez);

        System.out.println("---");
        System.out.println("Step 20...");
        gizemsungu.ViewPostInteractions(sibelgulmez);
        System.out.println("---");

        System.out.println("Step 21...");
        Like like2 = new Like(3,Post2);
        gizemsungu.AddLike(sibelgulmez,like2);
        Like like3 = new Like(4,Post1);
        gizemsungu.AddLike(sibelgulmez,like3);

        System.out.println("Step 22...");
        gizemsungu.ViewPostInteractions(sibelgulmez);
        gizemsungu.LogOut();
        System.out.println("--Scenario 1 End---");
    }
}

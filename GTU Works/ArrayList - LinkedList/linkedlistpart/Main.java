package linkedlistpart;
public class Main {
    public static void main(String[] args) {
        long StartTimeScenario1 = System.nanoTime();
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
        System.out.println("---");
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
        long EndTimeScenario1 = System.nanoTime();
        System.out.println();
        System.out.println();

        System.out.println("--Scenario 2 Start---");
        long StartTimeScenario2 = System.nanoTime();
        System.out.println("---");
        System.out.println("---Scenario 2.1 Start---");
        gizemsungu.LogIn();
        Post Post4 = new Post(4,"Today is rainy");
        gizemsungu.AddPost(Post4);
        Post Post5 = new Post(5,"There is school tomorrow");
        gizemsungu.AddPost(Post5);
        gizemsungu.LogOut();
        System.out.println("---Scenario 2.1 End---");

        System.out.println("---Scenario 2.2 Start---");
        sibelgulmez.LogIn();
        sibelgulmez.ViewProfile(gizemsungu);
        System.out.println("-----");
        Like like4 = new Like(5,Post4);
        sibelgulmez.AddLike(gizemsungu,like4);
        sibelgulmez.LogOut();
        System.out.println();
        System.out.println("---Scenario 2.2 End---");

        System.out.println("---Scenario 2.3 Start---");
        gokhankaya.LogIn();
        Comment comment2 = new Comment("Nice!",6,Post5);
        gokhankaya.AddComment(gizemsungu,comment2);
        Message msg3 = new Message(3,gokhankaya,gizemsungu,"Hello!");
        gokhankaya.LogOut();
        System.out.println("---Scenario 2.3 End---");

        System.out.println("---Scenario 2.4 Start---");
        gizemsungu.LogIn();
        gizemsungu.ViewProfile(gizemsungu);
        System.out.println("---");
        gizemsungu.CheckingInBox();
        System.out.println("---");
        gizemsungu.ListOfInbox();
        gizemsungu.LogOut();
        System.out.println("---Scenario 2 End---");
        long EndTimeScenario2 = System.nanoTime();
        System.out.println("---");
        System.out.println("---Scenario 3 Start---");
        long StartTimeScenario3 = System.nanoTime();
        System.out.println("---");
        System.out.println("---Scenario 3.1 Start---");
        gizemsungu.LogIn();
        gizemsungu.Block(sibelgulmez);
        gizemsungu.LogOut();
        System.out.println("---Scenario 3.1 End---");
        System.out.println("---Scenario 3.2 Start---");
        sibelgulmez.LogIn();
        sibelgulmez.ViewProfile(gizemsungu);
        Message msg4 = new Message(4,sibelgulmez,gizemsungu,"Naber Nasılsın");
        System.out.println("---Scenario 3 End---");
        System.out.println("---");
        long EndTimeScenario3 = System.nanoTime();
        System.out.println("---Scenario 4 Start---");
        long StartTimeScenario4 = System.nanoTime();
        System.out.println("---");
        Account omerfaruk = new Account(4,"omerfaruk","01.01.1999","Istanbul",false);
        Account mertkesici = new Account(5,"mertkesici","02.02.1999","Bursa",false);
        Account ayseyılmaz = new Account(6,"ayseyılmaz","03.03.1999","Giresun",false);
        Account ahmetcan = new Account(7,"ahmetcan","05.05.1999","İzmir",false);
        Account elifgenc = new Account(8,"elifgenc","06.06.1999","Bursa",false);
        Account meteozer = new Account(9,"meteozer","07.07.1999","Ankara",false);
        Account cansukorkmaz = new Account(10,"cansukorkmaz","08.08.1999","Istanbul",false);


        omerfaruk.LogIn();
        omerfaruk.Follow(gokhankaya);
        omerfaruk.Follow(mertkesici);
        omerfaruk.Follow(ayseyılmaz);
        omerfaruk.Follow(cansukorkmaz);
        Post Post6 = new Post(6,"I am Fenerbahce fan");
        omerfaruk.AddPost(Post6);
        omerfaruk.LogOut();

        mertkesici.LogIn();
        mertkesici.Follow(gizemsungu);
        mertkesici.Follow(elifgenc);
        mertkesici.Follow(meteozer);
        mertkesici.Follow(cansukorkmaz);
        mertkesici.Follow(omerfaruk);
        Post Post7 = new Post(7,"Istanbul is the best");
        mertkesici.AddPost(Post7);
        mertkesici.LogOut();

        ahmetcan.LogIn();
        ahmetcan.Follow(omerfaruk);
        ahmetcan.Follow(gizemsungu);
        ahmetcan.Follow(meteozer);
        ahmetcan.Follow(cansukorkmaz);
        ahmetcan.Follow(ayseyılmaz);
        ahmetcan.LogOut();

        ayseyılmaz.LogIn();
        Post Post8 = new Post(8,"Bad news travels fast");
        Post Post9 = new Post(9,"I will watch LOTR");
        ayseyılmaz.AddPost(Post8);
        ayseyılmaz.AddPost(Post9);
        ayseyılmaz.Follow(sibelgulmez);
        ayseyılmaz.Follow(omerfaruk);
        ayseyılmaz.Follow(meteozer);
        ayseyılmaz.Follow(mertkesici);
        ayseyılmaz.Follow(elifgenc);
        ayseyılmaz.LogOut();

        elifgenc.LogIn();
        elifgenc.Follow(gizemsungu);
        elifgenc.Follow(sibelgulmez);
        elifgenc.Follow(gokhankaya);
        elifgenc.Follow(mertkesici);
        elifgenc.Follow(meteozer);
        elifgenc.LogOut();

        meteozer.LogIn();
        meteozer.Follow(omerfaruk);
        meteozer.Follow(mertkesici);
        meteozer.Follow(cansukorkmaz);
        meteozer.Follow(elifgenc);
        Post Post10 = new Post(10,"As you sow, so you shall reap");
        meteozer.AddPost(Post10);
        meteozer.LogOut();

        cansukorkmaz.LogIn();
        cansukorkmaz.Follow(omerfaruk);
        cansukorkmaz.Follow(gizemsungu);
        cansukorkmaz.Follow(sibelgulmez);
        cansukorkmaz.Follow(gokhankaya);
        cansukorkmaz.Follow(mertkesici);
        cansukorkmaz.Follow(ayseyılmaz);
        cansukorkmaz.Follow(meteozer);
        Post Post11 = new Post(11,"I want to sleep");
        Post Post12 = new Post(12,"I am tired");
        cansukorkmaz.AddPost(Post11);
        cansukorkmaz.AddPost(Post12);
        cansukorkmaz.LogOut();

        System.out.println("---Scenario 4.1 Start---");
        cansukorkmaz.LogIn();
        cansukorkmaz.ViewProfile(mertkesici);
        System.out.println("---");
        cansukorkmaz.UnFollow(mertkesici);
        System.out.println("---");
        cansukorkmaz.ViewProfile(mertkesici);
        System.out.println("---");
        cansukorkmaz.ListActions();
        cansukorkmaz.LogOut();
        System.out.println("---Scenario 4.1 End---");
        System.out.println();

        System.out.println("---Scenario 4.2 Start---");
        elifgenc.LogIn();
        elifgenc.ViewProfile(elifgenc);
        System.out.println("---");
        elifgenc.ViewProfile(meteozer);
        System.out.println("---");
        elifgenc.Block(meteozer);
        elifgenc.ViewProfile(meteozer);
        System.out.println("---");
        elifgenc.LogOut();
        omerfaruk.LogIn();
        omerfaruk.ViewProfile(meteozer);
        System.out.println("---");
        omerfaruk.LogOut();
        elifgenc.LogIn();
        elifgenc.UnBlock(meteozer);
        elifgenc.ViewProfile(meteozer);
        System.out.println("---");
        elifgenc.LogOut();
        System.out.println("---Scenario 4.2 End---");

        System.out.println("---Scenario 4.3 Start---");
        omerfaruk.LogIn();
        omerfaruk.ViewProfile(cansukorkmaz);
        System.out.println("---");
        omerfaruk.ViewPosts(cansukorkmaz);
        System.out.println("---");
        Like like5 = new Like(8,Post11);
        omerfaruk.AddLike(cansukorkmaz,like5);
        System.out.println("---");
        omerfaruk.LogOut();
        mertkesici.LogIn();
        mertkesici.ViewProfile(cansukorkmaz);
        mertkesici.ViewPosts(cansukorkmaz);
        System.out.println("---");
        Like like6 = new Like(9,Post11);
        mertkesici.AddLike(cansukorkmaz,like6);
        mertkesici.ViewPostInteractions(cansukorkmaz);
        mertkesici.LogOut();
        omerfaruk.LogIn();
        omerfaruk.ViewProfile(cansukorkmaz);
        System.out.println("---");
        omerfaruk.ViewPosts(cansukorkmaz);
        System.out.println("---");
        omerfaruk.Unlike(cansukorkmaz,11);
        omerfaruk.ViewPostInteractions(cansukorkmaz);
        omerfaruk.LogOut();
        System.out.println("---Scenario 4.3 End---");

        System.out.println("---Scenario 4.4 Start---");
        omerfaruk.LogIn();
        ahmetcan.ViewProfile(ayseyılmaz);
        System.out.println("---");
        ahmetcan.ViewPosts(ayseyılmaz);
        System.out.println("---");
        Comment comment3 = new Comment("enjoy watching",10,Post9);
        omerfaruk.AddComment(ayseyılmaz,comment3);
        omerfaruk.LogOut();
        ahmetcan.LogIn();
        ahmetcan.ViewProfile(ayseyılmaz);
        System.out.println("---");
        ahmetcan.ViewPosts(ayseyılmaz);
        System.out.println("---");
        Comment comment4 = new Comment("good movie",11,Post9);
        Like like7 = new Like(12,Post9);
        ahmetcan.AddLike(ayseyılmaz,like7);
        ahmetcan.AddComment(ayseyılmaz,comment4);
        Comment comment5 = new Comment("right",13,Post8);
        ahmetcan.AddComment(ayseyılmaz,comment5);
        ahmetcan.ViewPostInteractions(ayseyılmaz);
        ahmetcan.Uncomment(ayseyılmaz,9);
        System.out.println("---");
        ahmetcan.ViewPostInteractions(ayseyılmaz);
        System.out.println("---");
        System.out.println("---");
        System.out.println("---Scenario 4.4 End---");
        long EndTimeScenario4 = System.nanoTime();

        long scenario1TotalTime = EndTimeScenario1 - StartTimeScenario1;
        long scenario2TotalTime = EndTimeScenario2 - StartTimeScenario2;
        long scenario3TotalTime = EndTimeScenario3 - StartTimeScenario3;
        long scenario4TotalTime = EndTimeScenario4 - StartTimeScenario4;
        System.out.println("Experimental Time - Scenario 1:"+scenario1TotalTime/1000);
        System.out.println("Experimental Time - Scenario 2:"+scenario2TotalTime/1000);
        System.out.println("Experimental Time - Scenario 3:"+scenario3TotalTime/1000);
        System.out.println("Experimental Time - Scenario 4:"+scenario4TotalTime/1000);
    }
}
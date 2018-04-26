package pl.drodak.user.experience;

import pl.drodak.utils.Strings;
import pl.drodak.utils.Utils;

public class HelloWorld {
    void printOutHelloWorld(){
        System.out.println(Strings.HELLO_WORLD_MENU);
        return;
    }

    String userInputHelloWorld(){
        Utils utils = new Utils();
        return utils.userInput();
    }
}

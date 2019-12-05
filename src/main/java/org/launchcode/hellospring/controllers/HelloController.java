package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handling request at path/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")

    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=LaunchCode (Query parameter)
//    @PostMapping("hello")
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String value) {
//        if ( value == "french") {
//            return "Bonjour, " + name + "!";
//        }
//        else if (value == "german") {
//            return "Hallo, " + name + "!";
//        }
//        else if (value == "english"){
//            return "Hello, " + name + "!";
//        }
//        else if (value == "italian"){
//            return "Ciao, " + name + "!";
//        }
//        else {
//            return "Hola, " + name + "!";
//        }
//    }

    // handles requests of the form /hello/LaunchCode (Path parameter)
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='createMessage' method='post'>" + //submit a request to/createMessage
                            "<input type='text' name='name'>" +
                            "<select id='language' name='language'>" +
                                "<option value='french'> French </option>" +
                                "<option value='german'> German </option>" +
                                "<option value='english'> English </option>" +
                                "<option value='italian'> Italian </option>" +
                                "<option value='spanish'> Spanish </option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @PostMapping("createMessage")
    public static String createMessage(String name,  String language) {
        String s = "";
        if ( language.equals("french")) {
            s = "Bonjour, " + name + "!";
        }
        else if ( language.equals("german")) {
            s = "Hallo, " + name + "!";
        }
        else if ( language.equals("english")){
            s = "Hello, " + name + "!";
        }
        else if ( language.equals("italian")){
            s = "Ciao, " + name + "!";
        }
        else if (language.equals("spanish")){
            s = "Hola, " + name + "!";
        }
        return s;
    }


}

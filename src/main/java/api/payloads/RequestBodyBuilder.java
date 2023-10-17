package api.payloads;

public class RequestBodyBuilder {
    public static String buildAddBookRequestBody(String userId, String isbnNo) {
        return "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + isbnNo + "\"\n" +
                "    }\n" +
                "  ]\n" + "}";
    }

   public static String allBookAPIResponse = "{\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"isbn\": \"9781449325862\",\n" +
            "      \"title\": \"Git Pocket Guide\",\n" +
            "      \"subTitle\": \"A Working Introduction\",\n" +
            "      \"author\": \"Richard E. Silverman\",\n" +
            "      \"publish_date\": \"2020-06-04T08:48:39.000Z\",\n" +
            "      \"publisher\": \"O'Reilly Media\",\n" +
            "      \"pages\": 234,\n" +
            "      \"description\": \"This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp\",\n" +
            "      \"website\": \"http://chimera.labs.oreilly.com/books/1230000000561/index.html\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"isbn\": \"9781449331818\",\n" +
            "      \"title\": \"Learning JavaScript Design Patterns\",\n" +
            "      \"subTitle\": \"A JavaScript and jQuery Developer's Guide\",\n" +
            "      \"author\": \"Addy Osmani\",\n" +
            "      \"publish_date\": \"2020-06-04T09:11:40.000Z\",\n" +
            "      \"publisher\": \"O'Reilly Media\",\n" +
            "      \"pages\": 254,\n" +
            "      \"description\": \"With Learning JavaScript Design Patterns, you'll learn how to write beautiful, structured, and maintainable JavaScript by applying classical and modern design patterns to the language. If you want to keep your code efficient, more manageable, and up-to-da\",\n" +
            "      \"website\": \"http://www.addyosmani.com/resources/essentialjsdesignpatterns/book/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"isbn\": \"9781449337711\",\n" +
            "      \"title\": \"Designing Evolvable Web APIs with ASP.NET\",\n" +
            "      \"subTitle\": \"Harnessing the Power of the Web\",\n" +
            "      \"author\": \"Glenn Block et al.\",\n" +
            "      \"publish_date\": \"2020-06-04T09:12:43.000Z\",\n" +
            "      \"publisher\": \"O'Reilly Media\",\n" +
            "      \"pages\": 238,\n" +
            "      \"description\": \"Design and build Web APIs for a broad range of clients—including browsers and mobile devices—that can adapt to change over time. This practical, hands-on guide takes you through the theory and tools you need to build evolvable HTTP services with Microsoft\",\n" +
            "      \"website\": \"http://chimera.labs.oreilly.com/books/1234000001708/index.html\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"isbn\": \"9781449365035\",\n" +
            "      \"title\": \"Speaking JavaScript\",\n" +
            "      \"subTitle\": \"An In-Depth Guide for Programmers\",\n" +
            "      \"author\": \"Axel Rauschmayer\",\n" +
            "      \"publish_date\": \"2014-02-01T00:00:00.000Z\",\n" +
            "      \"publisher\": \"O'Reilly Media\",\n" +
            "      \"pages\": 460,\n" +
            "      \"description\": \"Like it or not, JavaScript is everywhere these days-from browser to server to mobile-and now you, too, need to learn the language or dive deeper than you have. This concise book guides you into and through JavaScript, written by a veteran programmer who o\",\n" +
            "      \"website\": \"http://speakingjs.com/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"isbn\": \"9781491904244\",\n" +
            "      \"title\": \"You Don't Know JS\",\n" +
            "      \"subTitle\": \"ES6 & Beyond\",\n" +
            "      \"author\": \"Kyle Simpson\",\n" +
            "      \"publish_date\": \"2015-12-27T00:00:00.000Z\",\n" +
            "      \"publisher\": \"O'Reilly Media\",\n" +
            "      \"pages\": 278,\n" +
            "      \"description\": \"No matter how much experience you have with JavaScript, odds are you don’t fully understand the language. As part of the \\\\\\\"You Don’t Know JS\\\\\\\" series, this compact guide focuses on new features available in ECMAScript 6 (ES6), the latest version of the st\",\n" +
            "      \"website\": \"https://github.com/getify/You-Dont-Know-JS/tree/master/es6%20&%20beyond\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"isbn\": \"9781491950296\",\n" +
            "      \"title\": \"Programming JavaScript Applications\",\n" +
            "      \"subTitle\": \"Robust Web Architecture with Node, HTML5, and Modern JS Libraries\",\n" +
            "      \"author\": \"Eric Elliott\",\n" +
            "      \"publish_date\": \"2014-07-01T00:00:00.000Z\",\n" +
            "      \"publisher\": \"O'Reilly Media\",\n" +
            "      \"pages\": 254,\n" +
            "      \"description\": \"Take advantage of JavaScript's power to build robust web-scale or enterprise applications that are easy to extend and maintain. By applying the design patterns outlined in this practical book, experienced JavaScript developers will learn how to write flex\",\n" +
            "      \"website\": \"http://chimera.labs.oreilly.com/books/1234000000262/index.html\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"isbn\": \"9781593275846\",\n" +
            "      \"title\": \"Eloquent JavaScript, Second Edition\",\n" +
            "      \"subTitle\": \"A Modern Introduction to Programming\",\n" +
            "      \"author\": \"Marijn Haverbeke\",\n" +
            "      \"publish_date\": \"2014-12-14T00:00:00.000Z\",\n" +
            "      \"publisher\": \"No Starch Press\",\n" +
            "      \"pages\": 472,\n" +
            "      \"description\": \"JavaScript lies at the heart of almost every modern web application, from social apps to the newest browser-based games. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale \",\n" +
            "      \"website\": \"http://eloquentjavascript.net/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"isbn\": \"9781593277574\",\n" +
            "      \"title\": \"Understanding ECMAScript 6\",\n" +
            "      \"subTitle\": \"The Definitive Guide for JavaScript Developers\",\n" +
            "      \"author\": \"Nicholas C. Zakas\",\n" +
            "      \"publish_date\": \"2016-09-03T00:00:00.000Z\",\n" +
            "      \"publisher\": \"No Starch Press\",\n" +
            "      \"pages\": 352,\n" +
            "      \"description\": \"ECMAScript 6 represents the biggest update to the core of JavaScript in the history of the language. In Understanding ECMAScript 6, expert developer Nicholas C. Zakas provides a complete guide to the object types, syntax, and other exciting changes that E\",\n" +
            "      \"website\": \"https://leanpub.com/understandinges6/read\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}





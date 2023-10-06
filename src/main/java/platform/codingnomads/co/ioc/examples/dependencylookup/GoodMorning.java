package platform.codingnomads.co.ioc.examples.dependencylookup;

public class GoodMorning implements GreetingProvider{

    @Override
    public String getGreeting() {
        return "Good morning. Always plan your day the day before.";
    }
}

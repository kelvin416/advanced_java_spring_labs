package platform.codingnomads.co.corespring.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.lab.complete.CoreLabConfig;

public class CoreLabApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MoviesConfig.class);

        Animation animation = ctx.getBean(Animation.class);

        System.out.println("Here is some awesome animation to watch: " +
                animation.getMovieName() +" which was released in year: " + animation.getMovieYear());

        String[] scifiMovies = ctx.getBeanNamesForType(ScienceFiction.class);
        for (String scifiMovie : scifiMovies) {
            System.out.println("You are now watching science fiction movie: " + ctx.getBean(scifiMovie, ScienceFiction.class)
                    .getMovie() + " released in year: " + ctx.getBean(scifiMovie, ScienceFiction.class).getYear());
        }

        System.out.println("That was a some epic bloc buster shows");
    }

}

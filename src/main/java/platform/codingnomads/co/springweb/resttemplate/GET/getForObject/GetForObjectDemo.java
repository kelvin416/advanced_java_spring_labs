package platform.codingnomads.co.springweb.resttemplate.GET.getForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import platform.codingnomads.co.springweb.resttemplate.GET.models.QuoteTemplate;

import java.util.Arrays;

@SpringBootApplication
public class GetForObjectDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForObjectDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            QuoteTemplate[] randomQuote;
            randomQuote = restTemplate.getForObject("https://zenquotes.io/api/random/", QuoteTemplate[].class);
            System.out.println(Arrays.toString(randomQuote));

            // submit more requests here

            //random excuse
            ExcuseTemplate [] randomExcuse;
            randomExcuse = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse", ExcuseTemplate[].class);
            System.out.println(Arrays.toString(randomExcuse));

            //specific excuse with id
//            ExcuseTemplate [] specificExcuse;
//            specificExcuse = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/id/101", ExcuseTemplate[].class);
//            System.out.println(Arrays.toString(specificExcuse));

            //random n excuses
            ExcuseTemplate [] randomExcuses;
            randomExcuses = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/5", ExcuseTemplate[].class);
            System.out.println(Arrays.toString(randomExcuses));

            //random excuse for specific category
            ExcuseTemplate [] excuseByCategory;
            excuseByCategory = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/gaming", ExcuseTemplate[].class);
            System.out.println(Arrays.toString(excuseByCategory));

            //n random excuses for category
            ExcuseTemplate [] excusesByCategory;
            excusesByCategory = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/party/2", ExcuseTemplate[].class);
            System.out.println(Arrays.toString(excusesByCategory));
            
//            CodingNomadsTasksApiResponse response =
//                    restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/5",
//                            CodingNomadsTasksApiResponse.class);
//
//            System.out.println(response.toString());

        };
    }
}

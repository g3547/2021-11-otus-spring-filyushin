package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class QuestionTask {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(QuestionTask.class, args);
//        LocalizationService localizationService = run.getBean(LocalizationService.class);
//        MessageSource msg = run.getBean(MessageSource.class);
//        String message = msg.getMessage("strings.hello",
//                new String[]{"ddk"}, Locale.forLanguageTag("ru-Ru"));
//        System.out.println(message);
//        System.out.println(localizationService.getLocalString("strings.hello","ddd"));
//
//        String localString = localizationService.getLocalString("fill-in.name");
//        System.out.println(localString);

    }

    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();

        messageResource.setBasename("classpath:/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }
}

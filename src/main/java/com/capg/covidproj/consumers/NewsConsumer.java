package com.capg.covidproj.consumers;

import com.capg.covidproj.CovidprojApplication;
import com.capg.covidproj.modal.Articles;
import com.capg.covidproj.modal.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Component
public class NewsConsumer {

    private static final Logger log = LoggerFactory.getLogger(NewsConsumer.class);
    RestTemplate builder = new RestTemplateBuilder().build();

    public ArrayList<Articles> retriveArticles(){

        News news = builder.getForObject(
                "https://newsapi.org/v2/everything?q=corona&apiKey=96506bcfa27a4dcda1cbed20cc7f1e7d", News.class);

        log.info(news.toString());

        return news.getArticles();
    }

}

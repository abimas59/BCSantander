package britt.desafio_publicando.domain.model;

import java.util.List;
import jakarta.persistence.*;

import java.awt.*;

@Entity(name="tb_user") //para criar criar o nome da tabela
public class User {
    @Id //informa q esse elemento vai ser o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // será gerado automaticanent
    private Long id;

     // caso queira limitar a coluna
    private String name;

    @OneToOne(cascade = CascadeType.ALL) // relação de 1 pra 1, tipo chave estranheira com a tabela usuario
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;
    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}

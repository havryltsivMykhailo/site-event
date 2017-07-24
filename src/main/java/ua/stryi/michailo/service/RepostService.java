package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.Article;
import ua.stryi.michailo.entity.Repost;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface RepostService {
public void add(Article article, Integer id);
public void delete(Integer id);
public List<Repost> getAll(Integer id);
public Repost findById(Integer id);
}

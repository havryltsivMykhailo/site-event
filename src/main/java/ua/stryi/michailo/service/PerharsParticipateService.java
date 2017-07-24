package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.PerhapsParticipate;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface PerharsParticipateService {
    public Integer participateUserEvent(Integer userEvent);
    public Integer getParticipateUserEventLength(Integer id);
    public List<PerhapsParticipate> getListLikeUserEvent(Integer id);
}

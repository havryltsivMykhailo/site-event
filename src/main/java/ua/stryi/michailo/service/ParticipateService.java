package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.Participate;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface ParticipateService {
    public Integer participateUserEvent(Integer userEvent);
    public Integer getParticipateUserEventLength(Integer id);
    public List<Participate> getListLikeUserEvent(Integer id);
    public List<Participate> getListParticipate();
    public List<Participate> myFriendsParticipate();
}

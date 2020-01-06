package liangliang.bigdata.service;

import liangliang.bigdata.entity.User;

/**
 * 用户服务
 */
public interface IUserService {
    User findUserByName (String userName);
}

package cz.morosystems.phase3.dao;

import java.util.List;
import cz.morosystems.phase3.entity.UserEntity;

public interface UserDAO {
	public UserEntity getUser(Integer id);
    public List<UserEntity> getAllUsers();
    public void addUser(UserEntity user);
    public void deleteUser(Integer userId);
}
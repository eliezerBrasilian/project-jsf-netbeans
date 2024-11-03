package app.repositories;

import _jpa.BaseRepository;
import app.entities.UserEntity;

public class UserRepository extends BaseRepository<UserEntity> {

    public UserRepository() {
        super(UserEntity.class);
    }
}

package ru.geekbrains.watch.market.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.watch.market.model.Role;

@Repository
@Profile("dao")
public interface RoleRepository extends CrudRepository<Role, Long> {
}

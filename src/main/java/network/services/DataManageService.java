package network.services;

import network.entity.Model;

import java.math.BigInteger;

public interface DataManageService<T extends Model> {

    T create(T model);

    T read(BigInteger id);

    void update(T model);

    void delete(T model);
}

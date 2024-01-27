package com.s27144.Bank;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserStorage userStorage;

    public UserService(UserStorage storage)
    {
        this.userStorage = storage;
    }
    public User registerUser(double startSaldo,String imie, String nazwisko)
    {
        User newUser = new User(userStorage.getListaUser().size(),startSaldo, imie, nazwisko);
        userStorage.addUser(newUser);
        return newUser;
    }

    public Optional<User> findUserByID(int id) {
        return userStorage.getListaUser().stream()
                .filter(user -> user.getId()==id)
                .findFirst();
    }
    public User getUserInfo(int id)
    {
        User userByID = findUserByID(id).orElse(null);
        if(userByID == null)
        {
            return null;
        }
        System.out.println(userByID.getImie());
        System.out.println(userByID.getNazwisko());
        System.out.println(userByID.getSaldo());
        return userByID;
    }
    public ReturnInfoObject sendTransfer(int id, double value)
    {
        User userByID = findUserByID(id).orElse(null);
        if(userByID == null){
            return new ReturnInfoObject(1,0);
        }
        if(userByID.getSaldo() < value){
            return new ReturnInfoObject(2, userByID.getSaldo());
        }
        userByID.removeBalance(value);
        return new ReturnInfoObject(0, userByID.getSaldo());
    }

    public ReturnInfoObject receiveTransfer(int id, double value)
    {
        User userByID = findUserByID(id).orElse(null);
        if(userByID == null){
            return new ReturnInfoObject(1,0);
        }
        userByID.addBalance(value);
        return new ReturnInfoObject(0, userByID.getSaldo());
    }


}
package com.example.RestTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class UserService {
HashMap<Integer,User> datastore;
    public UserService(){
        datastore=new HashMap<>();
        User user=new User(1,"Ramu",55);
        user.setAge(100);
        user.setId(1);
        user.setName("Ramu");
        datastore.put(1,user);
    }
    public User deleteAUser(int id){
        return datastore.remove(id);
    }
    public User findAUser(int id)
    {
        return datastore.get(id);
    }
    public User addAUser(User user)
    {
//        ArrayList<User> list=new ArrayList<>();
//        list.
        datastore.put(user.getId(),user);
        return user;
    }
    public List<User> findAll(){
        ArrayList<User> list=new ArrayList<>();
        for(Map.Entry<Integer,User> entry: datastore.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}

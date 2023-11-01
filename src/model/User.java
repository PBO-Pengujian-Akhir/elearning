package model;
/**
 *
 * @author fauza
 */
public abstract class User {
    private final String idUser;
    private final String name;
    private final String password;

    public User(String idUser, String name, String password){
        this.idUser = idUser;
        this.name = name;
        this.password = password;
    }


    public abstract String getRole();
}

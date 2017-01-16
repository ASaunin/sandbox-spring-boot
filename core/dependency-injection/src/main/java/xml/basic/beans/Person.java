package xml.basic.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

@Data
@ToString
public class Person implements InitializingBean, DisposableBean {

    private String firstName;
    private String lastName;
    private int age;
    private int taxId;
    private List<Contact> contacts;

    @Override
    public void afterPropertiesSet() throws Exception {
        //InitializingBean interface implements bean initialisation handler
    }

    @Override
    public void destroy() throws Exception {
        //DisposableBean interface implements bean destruction handler
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}

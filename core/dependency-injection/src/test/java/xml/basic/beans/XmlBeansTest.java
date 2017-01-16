package xml.basic.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:basic-beans.xml")
public class XmlBeansTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void singletonBeanReturnsTheSameObject() throws Exception {
        final Person person1 = context.getBean("person", Person.class);
        final Person person2 = context.getBean("person", Person.class);
        assertThat(person1, is(person2));
        assertTrue(person1 == person2);

    }

    @Test
    public void prototypeBeanReturnsTheDifferentObject() throws Exception {
        final Person person1 = context.getBean("prototypePerson", Person.class);
        final Person person2 = context.getBean("prototypePerson", Person.class);
        assertThat(person1, is(person2));
        assertFalse(person1 == person2);
        assertFalse(person1.getContacts() == person2.getContacts());
    }

}

package com.dev.zhouhua.mapstruct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.Assert;



/**
 * @author jiangyanyan
 * @since 2019/7/28 下午8:31
 */
public class PersonConverterTest {


    public static void main(String args []) {
        Person person = new Person(1L,"zhige","zhige.me@gmail.com",new Date(),new User(1));
        PersonDTO personDTO = PersonConverter.INSTANCE.domain2dto(person);
        System.out.println(personDTO.getAge());
        Assert.notNull(personDTO,"参数空");
        Assert.isTrue(personDTO.getId().equals(person.getId()),"不相等");
//        assertEquals(personDTO.getName(), person.getName());
//        assertEquals(personDTO.getBirth(), person.getBirthday());
//        String format = DateFormatUtils.format(personDTO.getBirth(), "yyyy-MM-dd HH:mm:ss");
//        assertEquals(personDTO.getBirthDateFormat(),format);
//        assertEquals(personDTO.getBirthExpressionFormat(),format);

        List<Person> peopleList = new ArrayList<>();
        peopleList.add(person);
        List<PersonDTO> personDTOs = PersonConverter.INSTANCE.domain2dto(peopleList);
        personDTOs.forEach(DTO -> System.out.println(DTO.getAge()));
//        assertNotNull(personDTOs);
    }
}


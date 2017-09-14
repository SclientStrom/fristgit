package com.spring4.test;

import com.spring4.entity.Company;
import com.spring4.entity.Employee;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class BeanWrapperTest {
    @Test
    public void test(){
        BeanWrapperImpl company = new BeanWrapperImpl(new Company());
        company.setPropertyValue("name","Some Company Inc.");
        PropertyValue value=new PropertyValue("name","Some Company Inc.");
        company.setPropertyValue(value);
        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

// retrieving the salary of the managingDirector through the company
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        System.out.println(company);
        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("1 + 1").getValue(Integer.class));
    }
}

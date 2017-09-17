package com.bookshop;

import com.bookshop.helpTests.ListIsEmptyException;
import com.bookshop.helpTests.ListIsNotEmptyException;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ListIsEmptyException.class,
        ListIsNotEmptyException.class
    }
)
public class TestGroup {

}

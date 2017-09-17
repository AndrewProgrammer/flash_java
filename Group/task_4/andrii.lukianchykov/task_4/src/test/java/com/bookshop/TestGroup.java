package com.bookshop;

import com.bookshop.helpTests.ListIsEmptyException;
import com.bookshop.helpTests.ListIsNullException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ListIsEmptyException.class,
        ListIsNullException.class
    }
)
public class TestGroup {

}

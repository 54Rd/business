package org.business;

import org.business.Utils.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangz on 2016/12/14.
 */
public class JavaTest {

    @Test
    public void testStringUtil(){
        Assert.assertEquals(true,StringUtils.anyEmpty(null,"123","",""));
        Assert.assertEquals(false,StringUtils.anyEmpty("123","2","3"));
    }


}

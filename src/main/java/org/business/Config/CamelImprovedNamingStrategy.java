package org.business.Config;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;

import java.io.Serializable;

/**
 * Created by wangz on 2016/12/11.
 */
public class CamelImprovedNamingStrategy extends ImprovedNamingStrategy
        implements Serializable {

    @Override
    public String propertyToColumnName(String propertyName) {
        return propertyName.toLowerCase().replace("_","");
    }

    @Override
    public String columnName(String columnName) {
        return columnName.toLowerCase().replace("_","");
    }
}

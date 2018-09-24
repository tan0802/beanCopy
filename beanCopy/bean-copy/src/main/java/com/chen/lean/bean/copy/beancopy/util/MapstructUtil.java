package com.chen.lean.bean.copy.beancopy.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MapstructUtil {
 
    public String asString(Date date) {
        return date != null ? new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" )
            .format( date ) : "";
    }
 
    public Date asDate(String date) {
        try {
            return !"".equals(date) && date != null ? new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" )
                .parse( date ) : null;
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
    }

    public String convertString(BigDecimal amount){
        if(amount == null){
            return "";
        }
        return amount.setScale(2, BigDecimal.ROUND_DOWN).toString();
    }
}


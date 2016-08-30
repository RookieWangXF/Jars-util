package cn.rookie.filter;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * Created by Rookie on 2016/8/30.
 * Package_name is cn.rookie.filter
 * Description:自定义一个过滤器
 */
public class SampleFilter extends Filter<ILoggingEvent>{

    @Override
    public FilterReply decide(ILoggingEvent event) {
        String message = event.getMessage();
        Level level = event.getLevel();
        if (message != null && message.contains("rookie")) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.DENY;
        }
    }
}

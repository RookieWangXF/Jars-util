package cn.rookie.filter;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Created by Rookie on 2016/8/30.
 * Package_name is cn.rookie.filter
 * Description:自定义一个TurboFilter
 */
public class SampleTurboFilter extends TurboFilter{

    String marker;
    Marker markerToAccept;

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {

        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        if ((markerToAccept.equals(marker))) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.NEUTRAL;
        }
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    @Override
    public void start() {
        if (marker != null && marker.trim().length() > 0) {
            markerToAccept = MarkerFactory.getMarker(marker);
        }
        super.start();
    }
}

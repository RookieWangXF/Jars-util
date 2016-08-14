package cn.rookie.base;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Rookie on 2016/8/12.
 * Package_name is cn.rookie.base
 * Description:
 */
public class WombatTest {



    @org.junit.Test
    public void setTemperature() throws Exception {

        Wombat wombat = new Wombat();
        wombat.setTemperature(60);
    }

}
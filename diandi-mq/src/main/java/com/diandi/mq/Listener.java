package com.diandi.mq;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.text.DecimalFormat;

/**
 * Created by lenli on 2016/5/12.
 */
public class Listener implements MessageListener {
    public void onMessage(Message message) {
        try {
            MapMessage map = (MapMessage)message;
            String stock = map.getString("stock");
            double price = map.getDouble("price");
            double offer = map.getDouble("offer");
            boolean up = map.getBoolean("up");
            DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
            System.out.println(stock + "\t" + df.format(price) + "\t" + df.format(offer) + "\t" + (up?"up":"down"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

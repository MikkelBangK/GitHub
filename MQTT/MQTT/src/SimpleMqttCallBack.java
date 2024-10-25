//opg7pgm

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
public class SimpleMqttCallBack implements MqttCallback {
    int status = 0;
    public String topic = "cmnd/grp3336/SENSOR";
    public String topic2 = "cmnd/grp3336/STATE";
    String pwr;
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String res= new String(mqttMessage.getPayload());
        // res indeholder en mÂling som et JSON-object
        // put real stuff here     < --------    !!!!!!!!!!
        //
    JSONObject jo = new JSONObject(res);
    JSONObject jo2 = jo.getJSONObject("AM2301");
    double temperatur = jo2.getDouble("Temperature");
    double humidity = jo2.getDouble("Humidity");
    pwr = jo2.getString("POWER");
    System.out.println("Temperature is: " + temperatur + "\n" + "Humidity is: " + humidity);

    if (humidity > 30 &&  pwr.equals("OFF")){
        MQTTprogram.publishMessage(MQTTprogram.sampleClient, topic, "1");
        System.out.println("Blæser tændes");
    } if (humidity > 25 && pwr.equals("ON")) {
        MQTTprogram.publishMessage(MQTTprogram.sampleClient, topic, "0");
        System.out.println("Blæser slukkes");
    }

    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }
} 
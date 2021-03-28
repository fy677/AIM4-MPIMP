package aim4.msg.i2v;

import aim4.config.Constants;

public class CancelI2V extends I2VMessage{
    private int destinationID;

    public CancelI2V(int sourceID, int vin) {
        // Set the source and destination
        super(sourceID, vin);
        messageType = Type.CANCEL;
        size += 8;
    }

}

package aim4.im.v2i.reservation;

import aim4.config.Constants;
import aim4.driver.Driver;
import aim4.im.Intersection;
import aim4.im.v2i.V2IManager;
import aim4.msg.i2v.CancelI2V;
import aim4.util.TiledArea;
import aim4.vehicle.BasicAutoVehicle;
import aim4.vehicle.VehicleUtil;
import aim4.vehicle.VinRegistry;

import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class MPIMPReservationGridManager extends ReservationGridManager {


    /**
     * Create a reservation grid manager.
     *
     * @param config           the configuration of the grid manager
     * @param intersection     the intersection
     * @param tiledArea        the tiled area
     * @param reservationGrid  the reservation grid
     */
    public MPIMPReservationGridManager(Config config,
                                  Intersection intersection,
                                  TiledArea tiledArea,
                                  ReservationGrid reservationGrid,
                                  V2IManager V2IM) {
        super(config, intersection, tiledArea, reservationGrid,V2IM);
    }

}

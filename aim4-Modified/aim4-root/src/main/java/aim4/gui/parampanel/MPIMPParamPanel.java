package aim4.gui.parampanel;

import aim4.gui.component.LabeledSlider;
import aim4.sim.setup.BasicSimSetup;

import javax.swing.*;

public class MPIMPParamPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    LabeledSlider trafficRateSlider;
    LabeledSlider speedLimitSlider;
    LabeledSlider stopDistToIntersectionSlider;
    LabeledSlider lanesPerRoadSlider;
    LabeledSlider singleOccupancySpawnRateSlider;
    LabeledSlider doubleOccupancySpawnRateSlider;
    LabeledSlider tripleOccupancySpawnRateSlider;
    LabeledSlider quadrupleOccupancySpawnRateSlider;
    JCheckBox priorityInheritanceToggle;

    /**
     * Create the autonomous driver only simulation parameter panel.
     *
     * @param simSetup  the simulation setup
     */
    public MPIMPParamPanel(BasicSimSetup simSetup) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // create the components

        trafficRateSlider =
                new LabeledSlider(0.0, 2500.0,
                        simSetup.getTrafficLevel() * 3600.0,
                        500.0, 100.0,
                        "Traffic Level: %.0f vehicles/hour/lane",
                        "%.0f");
        add(trafficRateSlider);

        speedLimitSlider =
                new LabeledSlider(0.0, 50.0,
                        simSetup.getSpeedLimit(),
                        10.0, 1.0,
                        "Speed Limit: %.0f meters/second",
                        "%.0f");
        add(speedLimitSlider);

        stopDistToIntersectionSlider =
                new LabeledSlider(0.0, 50.0,
                        simSetup.getStopDistBeforeIntersection(),
                        10.0, 1.0,
                        "Stopping Distance Before Intersection: %.0f meters",
                        "%.0f");
        add(stopDistToIntersectionSlider);


        lanesPerRoadSlider =
                new LabeledSlider(1.0, 8.0,
                        simSetup.getLanesPerRoad(),
                        1.0, 1.0,
                        "Number of Lanes per Road: %.0f",
                        "%.0f");
        add(lanesPerRoadSlider);


        singleOccupancySpawnRateSlider =
                new LabeledSlider(0.0, 10.0,
                        1,
                        1.0, 0.5,
                        "Relative spawn rate of single occupancy vehicles: %.1f",
                        "%.0f");
        add(singleOccupancySpawnRateSlider);

        doubleOccupancySpawnRateSlider =
                new LabeledSlider(0.0, 10.0,
                        1,
                        1.0, 0.5,
                        "Relative spawn rate of single occupancy vehicles: %.1f",
                        "%.0f");
        add(doubleOccupancySpawnRateSlider);

        tripleOccupancySpawnRateSlider =
                new LabeledSlider(0.0, 10.0,
                        1,
                        1.0, 0.5,
                        "Relative spawn rate of single occupancy vehicles: %.1f",
                        "%.0f");
        add(tripleOccupancySpawnRateSlider);

        quadrupleOccupancySpawnRateSlider =
                new LabeledSlider(0.0, 10.0,
                        1,
                        1.0, 0.5,
                        "Relative spawn rate of single occupancy vehicles: %.1f",
                        "%.0f");
        add(quadrupleOccupancySpawnRateSlider);

        priorityInheritanceToggle =
                new JCheckBox("Enable Priority Inheritance",false);
        add(priorityInheritanceToggle);
    }



    /**
     * Get the traffic rate.
     *
     * @return the traffic rate
     */
    public double getTrafficRate() {
        return trafficRateSlider.getValue() / 3600.0;
    }

    /**
     * Get the speed limit.
     *
     * @return the speed limit
     */
    public double getSpeedLimit() {
        return speedLimitSlider.getValue();
    }

    /**
     * Get the stop distance to intersection.
     *
     * @return the stop distance to intersection
     */
    public double getStopDistToIntersection() {
        double d = stopDistToIntersectionSlider.getValue();
        return (d < 1.0)?1.0:d;
    }


    /**
     * Get the number of lanes per road.
     *
     * @return the number of lanes per road
     */
    public int getLanesPerRoad() {
        return (int)lanesPerRoadSlider.getValue();
    }

    public double getSingleOccupancyVehicleSpawnRate(){
        return singleOccupancySpawnRateSlider.getValue();
    }

    public double getDoubleOccupancyVehicleSpawnRate(){
        return doubleOccupancySpawnRateSlider.getValue();
    }

    public double getTripleOccupancyVehicleSpawnRate(){
        return tripleOccupancySpawnRateSlider.getValue();
    }

    public double getQuadrupleOccupancyVehicleSpawnRate(){
        return quadrupleOccupancySpawnRateSlider.getValue();
    }

    public double[] getVehicleSpecSpawnRate(){
        double single = getSingleOccupancyVehicleSpawnRate();
        double doub = getDoubleOccupancyVehicleSpawnRate();
        double triple = getTripleOccupancyVehicleSpawnRate();
        double quad = getQuadrupleOccupancyVehicleSpawnRate();

        double[] spawnRates = {single,doub,triple,quad};
        return spawnRates;
    }

    public boolean getPriorityInheritance(){
        return priorityInheritanceToggle.isSelected();
    }
}

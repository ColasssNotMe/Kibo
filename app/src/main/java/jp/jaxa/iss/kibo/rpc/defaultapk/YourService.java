package jp.jaxa.iss.kibo.rpc.defaultapk;

import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;
import gov.nasa.arc.astrobee.types.Point;
import org.opencv.core.Mat;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {

    //plan 1
    @Override
    protected void runPlan1() {
        api.startMission();
        Point point = new Point(0, 0, 0);
        api.moveTo(point,null, false);
        Mat image = api.getMatNavCam();
            if(image==null){
                api.flashlightControlFront(80);
            }else{
                api.flashlightControlFront(10);
                api.getMatNavCam();
            }


    }

    @Override
    protected void runPlan2() {
        // write your plan 2 here
    }

    @Override
    protected void runPlan3() {
        // write your plan 3 here
    }

}


package jp.jaxa.iss.kibo.rpc.defaultapk;

import android.os.Environment;

import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;
import gov.nasa.arc.astrobee.types.Point;

//import open cv libraries
import org.opencv.core.Mat;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.List;


/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {

    //plan 1
    @Override
    protected void runPlan1() {
        api.startMission();
        Point point = new Point(0, 0, 0);
        api.moveTo(point, null, true);

        //log the image
        Mat image = api.getMatNavCam();

        //take a picture and save it
        api.flashlightControlFront(10);
        api.getMatNavCam();
        api.saveMatImage(image, "tempImage.png");

        //load images
        String tempImage = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tempImage.png";
        String hammerImage = Environment.getExternalStorageDirectory().getAbsolutePath() + "/hammer.png";
        String kaptonTape = Environment.getExternalStorageDirectory().getAbsolutePath() + "/kapton_tape.png";
        String goggle = Environment.getExternalStorageDirectory().getAbsolutePath() + "/goggle.png";
        String pipette = Environment.getExternalStorageDirectory().getAbsolutePath() + "/pipette.png";
        String screwDriver = Environment.getExternalStorageDirectory().getAbsolutePath() + "/screwdriver.png";
        String thermometer = Environment.getExternalStorageDirectory().getAbsolutePath() + "/thermometer.png";
        String top = Environment.getExternalStorageDirectory().getAbsolutePath() + "/top.png";
        String watch = Environment.getExternalStorageDirectory().getAbsolutePath() + "/watch.png";
        String wrench = Environment.getExternalStorageDirectory().getAbsolutePath() + "/wrench.png";


        //func to convert to grayscale
        Mat img1 = Imgcodecs.imread(tempImage, Imgcodecs.IMREAD_GRAYSCALE);
        Mat img2 = Imgcodecs.imread(hammerImage, Imgcodecs.IMREAD_GRAYSCALE);
    }

        @Override
        protected void runPlan2() {
            // write your plan 2 here
        }

        @Override
        protected void runPlan3 () {
            // write your plan 3 here
        }

    }


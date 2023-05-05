
/***********************************************************************
*                                                                      *
* OnbotJava Editor is still : beta! Please inform us of any bugs      *
* on our discord channel! https://discord.gg/e7nVjMM                   *
* Only BLOCKS code is submitted when in Arena                          *
*                                                                      *
***********************************************************************/


public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor frontRightDrive;
    DcMotor backLeftDrive;
    DcMotor backRightDrive;
    DcMotor frontLeftDrive;
    DcMotor motorArm;
    Servo grabber;
    BNO055IMU imu;
 

    public void R(int v){
        backRightDrive.setPower(v);
        frontRightDrive.setPower(v);
    }
    
    public void L(int v){
        backLeftDrive.setPower(v);
        frontLeftDrive.setPower(v);
    }
    public void go(int ms) {
        // ms - amount of time to go
        L(1);
        R(1);
        sleep(ms);
        stop();
        sleep(200);
    }
    
    public void rotate(int deg, boolean is_cc) {
        double ms = deg *(6.5 + (1/3));
        ms = ms / 2;
        if (is_cc) {
            L(-1);
            R(1);
        } else {
            L(1);
            R(-1);
        }

        sleep(ms);
        L(0);
        R(0);
        sleep(100);
    }
    
    public void stop(){
        R(0);
        L(0);
    }
    public void upd(){
        telemetry.addData("Red", color1.red());
        telemetry.addData("Blue", color1.blue());
        telemetry.addData("Green", color1.green());
        telemetry.update();
    }

    public void grab(int pos) {
        grabber.setPosition(pos);
        sleep(500);
    }

    public void back(int ms) {
        L(-1);
        R(-1);
        sleep(ms);
        stop();
        sleep(200);
    }

    public void go_wall() {
        while (distance1.getDistance(DistanceUnit.CM) > 80) {
          go(1);
          upd();
      }
   }
   
   public void left() {
       rotate(96, true);
   }
   
   public void right() {
        rotate(96, false);
   }
   public void arm(int pos, int stinkyassfuckface) {
       // -1 down, 1 up
       motorArm.setPower(pos);
       sleep(stinkyassfuckface);
       motorArm.setPower(0);
   }

@Override
    public void runOpMode() {
      frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
      backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
      backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
      frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
      motorArm = hardwareMap.get(DcMotor.class, "motorArm");
      grabber = hardwareMap.get(Servo.class, "grabber");
      imu = hardwareMap.get(BNO055IMU.class, "imu");
      // Put initialization blocks here
      waitForStart();
      
      
      
      
      
      
      
      
      
      
      
      
      // Put run blocks here
      /*
      PYLON 1
      */
      rotate(45, true);
      arm(1,300);
      go(350);
      arm(-1,300);
      grabber.setPosition(-1);
      arm(1,300);
      rotate(5, true);
      go(300);
      grabber.setPosition(1);
      sleep(200);
      /*
      PYLON 2
      */
      grabber.setPosition(-1);
      sleep(60);
      back(220);
      rotate(40, true);
      go(550);
      rotate(45,true);
      go(100);
      rotate(65,true);
      

      go(360);
      arm(-1,200);
      arm(1,300);
      rotate(20,true);
      back(200);
      left();
      rotate(65,true);
      go(300);
      grab(1);
      back(200);
      left();
      rotate(94,true);
      go(200);
      
      
      while (opModeIsActive()) {
        // Put loop blocks here
      }
    }
    
}
